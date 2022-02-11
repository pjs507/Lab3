import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlyingAdversary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlyingAdversary extends Adversary
{
    /**
     * Act - do whatever the FlyingAdversary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        
    public void act()
    {
        if (duration <= 0) {
            duration = Greenfoot.getRandomNumber(maxDuration);
            if (Greenfoot.getRandomNumber(2) == 1)
                direction = -1;
            else
                direction = 1;
        }
        
        
        
        duration--;
        frame++;
        setLocation(getX(), getY() + direction);
        
        if (getY() <= 150)
            direction = 1;
        if (getY() >= getWorld().getHeight() - 250)
            direction = -1;
            
        super.act();
        // Add your action code here.
    }
}
