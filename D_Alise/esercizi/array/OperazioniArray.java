/*
Creare un programma che generato un array di 10 elementi di tipo int, esegue le seguenti
operazioni:

popola l'array con 10 numeri casuali da 1 a 100 e lo stampa
effettua la somma di tali numeri e la stampa
ricerca e stampa qual'é il numero più grande ed il più piccolo
*/
package esercizi.array;
import java.util.Random;

public class OperazioniArray {
    public static void main(String[] args) {
        // Creazione dell'array vuoto
        int[] array = new int[10];

        // Popolamento dell'array con numeri casuali da 1 a 100
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) + 1;
        }

        // Stampa dell'array e della somma dei numeri
        int somma = 0;
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            somma += array[i];
        }
        System.out.println("\nSomma: " + somma);

        // Ricerca del numero più grande e del più piccolo
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Numero più grande: " + max);
        System.out.println("Numero più piccolo: " + min);
        }
    }

    