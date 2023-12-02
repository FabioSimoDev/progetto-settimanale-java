import player.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mutlimediaElement[] elements = new mutlimediaElement[5];
        System.out.println(elements.length);

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
            System.out.println("Inserisci un numero da 1 a 5 per eseguire un elemento multimediale, \n" +
                    "6 per una lista degli elementi, 0 per uscire:");
            input = scanner.nextInt();
            scanner.nextLine();

            if (input > 0 && input <= elements.length) {
                handleMultimediaElement(scanner, elements[input - 1], mediaPlayer, input);
            }else if(input == 6){
                for (mutlimediaElement element : elements) {
                    System.out.println(element.toString());

                }
            }
        } while (input != 0);

        scanner.close();

        //mediaPlayer.executeElement(0);
    }

    private static void handleMultimediaElement(Scanner scanner, mutlimediaElement element, MediaPlayer mediaPlayer, int index) {
        if (element instanceof Image) {
//            ((Image)element).show();
            mediaPlayer.executeElement(index);
            return;
        }

        System.out.println("Inserisci 1 per mettere play, 2 per alzare il volume, 3 per abbassarlo:");
        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 1 ->
//                if (element instanceof Audio) {
//                    ((Audio) element).play();
//                } else {
//                    ((Video) element).play();
//                }
                    mediaPlayer.executeElement(index);
            case 2 -> {
                if (element instanceof Audio) {
                    ((Audio) element).increaseVolume();
                } else {
                    ((Video) element).increaseVolume();
                }
                System.out.println("Volume alzato!");
            }
            case 3 -> {
                if (element instanceof Audio) {
                    ((Audio) element).decreaseVolume();
                } else {
                    ((Video) element).decreaseVolume();
                }
                System.out.println("Volume abbassato!");
            }
            default -> {
            }
        }
    }
}