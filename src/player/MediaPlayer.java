package player;

import player.interfaces.Reproducible;

public class MediaPlayer {
    private mutlimediaElement[] elements;

    public MediaPlayer(mutlimediaElement[] elements){
        this.elements = elements;
    }

    public void executeElement(int index){
        if(!(index - 1 < 0)) index--; //cosi posso usare l'index partendo da 1 e non da 0.
        else throw new IllegalArgumentException("l'indice non può essere 0.");

        if(index < elements.length){
            if(elements[index] instanceof Reproducible){
                ((Reproducible) elements[index]).play();
            }else if(elements[index] instanceof Image){
                ((Image) elements[index]).show();
            }
        }else{
            System.out.println("elemento non valido");
        }
    }
}
