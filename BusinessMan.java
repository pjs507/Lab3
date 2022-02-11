import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BusinessMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BusinessMan extends StationaryAdversary
{
    /**
     * Act - do whatever the BusinessMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BusinessMan(){
        super.health = 15;
    }
    
    public void act()
    {
        setLocation(700, 500);

        if (frame % 150 == 0) {
            getWorld().addObject(new Money("left"), getX(), getY());
            frame = 1;
        }
        super.act();
        // Add your action code here.
    }
}
