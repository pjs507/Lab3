import greenfoot.*; 

public class Sound  
{
    private GreenfootSound sound;
    
    public void initializeSound(String sound_name) {
        sound = new GreenfootSound(sound_name);
    }
    
    public void playSound() {
        sound.play();
    }

    public void pauseSound() {
        sound.pause();
    }
    
    public void stopSound() {
        sound.stop();
    }
    
    public void setVolume(int amout) {
        sound.setVolume(amout);
    }
    
    public void started() {
        sound.play();
    }

    public void stopped() {
        sound.play();
    }
}
