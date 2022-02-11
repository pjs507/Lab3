import greenfoot.*;

public class Animations extends Player
{
    private GreenfootImage[] imagesR;
    private GreenfootImage[] imagesL;
    private GreenfootImage[] imagesUp;
    private GreenfootImage[] upMirrored;
    private GreenfootImage[] imagesDown;
    private GreenfootImage[] downMirrored;
    private GreenfootImage[] idle;
    
    public static final int GROUND = 465;
    private int currentImageR = 0;
    private int currentImageL = 0;
    private int currentImageUp = 0;
    private int currentImageDown = 0;
    private int currentImageIdle = 0;
    
    private int imageBuffer = 3;
    private int idleBuffer = 8;
    
    
    
    public Animations (String basename, String suffix, int noImagesR, int noImagesL,
        int noImagesUp, int noImagesDown, int noImagesIdle)
    {
        imagesR = new GreenfootImage[noImagesR];
        imagesL = new GreenfootImage[noImagesL];
        imagesUp = new GreenfootImage[noImagesUp];
        upMirrored = new GreenfootImage[noImagesUp];
        imagesDown = new GreenfootImage[noImagesDown];
        downMirrored = new GreenfootImage[noImagesDown];
        idle = new GreenfootImage[noImagesIdle];
        
        for (int i = 0; i < noImagesR; i++) {
            imagesR[i] = new GreenfootImage(basename + 'R' + Integer.toString(i) + suffix);
        }
        
        for (int i = 0; i < noImagesL; i++) {
            imagesL[i] = new GreenfootImage(basename + 'L' + Integer.toString(i) + suffix);
        }
        
        for (int i = 0; i < noImagesUp; i++) {
            imagesUp[i] = new GreenfootImage(basename + 'U' + Integer.toString(i) + suffix);
            upMirrored[i] = new GreenfootImage(basename + 'U' + Integer.toString(i) + suffix);
            upMirrored[i].mirrorHorizontally();
        }
        
        for (int i = 0; i < noImagesDown; i++) {
            imagesDown[i] = new GreenfootImage(basename + 'D' + Integer.toString(i) + suffix);
            downMirrored[i] = new GreenfootImage(basename + 'D' + Integer.toString(i) + suffix);
            downMirrored[i].mirrorHorizontally();
        }
        
        for (int i = 0; i < noImagesIdle; i++) {
            idle[i] = new GreenfootImage(basename + "Idle" + Integer.toString(i) + suffix);
        }
        
        setImage(imagesR[currentImageR]);
    }
    
    public boolean animateIdle()
    {
        if (idleBuffer < 1) {
            idleBuffer = 21;
            return true;
        }
        else
            idleBuffer--;
        
        return false;
    }
    
    public boolean animateBuffer()
    {
        if (imageBuffer < 1) {
            imageBuffer = 5;
            return true;
        }
        else
            imageBuffer--;
        
        return false;
    }
    
    public void animate()
    {
        if (Greenfoot.isKeyDown("W")) {
            if (animateBuffer())
                currentImageUp = (currentImageUp + 1) % imagesUp.length;
            if (Greenfoot.isKeyDown("A"))
                setImage(upMirrored[currentImageUp]);
            else
                setImage(imagesUp[currentImageUp]);
            currentImageDown = 0;
        }
        else if (Greenfoot.isKeyDown("D")) {
            if (animateBuffer())
                currentImageR = (currentImageR + 1) % imagesR.length;
            
            setImage(imagesR[currentImageR]);
            currentImageDown = 0;
        }
        else if (Greenfoot.isKeyDown("A")) {
            if (animateBuffer())
                currentImageL = (currentImageL + 1) % imagesL.length;
            
            setImage(imagesL[currentImageL]);
            currentImageDown = 0;
        }
        else if (Greenfoot.isKeyDown("S")) {
            if (animateBuffer() && currentImageDown == 0)
                currentImageDown = (currentImageDown + 1) % imagesDown.length;
            
            setImage(imagesDown[currentImageDown]);
        }
        else {
            if (animateIdle())
                currentImageIdle = (currentImageIdle + 1) % idle.length;
            
            setImage(idle[currentImageIdle]);
            currentImageDown = 0;
        }
    }
    
    public void act()
    {
        animate();  
    }
}
