package esercizi.interfacce.potenziamento.negozioVestiti;
import esercizi.utility.Tastiera;
/*- creare un'interfaccia che si occupa di effettuare le seguenti operazioni:
    - aggiunta oggetto
    - ricerca oggetto
    - lista oggetti
    - cancellazione oggetto
    e poi creare un programma per la gestione dei prodotti di un magazzino utilizzando l'interfaccia creata*/
public class NegozioVestiti {
    public static void main(String[] args) {
        Vestito[] vestiti = new Vestito[0];         
        Magazzino magazzino = new Magazzino();
        int numero;
        do {
            System.out.println("Inserire il numero:");
            System.out.println("1. Inserisci vestito");
            System.out.println("2. Ricerca vestito");
            System.out.println("3. Visualizza Vestiti");
            System.out.println("4. Elimina Vestito");
            System.out.println("0. Esci");
            numero = Tastiera.chiediIntero("");
            Tastiera.smaltisciRestoInput();
            switch (numero) {
                case 1:
                    magazzino.aggiungiVestito();
                    magazzino.visualizzaVestiti();
                    break;
                case 2:
                    magazzino.cercaVestito();
                    break;
                case 3:
                    magazzino.visualizzaVestiti();
                    break;
                case 4:
                    magazzino.eliminaVestito();
                    magazzino.visualizzaVestiti();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Inserire uno dei numeri elencati:");
                    break;
            }
        } while (numero != 0);
    }
}
