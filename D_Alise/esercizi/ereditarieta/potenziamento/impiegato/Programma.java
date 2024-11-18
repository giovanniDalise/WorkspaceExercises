/*Crea un programma che rappresenta la classe "Impiegato" con attributi come "nome" e "stipendio" e una classe figlia "Manager" 
con attributi specifici come "bonus".
Nel main, crea un'istanza di Manager e stampa il suo stipendio totale (considerando anche il bonus).*/

package esercizi.ereditarieta.potenziamento.impiegato;

public class Programma{
	public static void main(String[] args){
		Manager manager = new Manager();
		int stipendioTotale = manager.stipendio + manager.bonus;
		System.out.println(stipendioTotale);
        
    
	}
	
}