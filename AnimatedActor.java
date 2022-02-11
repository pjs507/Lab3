import greenfoot.*;

public class AnimatedActor extends Actor
{
    public static final int GROUND = 465;
    
    private GreenfootImage[] imagesR;
    private GreenfootImage[] imagesL;
    private GreenfootImage[] imagesUp;
    private GreenfootImage[] upMirrored;
    private GreenfootImage[] imagesDown;
    private GreenfootImage[] downMirrored;
    private GreenfootImage[] idle;
    
    private int currentImageR = 0;
    private int currentImageL = 0;
    private int currentImageUp = 0;
    private int currentImageDown = 0;
    private int currentImageIdle = 0;
    
    private int imageBuffer = 3;
    private int idleBuffer = 8;
    
    private double velocity = 10;
    private double altitude = 465; //345
    private double speedFactor = 10;
    private double gravity = 1.6;
    private double time = 0.0;
    
    private boolean firstJump = false;
    private boolean secondJump = false;
    public static boolean shotStatus = true;
    
    private MyWorld myWorld;
    
    public AnimatedActor() {
        
    }
    
    public AnimatedActor (String basename, String suffix, int noImagesR, int noImagesL,
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
    
    private void applyGravity()
    {
        velocity = velocity + (gravity * time);
    }
    
    private void executeJump()
    {  
        if (Greenfoot.isKeyDown("up") && !secondJump) // First jump condition
        {
            applyGravity();
            altitude += velocity/speedFactor;
            setLocation(getX(), (int)altitude);
            time += 0.01;
                
            if (getY() >= GROUND - 21) // Animation
            {
                if (Greenfoot.isKeyDown("left"))
                    setImage(downMirrored[0]);
                else
                    setImage(imagesDown[0]);
            }
            if (getY() >= GROUND) // Hit the ground, reset
            {
                if (Greenfoot.isKeyDown("left"))
                    setImage(upMirrored[0]);
                altitude = 300;
                time = 0;
                velocity = 10;
                firstJump = false;
                setLocation(getX(), (int)altitude);
            }
            secondJump = true;
        }
        else
        {
            if ("d".equals(Greenfoot.getKey()) && !firstJump && secondJump) // Check for double jump condition
            {
                if (Greenfoot.isKeyDown("left")) // Animation
                    setImage(upMirrored[0]);
                else
                    setImage(imagesUp[0]);
                    
                if (getY() >= GROUND - 21) // Animation
                {
                    if (Greenfoot.isKeyDown("left"))
                        setImage(downMirrored[0]);
                    else
                        setImage(imagesDown[0]);
                }
                altitude = altitude - 250;
                time = 0;
                velocity = 10;
                applyGravity();
                altitude += velocity/speedFactor;
                setLocation(getX(), (int)altitude);
                time += 0.01;
                secondJump = false;
            }
            
            if (altitude < GROUND) // In the air
            {
                applyGravity();
                altitude += velocity/speedFactor;
                setLocation(getX(), (int)altitude);
                time += 0.01;
            }
            else // On the ground, reset
            {
                firstJump = true;
                secondJump = false;
            }
                
                
        }
          
    }
    
    public void animate()
    {
        if (Greenfoot.isKeyDown("up") || (!secondJump && altitude < GROUND)) {
            if (animateBuffer())
                currentImageUp = (currentImageUp + 1) % imagesUp.length;
            if (Greenfoot.isKeyDown("left"))
                setImage(upMirrored[currentImageUp]);
            else
                setImage(imagesUp[currentImageUp]);
            currentImageDown = 0;
        }
        else if (Greenfoot.isKeyDown("right")) {
            if (animateBuffer())
                currentImageR = (currentImageR + 1) % imagesR.length;
            
            setImage(imagesR[currentImageR]);
            currentImageDown = 0;
        }
        else if (Greenfoot.isKeyDown("left")) {
            if (animateBuffer())
                currentImageL = (currentImageL + 1) % imagesL.length;
            
            setImage(imagesL[currentImageL]);
            currentImageDown = 0;
        }
        else if (Greenfoot.isKeyDown("down")) {
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
        executeJump();
        
    }
    
    public void checkShot()
    {
        
        if (Greenfoot.isKeyDown("s") && shotStatus) {
            if (Greenfoot.isKeyDown("left"))
                getWorld().addObject(new Horseshoe("left"), getX(), getY());
            else
                getWorld().addObject(new Horseshoe("right"), getX(), getY());
                
            shotStatus = false;
        }
        
        if (!Greenfoot.isKeyDown("s"))
            shotStatus = true;
    }
    
    public void act()
    {
        // Add your action code here.
        // animate();
        // checkShot();
        
    }
}
