import greenfoot.*;  

public class HealthBar extends CowboyHat
{
    public int health = 10;
    int healthBarWidth = 80;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int) healthBarWidth / health;

    public HealthBar() {
        update();
    }
    
    public void act()
    {
        setLocation(getXPos() - getX() + 75, 80);
        update();
        if (health == 0) {
            Greenfoot.stop();
            GameOver();
        }
    }
    
    public void GameOver() {
        GreenfootImage gameOver = new GreenfootImage(470, 160);
        Font adjustedFont = new Font(true, false, 35);
        gameOver.setFont(adjustedFont);
        gameOver.setColor(Color.BLACK);
        gameOver.drawString("GAME OVER", 260, 150);
        setImage(gameOver);
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
        myImage.fillRect(1, 1, health * pixelsPerHealthPoint, healthBarHeight);
    }
}
