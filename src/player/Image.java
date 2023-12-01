package player;

public class Image extends mutlimediaElement {
    private int brightness;

    public Image(String title, int brightness){
        super(title);
        this.brightness = brightness;
    }

    public void show(){
        System.out.println(title + " " + "*".repeat(brightness));
    }
}
