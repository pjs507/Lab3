import greenfoot.*; 

public class Buttons extends Actor
{
    private static int MAX_TRANS = 255;
    private boolean mouseOver = false;
    
    public void checkMouse() {
        if (Greenfoot.mouseMoved(null)) {
            mouseOver = Greenfoot.mouseMoved(this);
        }
        
        if (mouseOver) {
            adjustTransparency(MAX_TRANS / 2);
        }
        else {
            adjustTransparency(MAX_TRANS);
        }
    }
    
    public void checkClick(World world) {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(world);
        }
    }
    
    public void adjustTransparency(int adjust) {
        GreenfootImage img = getImage();
        img.setTransparency(adjust);
        setImage(img);
    }
}
