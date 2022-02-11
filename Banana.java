import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends RotatingObject
{
    /**
     * Act - do whatever the Banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Banana(String dir)
    {
        super(dir);
    }
    
    public void act()
    {
        if (isTouching(CowboyHat.class)) {
            ((HealthBar)getWorld().getObjects(HealthBar.class).get(0)).test();
            (getWorld()).removeObject(this);
            return;
        }
        super.act();
    }
}
