package esercizio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        Scanner scanner = new Scanner(System.in);
        int scelta=0;
        while (scelta!=3) {
            System.out.println("\n--- Gestione Rubrica ---");
            System.out.println("1. Salvataggio nuovo contatto");
            System.out.println("2. Lettura dati di un contatto");
            System.out.println("3. Uscita");
            System.out.print("Selezionare un'opzione: ");

            scelta = scanner.nextInt();
            scanner.nextLine();  // Consuma il newline dopo il numero

            switch (scelta) {
                case 1:
                    System.out.print("Inserire nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserire cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Inserire telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Inserire indirizzo: ");
                    String indirizzo = scanner.nextLine();
                    Contatto nuovoContatto = new Contatto(nome, cognome, telefono, indirizzo);
                    rubrica.salvaContatto(nuovoContatto);
                    break;
                case 2:
                    System.out.print("Inserire nome del contatto da leggere: ");
                    String nomeContatto = scanner.nextLine();
                    rubrica.leggiContatto(nomeContatto);
                    break;
                case 3:
                    System.out.println("Grazie per aver utilizzato il programma.");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprovare.");
                    break;
            }
        }
    }
}