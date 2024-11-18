package esercizi.ricerca;
import esercizi.utility.Tastiera;
import esercizi.array.ToolsVettore;

public class RicercaBinaria {
    public static void main(String[] args) {
        int [] array = ToolsVettore.caricaVettore(20);
        int numero = Tastiera.chiediInteroPositivo("Inserisci un numero");
        ToolsVettore.ordinaVettore(array); //ricerca dicotomica per resa bisogna utilizzarla sempre con un array ordinato se no non ha senso
        ToolsVettore.stampaVettore(array,"Vettore Ordinato");
        int indice = ricercaDicotomica(array, numero);

        if (indice == -1) {
            System.out.println("Elemento non trovato");
        } else {
            System.out.println("Elemento trovato all'indice " + indice);
        }
    }

    public static int ricercaDicotomica(int[] array, int numero) {
        int sinistra = 0; //primo indice a sinistra
        int destra = array.length - 1; //ultimo indice ossia la lunghezza dell'array meno 1

        while (sinistra <= destra) {//finche l'indice iniziale sarà più piccolo o uguale a quello finale
            int medio = (sinistra + destra) / 2;// indice medio somma più divisione dato che il ciclo di ripete e sinistra e destra cambiano utilizziamo questa formula

            if (array[medio] == numero) {  
                return medio;
            } else if (array[medio] < numero) { //se l'indice medio è più piccolo del numero allora il nostro indice di sinistra sarà l'indice medio + 1 questo perchè prèrio come un libro ordinato una volta aperto ad un riferimento l'altra metà non la consideriamo più(ricerca binaria)
                sinistra = medio + 1;
            } else {
                destra = medio - 1;//stesso caso di sopra 
            }
        }

        return -1; // valore non trovato
    }
}