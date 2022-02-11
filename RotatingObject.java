import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RotatingObject extends Actor
{
    private String direction;
    
    public RotatingObject(String dir)
    {
        direction = dir;
    }
    public void act()
    {
        // Add your action code here.
        if (direction.equals("left"))
        {
            turn(-5);
            setLocation(getX() - 10, getY());
        }
        else
        {
            turn(5);
            setLocation(getX() + 10, getY());
        }
        
        if (isAtEdge()) {
            if (getWorld() != null) {
                if(this instanceof Horseshoe){
                    
                }
                else{
                                    (getWorld()).removeObject(this);

                }
            }  
        }
    }
}
