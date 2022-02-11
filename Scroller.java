import greenfoot.*;


public class Scroller extends Controlls
{
    private World world;
    private GreenfootImage scrollImage;
    private boolean limited;
    private int scrolledX, scrolledY;
    private int wide, high;
    
    public Scroller(World viewWorld, GreenfootImage image) {
        world = viewWorld;
        scrollImage = image;
        
        if (image != null) {
            wide = image.getWidth();
            high = image.getHeight();
        }
        scroll(0, 0);
    }
    
    public Scroller(World viewWorld, GreenfootImage image, int wide, int high) {
        this.wide = wide;
        this.high = high;
        limited = true;
        world = viewWorld;
        
        if (image != null) {
            scrollImage = new GreenfootImage(wide * world.getCellSize(), high * world.getCellSize());
            for (int x = 0; x < wide * world.getCellSize(); x += image.getWidth()) {
                for (int y = 0; y < high * world.getCellSize(); y += image.getHeight()) {
                    scrollImage.drawImage(image, x, y);
                }
            }
            scroll(0, 0);
        }
    }
    
    public void scroll(int dsx, int dsy) {      
        if (limited) {
            int maxX = wide - world.getWidth();
            int maxY = high - world.getHeight();
            
            if (scrolledX + dsx < 0) {
                dsx = -scrolledX;
            }
            if (scrolledX + dsx >= maxX) {
                dsx = maxX - scrolledX;
            }
            if (scrolledY + dsy < 0) {
                dsy = -scrolledY;
            }
            if (scrolledY + dsy >= maxY) {
                dsy = maxY - scrolledY;
            }
            scrolledX += dsx;
            scrolledY += dsy;
            
            if (scrollImage != null) {
                world.getBackground().drawImage(
                    scrollImage,
                    -scrolledX * world.getCellSize(),
                    -scrolledY * world.getCellSize()
                    );
            }
            System.out.println("if block");
        }
        else {
            scrolledX += dsx;
            scrolledY += dsy;
            if (scrollImage != null) {
                int imageX = scrolledX * world.getCellSize();
                int imageY = scrolledY * world.getCellSize();
                imageX = imageX % wide;
                imageY = imageY % high;
                
                if (imageX < 0) {
                    imageX += wide;
                }
                if (imageY < 0) {
                    imageY += high;
                }
                GreenfootImage hold = new GreenfootImage(scrollImage);
                hold.drawImage(scrollImage, -imageX, -imageY);
                if (imageX > 0) {
                    hold.drawImage(scrollImage, wide - imageX, -imageY);
                }
                if (imageY > 0) {
                    hold.drawImage(scrollImage, -imageX, high - imageY);
                }
                if (imageX > 0 && imageY > 0) {
                    hold.drawImage(scrollImage, wide - imageX, high - imageY);
                }
                world.setBackground(hold);
            }
        }
        for (Object obj : world.getObjects(null)) {
            Actor actor = (Actor) obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
        }
    }
    
    public int getScrolledX() {
        return scrolledX;
    }
    
    public int getScrolledY() {
        return scrolledY;
    }
    
}
