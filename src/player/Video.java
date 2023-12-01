package player;

import player.interfaces.Reproducible;

class Video extends mutlimediaElement implements Reproducible {
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
            System.out.println(title + " " + "!".repeat(volume) + "*".repeat(brightness));
        }
    }
}
