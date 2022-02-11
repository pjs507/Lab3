import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int width = 300;
    private int height = 150;
    
    public TextBox() {
        GreenfootImage textImage = new GreenfootImage("Hi, I'm Cowboy Bill.", 24, new Color(255, 255, 255), new Color(0, 0, 0));
        GreenfootImage image = new GreenfootImage(textImage.getWidth() + 12, 36);
        image.setColor(new Color(173, 216, 230));
        image.fill();
        image.fillRect(3, 3, image.getWidth()-6, 30);
        image.drawImage(textImage, 6, 6);
        setImage(image);
    }
    
    public TextBox(String text) {
        GreenfootImage textImage = new GreenfootImage(text, 24, new Color(255, 255, 255), new Color(0, 0, 0));
        GreenfootImage image = new GreenfootImage(textImage.getWidth() + 12, 36);
        image.setColor(new Color(173, 216, 230));
        image.fill();
        image.setColor(new Color(173, 216, 230));
        image.fillRect(3, 3, image.getWidth()-3, 30);
        image.drawImage(textImage, 6, 6);
        setImage(image);
    }

    public void act()
    {
        // Add your action code here.
    }
}
