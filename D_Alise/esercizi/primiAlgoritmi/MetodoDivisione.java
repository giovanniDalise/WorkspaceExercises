package esercizi.primiAlgoritmi;

import java.util.Scanner; 

public class MetodoDivisione{
    public static void main(String[] input){

        Scanner tastiera = new Scanner(System.in);

        System.out.println("Scrivi un numero: ");
        double dividendo = tastiera.nextDouble();

        System.out.println("Scrivi un altro numero: ");
        double divisore = tastiera.nextDouble();
        
        double risultato = divide(dividendo, divisore);

        System.out.println("Il risultato della divisione è: " + risultato);
    }
        
    public static double divide(double dividendo, double divisore){
        double risultato = dividendo/divisore;
        return risultato;
    }

}
