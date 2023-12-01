package player;

import player.interfaces.Reproducible;

public class Audio extends mutlimediaElement implements Reproducible {
    private int duration;
    private int volume;

    public Audio(String title, int duration, int volume){
        super(title);
        this.duration = duration;
        this.volume = volume;
    }

    public void lowerVolume(){
        if(volume > 0) volume--;
    }

    public void increaseVolume(){
        volume++;
        //ricordati di mettere un limite al volum,e, tipo 10
    }

    @Override
    public void play(){
        for (int i = 0; i < duration; i++) {
            System.out.println(title + " " + "!".repeat(volume));
        }
    }
}
