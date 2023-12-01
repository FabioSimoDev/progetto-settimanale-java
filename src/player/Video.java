package player;

import player.interfaces.Reproducible;

public class Video extends mutlimediaElement implements Reproducible {
    private int duration;
    private int volume;
    private int brightness;

    public Video(String title, int duration, int volume, int brightness){
        super(title);
        this.duration = duration;
        this.volume = volume;
        this.brightness = brightness;
    }

    public void increaseBrightness(){
        brightness++;
    }

    public void decreaseBrightness(){
        if(brightness > 0) brightness--;
    }

    @Override
    public void play(){
        for (int i = 0; i < duration; i++) {
            try{
                Thread.sleep(1000);
                /*non lo abbiamo fatto in java nel corso,
                ma io in passato ho studiato C# e Thread.sleep() si usava allo stesso modo.*/
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(title + " " + "!".repeat(volume) + "*".repeat(brightness));
        }
    }
}
