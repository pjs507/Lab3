import greenfoot.*;

public class Back extends Buttons
{
    public Back() {
        GreenfootImage backButton = new GreenfootImage(170, 60);
        Font adjustedFont = new Font(true, false, 50);
        backButton.setFont(adjustedFont);
        backButton.setColor(Color.BLACK);
        backButton.drawString("Back", 0, 50);
        setImage(backButton);
    }
    
    public void act()
    {
        // Reset the location every frame to match the scrolling background. 
        setLocation(this.getX() + 1, this.getY());
        checkMouse();
        checkClick(new MainMenu());
    }
}
