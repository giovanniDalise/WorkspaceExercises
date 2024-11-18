/*Scrivi un programma che prenda in input una stringa rappresentante un numero decimale e lo converta in un oggetto di classe Double.*/

package esercizi.potenziamento.wrapper;
import esercizi.utility.Tastiera;
public class StringaDouble{
	public static void main(String[] args){
		String stringa = Tastiera.chiediStringa("Inserisci un numero decimale:");
		Double decimale  = Double.parseDouble(stringa); //variabile statica non prende il nome della variabile rimane Double
		System.out.println(decimale);
	}
}