import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Adversary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adversary extends Actor
{
    /**
     * Act - do whatever the Adversary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int duration = 0;
    int direction = 1;
    int frame = 0;
    int maxDuration = 70;
    int x_location = 0;
    int y_location = 0;
    int health;
    
    public Adversary(){
        this.health = health;
    }
    
    public void checkCollision()
    {
        Actor collide = getOneIntersectingObject(Horseshoe.class);
       if (collide != null)
       {
           System.out.println(this.health);
           getWorld().removeObject(collide);
           
           this.health--;
          
            if (this.health == 0)
               getWorld().removeObject(this);
           
       }
    }
    
    public void act()
    {
        
        
        frame++;
        
            
        checkCollision();// Add your action code here.
    }
    
    public int getHealth(){
        return health;
    }

}
