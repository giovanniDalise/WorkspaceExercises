package esercizi.iterazione;

import java.util.Scanner; 

public class Fibonacci{
    public static void main(String[] input){

        System.out.println(""); 

        int somma = 0;
 
        System.out.println(somma);

        int numeroPrecedente = 0;

        int numeroAttuale = 1;
        
        System.out.println(numeroAttuale);   

      
        while(somma<21){   
            somma = numeroPrecedente + numeroAttuale;
            numeroPrecedente = numeroAttuale;
            numeroAttuale = somma;
            System.out.println(somma);
        }
        System.out.println(""); 
    }
}   


