package esercizi.iterazione;

import java.util.Random;
import java.util.Scanner;

public class Gioco{
    public static void main(String[] args){

        System.out.println(""); 

        Random generator = new Random();

        Scanner input = new Scanner(System.in);
       
        int rndNumber = 1 + generator.nextInt(14);
        
        int numeroSelezionato = 0;
   
        int tentativi = 0; 

        do {
            System.out.println("Inserisci un numero: ");
            numeroSelezionato = input.nextInt();
            System.out.println(""); 

            if(numeroSelezionato<rndNumber){
                System.out.println("Il numero è troppo basso.");
                System.out.println(""); 
            }else if(numeroSelezionato>rndNumber){
                System.out.println("Il numero è troppo alto.");
                System.out.println(""); 
            } 
            tentativi++;

            }while(tentativi<=10&&numeroSelezionato!=rndNumber);

        if(numeroSelezionato==rndNumber){
            System.out.println("Il numero è stato indovinato in " + tentativi + " tentativi.");
            System.out.println("");
        }else {
            System.out.println("Mi dispiace hai superato il numero di tentativi.\n GAME OVER!!!");   
            System.out.println("");
        }
    }
}       
        
            