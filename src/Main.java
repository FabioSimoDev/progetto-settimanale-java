import player.*;

public class Main {
    public static void main(String[] args) {
        mutlimediaElement[] elements = {
                new Audio("audio 1", 5, 3),
                new Audio("audio 2", 3, 4),
                new Audio("audio 3", 1, 2),
                new Video("video 1", 5, 4, 10),
                new Image("immaginbe 1", 6)
        };

        MediaPlayer mediaPlayer = new MediaPlayer(elements);

        mediaPlayer.executeElement(0);
    }
}