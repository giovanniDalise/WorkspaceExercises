package esercizi.javaAdvanced.generics.ese2;
import java.util.Random;


public class Pratica implements Comparable<Pratica>, Cloneable {
	
	Random rnd = new Random();
	
	private boolean esaminata;
	private long timestampInizio;
	private long timestampFine;
	private long durata;
	private int progressivo;
	
	/*creare un'istanza di Pratica. 
	- impostare il timestampInizio con la data attuale
	- impostare la durata della pratica con un numero random
	- impostare esaminata false
	- impostare il progressivo con il parametro passato*/
	
	public Pratica(int progressivo){
		this.timestampInizio = System.currentTimeMillis();
		this.durata = rnd.nextInt(5000);
		this.esaminata = false;
		this.progressivo = progressivo;
	}
	
	public void setTimestampFine(long timestampFine){
		this.timestampFine = timestampFine;
	}
	
	public int getProgressivo(){
		return this.progressivo;
	}
	
	public long getDurata(){
		return this.durata;
	}
	
	public boolean isEsaminata(){
		return this.esaminata;
	}
	
	@Override
	public Pratica clone() throws CloneNotSupportedException{   //Override metodo clone
		Pratica result = new Pratica(this.progressivo);
		result.timestampInizio = this.timestampInizio;
		result.timestampFine = this.timestampFine;
		result.durata = this.durata;
		result.esaminata = this.esaminata;
		return result;
	}
	
	
	/* dobbiamo comparare il tipo di oggetto (pratica) con l'istanza di pratica*/
	
	public int compareTo(Pratica pratica){
		return this.progressivo - pratica.getProgressivo();
	}
	/*Il metodo compareTo prende come parametro un oggetto Pratica chiamato pratica con cui confrontare l'istanza corrente. 
	Restituisce un valore intero che rappresenta la differenza tra il progressivo della pratica corrente (this.progressivo) 
	e il progressivo della pratica passata come parametro (pratica.getProgressivo()).
    La convenzione di utilizzo del metodo compareTo è la seguente:
    Restituisce un numero negativo se la pratica corrente ha un progressivo inferiore alla pratica passata come parametro.
    Restituisce zero se la pratica corrente ha lo stesso progressivo della pratica passata come parametro.
    Restituisce un numero positivo se la pratica corrente ha un progressivo maggiore della pratica passata come parametro.
    */
	
	public String toString(){
		return  "Numero : " + progressivo + " " + timestampInizio + " " + durata;
	}
}