import greenfoot.*;  

public class AdversaryHealthBar extends Adversary
{
    public int initialHealth;
    int healthBarWidth = 80;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint;
    Adversary attachedTo;
    public AdversaryHealthBar(Adversary attachedTo) {
        this.initialHealth = attachedTo.getHealth();
        this.attachedTo = attachedTo;    
        pixelsPerHealthPoint = (int) healthBarWidth / initialHealth;

        update();
    }
    
    public void act()
    {
        setLocation(700, 100);
        update();
        if (attachedTo.getHealth() == 0) {
            getWorld().removeObject(this);
            //GameOver();
        }
        else{
            update();
        }
        
    }
    
  
    
    public void test() {
        health--;
    }
    
    public void update() {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, (attachedTo.getHealth()) * pixelsPerHealthPoint, healthBarHeight);
    }
}
