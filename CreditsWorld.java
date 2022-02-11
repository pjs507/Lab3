import greenfoot.*;  

public class CreditsWorld extends World
{
    public static final int WIDE = 800;
    public static final int HIGH = 600;
    public static final int GROUND = 465;
    
    private Scroller scroller;
    private Picture logo1, logo2, currentLogo;
    private Sound sound;
    
    private int i = 0, j = 0;
    
    public CreditsWorld()
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
    
    private void initializeGameTitle() {
        GreenfootImage img1 = new GreenfootImage("logo_orange.png");
        GreenfootImage img2 = new GreenfootImage("logo_red.png");

        logo1 = new Picture(img1);
        logo2 = new Picture(img2);
        currentLogo = logo1;
        addObject(currentLogo, getWidth() / 2, 250);        
    }
    
    private void animateGameTitle() {
        i++;
        i %= 50;
        if (i == 0) {
            j++;
            j %= 2;
            if (j == 1) {
                removeObject(currentLogo);
                currentLogo = logo2;
            }
            else {
                removeObject(currentLogo);
                currentLogo = logo1;
            }
        }
        removeObject(currentLogo);
        addObject(currentLogo, getWidth() / 2, 250);

    }
    
    private void scroll() {
        int speed = 1;
        scroller.scroll(speed, 0);
    }
    
        private void prepare()
    {        
        /* Prepare objects */
        Back back = new Back();
        addObject(back,456, 506);
     
    }
}
