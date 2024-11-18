package esercizi.primiAlgoritmi;

import java.util.Scanner; 

public class Somma{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il primo numero: ");
        int N1 = scanner.nextInt();
     
        System.out.println("");

        System.out.println("Inserisci il secondo numero: ");
        int N2 = scanner.nextInt();
     
        System.out.println("");

        int somma = N1 + N2;

        System.out.println("La somma tra N1 e N2 è: ");
        System.out.println(somma);
    }
}