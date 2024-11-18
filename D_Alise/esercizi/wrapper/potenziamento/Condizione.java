/*Scrivi un programma che prenda in input una stringa rappresentante un 
numero e restituisca true se è un numero intero, false altrimenti.*/

package esercizi.potenziamento.wrapper;
import esercizi.utility.Tastiera;
public class Condizione{
	public static void main(String[] args){
		boolean condizione = false;
			String stringa = Tastiera.chiediStringa("Inserisci un numero intero:");
			try{
		        Integer numero  = Integer.parseInt(stringa);
		            condizione = true;
		    }catch(NumberFormatException errore){	
		        condizione =false;
		    }     		
		System.out.println(condizione);
	}
}