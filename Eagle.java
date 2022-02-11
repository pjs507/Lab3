import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eagle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eagle extends FlyingAdversary
{
    /**
     * Act - do whatever the Eagle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 
    
    public Eagle()
    {
        health = 3;
    }
    

    
    public void act()
    {
        // Add your action code here.
        if (frame % 150 == 0) {
            getWorld().addObject(new Fireball("left"), getX(), getY());
            frame = 1;
        }
        
        super.act();
    }
}
