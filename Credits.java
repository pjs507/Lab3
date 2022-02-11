import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Credits extends Buttons
{
    public Credits() {
        GreenfootImage creditsButton = new GreenfootImage(170, 60);
        Font adjustedFont = new Font(true, false, 50);
        creditsButton.setFont(adjustedFont);
        creditsButton.setColor(Color.BLACK);
        creditsButton.drawString("Credits", 0, 50);
        setImage(creditsButton);
    }
    public void act()
    {
        setLocation(this.getX() + 1, this.getY());
        checkMouse();
        checkClick(new CreditsWorld());
    }
}
