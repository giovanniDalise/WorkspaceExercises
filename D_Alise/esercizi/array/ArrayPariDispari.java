/*
Creare un programma che esegue le seguenti operazioni:
-crea un array di 10 elementi di tipo int
-popola l'array con 10 numeri casuali da 1 a 100
-scambia i numeri in posizione pari con quelli in posizione dispari
*/

package esercizi.array;
import java.util.Random;

public class ArrayPariDispari{
    public static void main(String[] args) {
        // Creazione dell'array vuoto
        int array [] = new int [10];

        // Popolamento dell'array con numeri casuali da 1 a 100
        Random rand = new Random();
        for(int i=0; i<array.length;i++){
            array[i]= rand.nextInt(100)+1;
        }
        // Stampa dell'array originale
        int somma = 0;
        System.out.print("Array originale: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        //Scambio dei numeri in posizione pari con quelli in posizione dispari
        for (int i = 0; i < array.length - 1; i += 2) {
            int temp = array[i];  //primo numero finisce in temp
            array[i] = array[i + 1]; //secondo numero viene sovrascitto in prima posizione
            array[i + 1] = temp; //temp(primo numero) viene sovrascitto in seconda posizione
                                //il contatore diventa 2 (ossia prende in analisi il terzo indice o terza posizione)
        }

        // Stampa del contenuto dell'array convertito:
        System.out.println("");
        System.out.print("Array convertito: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}