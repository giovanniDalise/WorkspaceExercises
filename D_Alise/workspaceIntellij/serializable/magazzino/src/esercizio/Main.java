package esercizio;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)throws SalvataggioException,DeserializationException {

        Magazzino magazzino = new Magazzino();
        int scelta = 0;
        do{
            System.out.println("Inserisci un numero per il tipo di operazione:");
            System.out.println("1.Inserimento prodotto:");
            System.out.println("2.Ricerca prodotto:");
            System.out.println("3.Cancellazione prodotto:");
            System.out.println("4.Visualizzazione Prodotti:");
            System.out.println("5.Salva Stato Magazzino:");
            System.out.println("6.Carica Stato Magazzino:");
            System.out.println("7.Uscita");
            scelta = input.nextInt();
            input.nextLine();
            switch (scelta){
                case 1:
                    Prodotto nuovoProdotto = inserisciProdotto();
                    magazzino.aggiungiProdotto(nuovoProdotto);
                    break;
                case 2:
                    System.out.println("Inserisci il codice del prodotto:");
                    magazzino.ricercaProdotto(input.nextLine());
                    break;
                case 3:
                    System.out.println("Inserisci il codice del prodotto:");
                    magazzino.cancellaProdotto(input.nextLine());
                    break;
                case 4:
                    magazzino.visualizzaProdotti();
                    break;
                case 5:
                    magazzino.salvaFile();
                    break;
                case 6:
                     magazzino = caricaMagazzino();
                     break;
                case 7:
                    break;
                default:
                    System.out.println("Opzione non valida. Riprovare.");
                    break;
            }
        }while(scelta!=7);
    }
    public static Prodotto inserisciProdotto(){
        System.out.print("Inserire il nome del prodotto: ");
        String nome = input.nextLine();
        System.out.print("Inserire il codice del prodotto: ");
        String codice = input.nextLine();
        System.out.print("Inserire il tipo di prodotto: ");
        String tipo = input.nextLine();
        ArrayList<Evento> nuovaTracciabilita = new ArrayList<Evento>();
        inserisciTracciabilita(nuovaTracciabilita);
        Prodotto nuovoProdotto = new Prodotto(nome, codice, tipo,nuovaTracciabilita);
        return nuovoProdotto;
    }
    public static void inserisciTracciabilita(ArrayList<Evento> tracciabilita){
        System.out.println("Inserimento tracciabilità:");
        System.out.print("Inserire la data dell'evento(YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(input.nextLine());
        System.out.print("Inserire le coordinate geografiche per la tracciabilità del prodotto: ");
        String coordinate = input.nextLine();
        System.out.print("Inserire il tipo di evento: ");
        String tipo = input.nextLine();
        System.out.print("Inserire la descrizione dell'evento: ");
        String descrizione = input.nextLine();
        Evento evento = new Evento(data, coordinate, tipo, descrizione);
        tracciabilita.add(evento);
    }
    private static Magazzino caricaMagazzino() throws DeserializationException {
        Magazzino magazzino = new Magazzino();
        magazzino.caricaFile();
        return magazzino;
    }
}