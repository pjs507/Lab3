import greenfoot.*; 

public class MainMenu extends World
{
    public static final int WIDE = 800;
    public static final int HIGH = 600;
    public static final int GROUND = 465;

    private Scroller scroller;
    private Sound sound;
    
    // For title animation purposes
    private int dummy_i = 0, dummy_j = 0, change_after_fps = 50;
    private Picture title_img1, title_img2, current_title_img;

    public MainMenu()
    {   
        super(WIDE, HIGH, 1, false);
        GreenfootImage image = new GreenfootImage("Desert.jpg");
                
        initializeGameTitle();
        
        scroller = new Scroller(this, image);

        prepare();
    }

    public void act() {
        scroll();   
        animateGameTitle(); 

    }
    
    /* 
     * Initializes variables for game title animation. 
     */
    private void initializeGameTitle() {
        GreenfootImage img1 = new GreenfootImage("logo_orange.png");
        GreenfootImage img2 = new GreenfootImage("logo_red.png");

        title_img1 = new Picture(img1);
        title_img2 = new Picture(img2);
        current_title_img = title_img1;
        addObject(current_title_img, getWidth() / 2, 250);        
    }
    
    /*
     * Animates game title by swapping two images after every
     * change_after_fps frames. 
     * 
     * Logic: dummy_i starts off as 0 and every frames gets incremented
     *        by 1. At 50, it reset to 0 and current images swaps. 
     *        New image is picked off of dummy_j's value: 0 and 1. 
    */
    private void animateGameTitle() {
        dummy_i++;
        dummy_i %= change_after_fps;
        if (dummy_i == 0) {
            dummy_j++;
            dummy_j %= 2;
            // The old image is removed and replaced with a new image every 
            // frame to keep the title in 1 spot after scrolling. 
            if (dummy_j == 1) {
                removeObject(current_title_img);
                current_title_img = title_img2;
            }
            else {
                removeObject(current_title_img);
                current_title_img = title_img1;
            }
        }
        removeObject(current_title_img);
        addObject(current_title_img, getWidth() / 2, 250);

    }

    private void scroll() {
        int speed = 1;
        scroller.scroll(speed, 0);
    }

    private void prepare()
    {        
        /* Prepare objects */
        Play play2 = new Play();
        addObject(play2,456, 506);
        Credits credits2 = new Credits();
        addObject(credits2, 680,506);
    }
}
