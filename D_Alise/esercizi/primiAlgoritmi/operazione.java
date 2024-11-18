/*Creare l'algoritmo e successivamente il programma che dato in input un numero
double, stampa i seguenti valori:

valore assoluto
potenza
radice quadrata */

package esercizi.primiAlgoritmi;

import java.util.Scanner; 

public class operazione{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        double D = scanner.nextDouble();
     
        System.out.println("");

        double assoluto = Math.abs(D);
        double potenza = Math.pow(D,2);
        double radice = Math.sqrt(D);

        System.out.println(assoluto);
        System.out.println("");
        System.out.println(potenza);
        System.out.println("");
        System.out.println(radice);
        System.out.println("");
    }
}