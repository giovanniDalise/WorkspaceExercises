package esercizi.iterazione;
import java.util.Scanner;
import esercizi.utility.Tastiera;

public class ContaParoleScomposto{  
    public static void main(String[] input){  
	System.out.println("");        
        String frase = Tastiera.chiediStringa("Inserisci una frase: ");
	System.out.println("");      
 
	System.out.println(String.format("La frase contiene %d parole.",contaParole(frase)));
	System.out.println(""); 
    } 
    public static int contaParole(String frase){
	Scanner scFrase = new Scanner(frase);
	int count=0;
	String parola;
	while(scFrase.hasNext()){
	    parola=scFrase.next();
	    System.out.println(parola.length());
	    count++;
        }
    System.out.println("");
    return count;
    }
} 