/*
Creare un programma che esegue le seguenti operazioni:

-definisce un array di tipo String senza inizializzarlo
-permettere all'utente di inserire stringhe nell'array finché non viene
-inserita la parola "EXIT"
-stampare l'array generato
*/

package esercizi.array;
import java.util.Scanner;
import java.util.Arrays;

public class ArrayStringhe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Definizione dell'array di stringhe
        String[] array = new String[10];
        int indice = 0;
        boolean exit = false;

        // Inserimento delle stringhe nell'array
        while (!exit && indice < array.length) {
            System.out.print("Inserisci una parola (EXIT per uscire): ");
            String parola = input.nextLine();

            if (parola.equalsIgnoreCase("EXIT")) {
                exit = true;
            } else {
                array[indice] = parola;
                indice++;

                // Redimensionamento dinamico dell'array se necessario
                if (indice == array.length) {
                    array = Arrays.copyOf(array, array.length + 10);
                }
            }
        }

        // Stampa dell'array di stringhe
        System.out.println("\nStampa dell'array:");
        for (int i = 0; i < indice; i++) {
            System.out.println(array[i]);
        }
    }
}

    