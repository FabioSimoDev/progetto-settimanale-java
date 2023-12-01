package player;

import player.interfaces.Reproducible;

public class MediaPlayer {
    private mutlimediaElement[] elements;

    public MediaPlayer(mutlimediaElement[] elements){
        this.elements = elements;
    }

    public void executeElement(int index){
        if(index >= 0 && index < elements.length){
            if(elements[index] instanceof Reproducible){
                ((Reproducible) elements[index]).play();
            }else if(elements[index] instanceof Image){
                ((Image) elements[index]).show();
            }
        }
    }
}
