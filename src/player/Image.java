package player;

public class Image extends mutlimediaElement {
    private int brightness;

    @Override
    public String toString() {
        return "Image{" +
                "brightness=" + brightness +
                ", title='" + title + '\'' +
                '}';
    }

    public Image(String title, int brightness) {
        super(title);
        this.brightness = brightness;
    }

    public void show() {
        System.out.println(title + " " + "*".repeat(brightness));
    }
}
