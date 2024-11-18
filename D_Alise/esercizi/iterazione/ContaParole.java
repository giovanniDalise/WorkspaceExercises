package esercizi.iterazione;

import java.util.Scanner; 

public class ContaParole{
    public static void main(String[] input){

        System.out.println("");

        Scanner tastiera = new Scanner(System.in);

        System.out.println("Scrivi una frase: ");
        String frase = tastiera.nextLine();    
    
        Scanner fraseScanner = new Scanner(frase);        

        System.out.println("");

        String parola;
        int numeroParole = 0;
            
        while(fraseScanner.hasNext()){
            parola = fraseScanner.next();
            numeroParole++; 
            System.out.println("Il numero di caratteri della parola " + numeroParole +" è: " + parola.length());                   
        }
        System.out.println("");

        System.out.println("Il numero delle parole è: " + numeroParole);

        System.out.println("");
    }
}