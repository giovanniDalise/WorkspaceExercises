/*Scrivi un programma che prenda in input una stringa rappresentante 
un numero intero e lo converta in un oggetto di classe Integer.*/

package esercizi.potenziamento.wrapper;
import esercizi.utility.Tastiera;
public class StringaInteger{
	public static void main(String[] args){
		String stringa = Tastiera.chiediStringa("Inserisci un numero:");
		Integer numero  = Integer.parseInt(stringa); //variabile statica non prende il nome della variabile rimane Integer
		System.out.println(numero);
	}
}