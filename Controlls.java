import greenfoot.*;
import java.util.List;

public class Controlls extends Animations
{
    private int acceleration = 0;
    private int speed = 0;
    private Class[] barrier = new Class[0];
    private int vSpeed = 0;
    private int ground_height = 465;
    private int player_altitude;
    private int fire_reset_time = 30;
    private boolean can_fire = true;
    private int enemy_spawn_reset_time = 100;
    
    public Controlls () {
         super("hat",".png",12,12,1,3,2);
    }
    
    public void act() {
        super.act();
        if (!can_fire) {
            if (fire_reset_time != 0) {
                fire_reset_time--;
            }
            else {
                can_fire = true;
                fire_reset_time = 30;
            }
        }
        if (enemy_spawn_reset_time >= 100) {
            spawnEnemy();
            enemy_spawn_reset_time = 0;
        }
        enemy_spawn_reset_time++;
    }
    
    public void setGround(int i) {
        player_altitude = i;  
    }
    
    public void moveRight() {
        if (canMoveRight()) {
            setLocation(getX() + speed, getY());
        }
    }
    
    public void moveLeft()
    {
        if(canMoveLeft()) {
            setLocation (getX() - speed, getY());
        }
    }
    
    public boolean onGround()
    {
        boolean result = false;

        if (player_altitude >= ground_height) {
            result = true;
        }
        
        if(result == true)
        {
            vSpeed = 0;
        }
        return result;
    }
    
    public boolean canMoveSideways()
    {
        return canMoveLeft() && canMoveRight();
    }
    
    public boolean canMoveLeft()
    {
        boolean result = true;     
        for (Obstacles c : getIntersectingObjects(Obstacles.class))
        {
            if (this.getX() > c.getX())
                result = false;
        }
        return result;
    }
    
    public boolean canMoveRight()
    {
        boolean result = true;
        for (Obstacles c : getIntersectingObjects(Obstacles.class))
        {
            if (this.getX() < c.getX())
                result = false;
        }
        return result;
    }
    
    public boolean canJump()
    {
        boolean result = true;
        for (Obstacles c : getIntersectingObjects(Obstacles.class))
        {
            if (this.getY() > c.getY())
                result = false;
        }
        return result;
    }
    
    public void jump(int speed)
    {
        if(canJump())
            vSpeed = -speed;
    }
    
    public void fire(boolean left) {
        if (can_fire) {
            if (left) {
                getWorld().addObject(new Horseshoe("left"), getX(), getY());
            }
            else {
                getWorld().addObject(new Horseshoe("right"), getX(), getY());
            }
            can_fire = false;
        }
    }
    
    public void spawnEnemy() {
        int x = 790;
        int y = Greenfoot.getRandomNumber(150) + 380;
        getWorld().addObject(new Fireball("left"), x, y); 
    }
   
    public void doGravity()
    {
        if(vSpeed >= 0 && onGround())  return;
        if(vSpeed <= 0 && (!canJump()))  vSpeed = -1;
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        
    }
    
    protected boolean atBottom()
    {
        return getY() >= getWorld().getHeight() - 2;
    }
    
    protected void setMovementSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
    
    protected void setBlockingClasses(Class[] c)
    {
        barrier = c;
    }
    
    protected void setGravity(int g)
    {
        acceleration = g;
    } 
    
    protected void setVSpeed(int v)
    {
        vSpeed = v;
    }
}
