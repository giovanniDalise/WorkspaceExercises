package esercizi.primiAlgoritmi;
import java.util.Scanner;

public class CalcolatriceScomposizione{
    public static void main(String[] input){
	System.out.println("");
	System.out.println("Quale operazione devo fare?");
	System.out.println("");
	System.out.println("1 = addizione");
	System.out.println("2 = sottrazione");
	System.out.println("3 = moltiplicazione");
	System.out.println("4 = divisione");
	System.out.println("5 = modulo");
	System.out.println("6 = potenza");
	System.out.println("7 = radice quadrata");
	System.out.println("");

	double risOperazione = 0;
	int sceltaOperazione = Tastiera.chiediNumeroInt(1, 7);

	if(sceltaOperazione == 7){
	    int singoloNumero = Tastiera.chiediIntero("Inserisci il numero");
	    risOperazione = Math.sqrt(singoloNumero);
	}else{
	    int primoNumero = Tastiera.chiediIntero("Inserisci il primo numero");
	    int secondoNumero = Tastiera.chiediIntero("Inserisci il secondo numero");
            System.out.println("");

	    switch(sceltaOperazione){
		case 1:
		    risOperazione = primoNumero + secondoNumero;
		    break;
		case 2:
		    risOperazione = primoNumero - secondoNumero;
		    break;
		case 3:
		    risOperazione = primoNumero * secondoNumero;
		    break;
		case 4:
		    risOperazione = primoNumero / secondoNumero;
		case 5:
		    risOperazione = (float)primoNumero % secondoNumero;
		    break;
		case 6:
		    risOperazione = Math.pow(primoNumero, secondoNumero);
		    break;
	    }
	}
	System.out.println("Il risultato e':" + risOperazione);
    	System.out.println("");
    }	
}