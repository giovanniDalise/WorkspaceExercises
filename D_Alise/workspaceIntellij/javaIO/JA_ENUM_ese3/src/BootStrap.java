import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleziona la partenza:");
        Partenza partenza = selezionaPartenza(scanner);

        System.out.println("Seleziona l'arrivo:");
        Arrivo arrivo = selezionaArrivo(scanner);

        System.out.println("Seleziona il tipo di veicolo:");
        Veicolo veicolo = selezionaVeicolo(scanner);

        double distanza = calcolaDistanza(partenza, arrivo);
        double tempo = calcolaTempo(distanza, veicolo);

        System.out.println("Il tempo di percorrenza previsto è: " + tempo + " ore");
    }

    private static Partenza selezionaPartenza(Scanner scanner) {
        System.out.println("Partenze disponibili:");
        for (Partenza partenza : Partenza.values()) {
            System.out.println(partenza.name());
        }

        System.out.print("Inserisci la partenza: ");
        String scelta = scanner.nextLine().toUpperCase();

        try {
            return Partenza.valueOf(scelta);
        } catch (IllegalArgumentException e) {
            System.out.println("Partenza non valida. Riprova.");
            return selezionaPartenza(scanner);
        }
    }

    private static Arrivo selezionaArrivo(Scanner scanner) {
        System.out.println("Arrivi disponibili:");
        for (Arrivo arrivo : Arrivo.values()) {
            System.out.println(arrivo.name());
        }

        System.out.print("Inserisci l'arrivo: ");
        String scelta = scanner.nextLine().toUpperCase();

        try {
            return Arrivo.valueOf(scelta);
        } catch (IllegalArgumentException e) {
            System.out.println("Arrivo non valido. Riprova.");
            return selezionaArrivo(scanner);
        }
    }

    private static Veicolo selezionaVeicolo(Scanner scanner) {
        System.out.println("Veicoli disponibili:");
        for (Veicolo veicolo : Veicolo.values()) {
            System.out.println(veicolo.name());
        }

        System.out.print("Inserisci il veicolo: ");
        String scelta = scanner.nextLine().toUpperCase();

        try {
            return Veicolo.valueOf(scelta);
        } catch (IllegalArgumentException e) {
            System.out.println("Veicolo non valido. Riprova.");
            return selezionaVeicolo(scanner);
        }
    }

    private static double calcolaDistanza(Partenza partenza, Arrivo arrivo) {
        int deltaX = arrivo.getCoordinate().getX() - partenza.getCoordinate().getX();
        int deltaY = arrivo.getCoordinate().getY() - partenza.getCoordinate().getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    private static double calcolaTempo(double distanza, Veicolo veicolo) {
        double velocitaMedia = veicolo.getVelocitaMedia();
        return distanza / velocitaMedia;
    }
}
