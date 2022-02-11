import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hawk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hawk extends FlyingAdversary
{
    /**
     * Act - do whatever the Hawk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Hawk()
    {
        super.health = 5;
    }
    
    
    public void act()
    {
        // Add your action code here.
        if (frame % 150 == 0) {
            getWorld().addObject(new Shuriken("left"), getX(), getY());
            frame = 1;
        }
        super.act();
    }
}
