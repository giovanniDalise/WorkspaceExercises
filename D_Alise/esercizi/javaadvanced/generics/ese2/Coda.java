package esercizi.javaAdvanced.generics.ese2;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;


public class Coda{
	
	private Queue<Pratica> pratiche;
	
	public Coda(){
		this.pratiche = new LinkedList<Pratica>();
	}
	
	
	/* 
	- genera un int per ogni pratica in ordine progressivo
	- genera un oggetto Pratica e lo aggiunge alla Queue pratiche */
	public int generaProgressivo(){
		int progressivo = pratiche.size()+1;              //abbiamo creato un numero progressivo per le pratiche 
		Pratica nuovaPratica = new Pratica(progressivo);  //abbiamo creato un'istanza nuovaPratica di Pratica dandogli come parametro il progressivo
		pratiche.add(nuovaPratica);                       //abbiamo aggiunto la nuova pratica alla lista di pratiche
		return progressivo;
	}
	
	/* stampa la coda delle pratiche */
	public List<Pratica> visualizzaCoda() throws CloneNotSupportedException{
		List<Pratica> result = (List<Pratica>) ((LinkedList<Pratica>) pratiche).clone();
		return result;						                   //clone è un metodo di LinkedList.abbiamo clonato la lista di pratiche per visualizzare la copia
	}
	
	/* prende la pratica successiva se la pratica corrente è terminata(esaminata)*/
	public Pratica getPraticaSuccessiva(){
		return pratiche.poll();
	}
	
	public int getPraticheAperte(){
		return pratiche.size();
	}
	
}
