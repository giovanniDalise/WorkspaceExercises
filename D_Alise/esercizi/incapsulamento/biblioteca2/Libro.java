package esercizi.incapsulamento.biblioteca2;
import java.util.Date;

public class Libro{
	private long protocollo;
	private int segnalibro;
	private Pagina[] pagine;
	private String titolo;
	private String autore;
	private String editore;
	private boolean disponibile;
	private double prezzo;

    public Libro(String titolo, String autore, String editore, double prezzo, Pagina[] pagine) throws Exception{
		this.protocollo = new Date().getTime();
		if(pagine!=null){
			this.pagine = pagine;
			this.titolo = titolo;
			this.autore=autore;
			this.prezzo=prezzo;
			this.editore=editore;
			this.disponibile = true;
			this.segnalibro=0;
		}else{
			throw new Exception("Le pagine devono essere valorizzate!!!");
		}
	}
	/*Il costruttore della classe Libro sta verificando che il parametro pagine passato al costruttore non sia null. 
	Se pagine è null, significa che l'oggetto Libro non potrà essere creato correttamente, in quanto non avrà alcuna pagina.
	In questo modo, se il parametro pagine è null, il costruttore non crea l'oggetto e solleva un'eccezione per informare l'utente del problema.
	Il costruttore potrebbe essere stato progettato in modo da accettare un array di pagine, anche se non sono ancora stati creati, 
	in modo che l'utente possa assegnargli successivamente un valore tramite un metodo pubblico della classe. 
	In tal caso, sarebbe necessario verificare che l'array non sia nullo nel costruttore per evitare errori futuri durante l'esecuzione del programma.
	Quindi se io inserisco un array di pagine vuoto nel costruttore che poi implementerò ogni volta che inserisco un libro nuovo necessariamente devo 
	propagare o gestire l'exception, quando si cerca di creare un nuovo libro con un array di pagine nulle, il programma avrebbe sollevato un'eccezione 
	di tipo NullPointerException in quanto avrebbe cercato di accedere a un array nullo. Questo potrebbe causare il crash del programma o il comportamento imprevisto.
	*/
	public String getTitolo(){ 
		return this.titolo; 
	}
	public String getEditore(){ 
		return this.editore; 
	}
	public String getAutore(){ 
		return this.autore; 
	}
	public double getPrezzo(){
		return this.prezzo;
	}
	public long getProtocollo(){
		return this.protocollo;
	}
	public Pagina[] getPagine(){
		return this.pagine;
	}
	public boolean isDisponibile(){
		return this.disponibile;
	}
	public void chiudi(){
		this.segnalibro=0;
	}
	public void affitta(){
		this.disponibile=false;
	}
	public void restituisci(){
		this.disponibile=true;
	}
	public static final String avanti="avanti"; //costante
	public static final String indietro="indietro"; //constante
	
	public Pagina sfoglia(String direzione) throws Exception{
		Pagina result = null;
		if(direzione.equals(Libro.avanti)){
			if(pagine.length == this.segnalibro){
				throw new Exception("Attenzione raggiunta fine del libro");
			}
			result = pagine[segnalibro];
			segnalibro++;
		}else if(direzione.equals(Libro.indietro)){
			if(segnalibro ==0){
				throw new Exception("Attenzione sei all'inizio del libro");
			}
			result = pagine[segnalibro];
			segnalibro--;
		}else{
			throw new Exception("Direzione non prevista");
		}
		return result;
	}
	public String toString(){
		return this.protocollo + " - " + this.titolo + " - " + this.autore + " - " + this.editore + " - " + this.prezzo + " - Disponibile: " + this.disponibile;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (!(obj instanceof Libro)) {
	        return false;
	    }
	    Libro other = (Libro) obj;
	    return this.titolo.equals(other.getTitolo()) && this.autore.equals(other.getAutore()) && this.editore.equals(other.getEditore())&& this.prezzo==other.getPrezzo()&& this.pagine==other.getPagine();
	}
}