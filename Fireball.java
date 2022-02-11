import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fireball extends RotatingObject
{
    public Fireball(String dir)
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
