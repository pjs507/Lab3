import greenfoot.*; 


public class CowboyHat extends Controlls
{
    int health;
    int worldIdx = 0;
    final int numWorlds = 4;
    public CowboyHat() {

        health = 10;
        setMovementSpeed(5);
        setGravity(2);
        setBlockingClasses( new Class[]{Rock.class} );
    }
    
    public void act() {
        super.act();
        setGround(getY());
        doGravity();
        //System.out.println(this.getY());
        if(this.getX() > 860){
            if(worldIdx < numWorlds){
                worldIdx++;
                this.setLocation(0, 490);
                ((MyWorld)getWorld()).changeWorld(worldIdx);

            }else{
                moveLeft();
            }
            
        }
        else if(this.getX() < 0){
            if(worldIdx > 0){
                worldIdx--;
                ((MyWorld)getWorld()).changeWorld(worldIdx);
                this.setLocation(860, 490);
            }else{
                moveRight();

            }
            
            
        }
        
        
        boolean A = Greenfoot.isKeyDown("A");
        if (A) {
            moveLeft();
        }
        
        boolean D = Greenfoot.isKeyDown("D");
        if (D) {
            moveRight();
        }
        
        boolean W = Greenfoot.isKeyDown("W");
        if (W && onGround()) {
            jump(28);
        } 
        
        boolean space = Greenfoot.isKeyDown("Space");
        if (space) {
            fire(A);
        }
    }
    
    public int getXPos()
    {
        return this.getX();
    }
    
    public int getYPos()
    {
        return this.getY();
    }
}
