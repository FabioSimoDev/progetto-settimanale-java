import player.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mutlimediaElement[] elements = new mutlimediaElement[5];

        for (int i = 0; i < elements.length; i++) {
            System.out.println("Crea l'elemento " + (i + 1) + ": ");
            System.out.println("Inserisci 'A' per un audio, 'V' per un video, 'I' per un immagine.");
            String selectedType = scanner.nextLine();
            System.out.println("Inserisci il titolo: ");
            String title = scanner.nextLine();

            switch (selectedType.toLowerCase()) {
                case "a" -> {
                    System.out.println("Durata: ");
                    int audioDuration = scanner.nextInt();
                    scanner.nextLine(); /* nextInt lascia nel buffer il caratter di nuova riga '\n',
                                        questo avrebbe causato un problema nel prossimo nextLine(),
                                        dato che avrebbe letto solo il carattere di nuova riga.
                                        richiamando nextLine qui 'consumo' quel carattere, togliendolo dal buffer.
                                        potrei anche usare nextLine qui e convertire il valore in int.*/
                    System.out.println("Volume: ");
                    int audioVolume = scanner.nextInt();
                    scanner.nextLine();
                    elements[i] = new Audio(title, audioDuration, audioVolume);
                }
                case "v" -> {
                    System.out.println("Durata: ");
                    int videoDuration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Volume: ");
                    int videoVolume = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Luminosità: ");
                    int videoBrightness = scanner.nextInt();
                    scanner.nextLine();
                    elements[i] = new Video(title, videoDuration, videoVolume, videoBrightness);
                }
                case "i" -> {
                    System.out.println("Luminosità: ");
                    int imageBrightness = scanner.nextInt();
                    scanner.nextLine();
                    elements[i] = new Image(title, imageBrightness);
                }
                default -> {
                    System.out.println("Tipo non valido. riprova.");
                    System.out.println(selectedType + " - " + selectedType.toLowerCase());
                    i--;
                }
            }
        }

        MediaPlayer mediaPlayer = new MediaPlayer(elements);

        int input;
        do {
            System.out.println("Inserisci un numero da 1 a 5 per eseguire un elemento multimediale, 0 per uscire:");
            input = scanner.nextInt();
            if (input > 0 && input <= 5) {
                mediaPlayer.executeElement(input);
            }
        } while (input != 0);
        scanner.close();

        //mediaPlayer.executeElement(0);
    }
}