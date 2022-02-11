import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThoughtBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThoughtBubble extends AnimatedActor
{
    /**
     * Act - do whatever the ThoughtBubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final int HOVER_AMOUNT = 10;
    private Actor attachedTo;
    private GreenfootImage image;
    private double timer;
    private long startTime;
    private String picture;
    
    public ThoughtBubble(String text, Actor a, double timer)
    {
        this.attachedTo = a;
        image = new GreenfootImage(text);
        picture = text;
        this.setImage(image);
        this.timer = timer * 1000;
        this.startTime = System.currentTimeMillis();
    }
    public void act()
    {
        super.act();
        if(picture == "starting-play.png"){
            setLocation(450, 300);
            if(Greenfoot.getKey() != null){
                getWorld().removeObject(this);
            }
        }
        else{
            setLocation(attachedTo.getX() + HOVER_AMOUNT * 2,
            attachedTo.getY() - attachedTo.getImage().getHeight());
        }
        checkExpiration();
    }
    
    public void animate(){
        int xPos = super.getX();
        int yPos = super.getY();
        System.out.println("X: " + (super.getX()) + "   Y: " + super.getY());
        setLocation(xPos , yPos );

    }
    
    
    private void checkExpiration() {
        if (System.currentTimeMillis() > startTime + timer || Greenfoot.getKey() == "z") {
            getWorld().removeObject(this);
        }
    }
}
