import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story extends World
{

    /**
     * Constructor for objects of class Story.
     * 
     */
    public static final int WIDE = 800;
    public static final int HIGH = 600;
    private int count = 0;
    private int textbox_width_loc = 400;
    private int textbox_height_loc = 175;
    
    
    private TextBox hello;
    private TextBox pancakes;
    private TextBox intro;
    private TextBox adventure;
    private TextBox controls;
    
    private Scroller scroller;
    public Story()
    {    
        super(WIDE, HIGH, 1, false); 
        GreenfootImage image = new GreenfootImage("Desert.jpg");
        this.setBackground("Desert.jpg");
        
        prepare();
        act();
    }
    
    public void act() {
        if ("enter".equals(Greenfoot.getKey())) {
            count++;
        }
        if (count == 0) {
            addObject(hello, textbox_width_loc, textbox_height_loc);
        }
        else if (count == 1) {
            this.removeObject(hello);
            addObject(pancakes, textbox_width_loc, textbox_height_loc);
        }
        else if (count == 2) {
            this.removeObject(pancakes);
            addObject(intro, textbox_width_loc, textbox_height_loc);
        }
        else if (count == 3) {
            this.removeObject(intro);
            addObject(adventure, textbox_width_loc, textbox_height_loc);
        }
        else if (count == 4) {
            this.removeObject(adventure);
            addObject(controls, textbox_width_loc, textbox_height_loc);
            addObject(new Instructions(), 625, 400);
        }
        else {
            this.removeObject(controls);
            count = 0;
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    private void prepare()
    {        
        /* Prepare objects */
        addObject(new IntroToCowboyBill(), 400, 250);
        
        showText("Press enter to continue", 400, 100);
        
        hello = new TextBox("Hi, I'm Cowboy Bill.");
        pancakes = new TextBox("I love pancakes.");
        intro = new TextBox("I've had enough of being the sidekick to a cowboy.");
        adventure = new TextBox("I'm ready for my own adventure!");
        controls = new TextBox("Here's what I can do!");
        
        //showText("After one too many drinks, Mimo lost all his coins!", 670, 300);
        
    }
}
