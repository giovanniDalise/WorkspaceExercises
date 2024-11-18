package esercizi.primiAlgoritmi;
import java.util.Scanner;

public class CifreNumero{  
    public static void main(String[] input){          
	
        Scanner tastiera = new Scanner(System.in);   
      
        double numero = Tastiera.chiediDouble("Inserisci un numero:");
        int cifre = Utility.cifreNumero(numero);
        System.out.println("Cifre numero:\n"+cifre);
    }
}