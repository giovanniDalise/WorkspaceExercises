/*Scrivi una classe che rappresenta un libro, con variabili di istanza come il
titolo, l'autore e il prezzo, pagine. Incapsula le variabili di istanza e
implementa metodi per accedere alle informazioni del libro.

Scrivi un programma che permette di gestire le seguenti operazioni di
un biblioteca:

Affitto Libro
Restituzione Libro
Inserimento nuovo libro (deve essere possibile creare più istanze per lo
stesso libro)
Eliminazione Libro dalla biblioteca
Ricerca Libro per titolo e/o autore e/o editore
Lettura libro che prevede i seguenti metodi
sfoglia (fa vedere il libro pagina per pagina)
appunta (permette di inserire un appunto su una pagina del libro)*/

package esercizi.incapsulamento.biblioteca2;
import esercizi.utility.Tastiera;

public class Biblioteca{
	private Libro[] libri;
	private String nome;

	public static void main(String[] args) throws Exception{
		Biblioteca b = new Biblioteca("Alfasoft");
		int numero;
		Libro libro=null;
		do{
			System.out.println("Inserire il numero:");
			System.out.println("1. Inserisci libro");
			System.out.println("2. Ricerca libri");		
			System.out.println("3. Affitta libro");
			System.out.println("4. Restituisci libro");
			System.out.println("5. Elimina libro");
			System.out.println("6. Sfoglia libro");
			System.out.println("7. Appunta su libro");
			System.out.println("8. Visualizza libri");
			System.out.println("0. Esci");		
			numero = Tastiera.chiediInteroPositivo("");
			String titolo=null;
			Pagina[] pagine=new Pagina[3];
			String autore=null;
			String editore=null;
			double prezzo=0;

			switch (numero){
				case 1:
					b.inserisciLibro();
					break;
				case 2:
					Libro[] libriDaStampare = b.ricercaLibri();
	                if (libriDaStampare != null) {
	                    b.stampaLibri(libriDaStampare);
	                } else {
	                    System.out.println("Nessun libro trovato.");
	                }
					break;
				case 3:
					titolo = Tastiera.chiediStringa("Inserisci il titolo del libro da affittare:");
                    pagine[0] = new Pagina("Prima pagina");
                    pagine[1] = new Pagina("Seconda pagina");
                    pagine[2]= new Pagina("Terza pagina");	
					autore = Tastiera.chiediStringa("Inserisci l'autore del libro da affittare:");    
					editore = Tastiera.chiediStringa("Inserisci l'editore del libro da affittare:"); 
					prezzo = Tastiera.chiediDouble("Inserisci il prezzo del libro da affittare:"); 					
                    Libro libroDaAffittare = new Libro(titolo, autore, editore, prezzo, pagine);
					libroDaAffittare = b.ricercaLibro(libroDaAffittare);
					if(libroDaAffittare != null) {
					    b.affittaLibro(libroDaAffittare);
					    b.stampaLibri(b.libri);
					} else {
					    System.out.println("Libro non trovato.");
                    }
				    break;
				case 4:
					titolo = Tastiera.chiediStringa("Inserisci il titolo del libro da restituire:");
                    pagine[0] = new Pagina("prima pagina");
                    pagine[1] = new Pagina("seconda pagina");
                    pagine[2]= new Pagina("terza pagina");	
					autore = Tastiera.chiediStringa("Inserisci l'autore del libro da restituire:");    
					editore = Tastiera.chiediStringa("Inserisci l'editore del libro da restituire:"); 
					prezzo = Tastiera.chiediDouble("Inserisci il prezzo del libro da restituire:"); 	
                    Libro libroDaRestituire = new Libro(titolo, autore, editore,prezzo, pagine);		
					libroDaRestituire = b.ricercaLibro(libroDaRestituire);                    							
					if(libroDaRestituire != null) {
					    b.restituzioneLibro(libroDaRestituire);
					    b.stampaLibri(b.libri);
					} else {
					    System.out.println("Libro non trovato.");
                    }
				    break;
				case 5:
					titolo = Tastiera.chiediStringa("Inserisci il titolo del libro da cancellare:");
                    pagine[0] = new Pagina("prima pagina");
                    pagine[1] = new Pagina("seconda pagina");
                	pagine[2]= new Pagina("terza pagina");	    
					autore = Tastiera.chiediStringa("Inserisci l'autore del libro da cancellare:");    
					editore = Tastiera.chiediStringa("Inserisci l'editore del libro da cancellare:"); 
					prezzo = Tastiera.chiediDouble("Inserisci il prezzo del libro da cancellare:"); 	
                    Libro libroDaCancellare = new Libro(titolo, autore, editore,prezzo, pagine);		
					libroDaCancellare = b.ricercaLibro(libroDaCancellare);                    						
					if(libroDaCancellare != null) {
					    b.eliminaLibro(libroDaCancellare);
					    b.stampaLibri(b.libri);
					} else {
					    System.out.println("Libro non trovato.");
                    }
				    break;				
				case 6:
					libro = b.ricercaLibro(libro);
					String direzione = Tastiera.chiediStringa("Inserisci la direzione(avanti o indietro:");
					libro.sfoglia(direzione);
					break;
				case 7:
					break;
				case 8:
					Libro[] libri = b.getLibri();
					b.stampaLibri(b.libri);
					break;	
				case 0:
					break;
				default:
					System.out.println("Inserire uno dei numeri elencati:");
					break;
		    }
		} while (numero != 0);
	}    
	public Biblioteca(String nome){
	   this.nome=nome;
	   this.libri = new Libro[0];
	}
	public void inserisciLibro(){
	    Pagina[] pagine = new Pagina[3];	
		pagine[0]= new Pagina("Prima pagina");
		pagine[1]= new Pagina("Seconda pagina");
		pagine[2]= new Pagina("Terza pagina");		
		String titolo = Tastiera.chiediStringa("Inserisci il titolo del libro:");
		String autore = Tastiera.chiediStringa("Inserisci l'autore del libro:");
		String editore = Tastiera.chiediStringa("Inserisci l'editore del libro:");
		double prezzo = Tastiera.chiediDouble("Inserisci il prezzo del libro:");	
		try {
        Libro libro = new Libro(titolo, autore, editore, prezzo,pagine);
		    aggiungiLibro(libro);
		} catch (Exception e) {
		    System.out.println("Errore durante l'inserimento del libro: " + e.getMessage());
		}	
	}	
	
	public Libro[] ricercaByTitolo(String titolo){
	    Libro[] risultato = new Libro[0];
	    int count = 0;
	    for(int i = 0; i < this.libri.length; i++){
	        if(this.libri[i].getTitolo().equals(titolo)){
	            Libro[] temp = new Libro[risultato.length + 1];
	            for(int j = 0; j < risultato.length; j++){
	                temp[j] = risultato[j];
	            }
	            temp[count] = this.libri[i];
	            risultato = temp;
	            count++;
	        }
	    }
	    return risultato;
	}

	public Libro[] cercaLibroByText(String testo){
	    Libro[] risultato = null;
	    int numeroLibri = 0;

	    for(int i = 0; i < this.libri.length; i++){//ciclo l'array libri originale
	        if(this.libri[i].toString().contains(testo)){
	            numeroLibri++;
	        }
	    }
	    if(numeroLibri > 0){ //se abbiamo trovato almeno un libro
	        risultato = new Libro[numeroLibri]; //inizializzo l' array risultato con lunghezza uguale al numero di strumenti trovati
	        int j = 0;
	        for(int i = 0; i < this.libri.length; i++){
	            if(this.libri[i].toString().contains(testo)){//passo dall'array precedente "libri" all'array "risultato"  gli libri che corrispondono al testo
	                risultato[j] = this.libri[i];
	                j++;
	            }
	        }
	    }
	    return risultato;
	}
	private void stampaLibri(Libro[] libri){
	    for(int i=0;i<libri.length;i++){
	        if(libri[i] != null) {
	            System.out.println(libri[i].toString());
	        }
	    }
	}
	public Libro[] ricercaLibri(){
	    Libro[] risultato=new Libro[0]; 		
	    int numero = Tastiera.chiediIntero("Come vuoi cercare:\n1.Testo\n2.Titolo");
	    Tastiera.smaltisciRestoInput();	    
	    if (numero == 1){
	        String testo = Tastiera.chiediStringa("Inserisci il testo:");
	        risultato = cercaLibroByText(testo); 
	    } else if(numero == 2){
	        String titolo = Tastiera.chiediStringa("Inserisci il titolo:");   
	        Libro[] libriTrovati = ricercaByTitolo(titolo);
	        if(libriTrovati.length > 0){
	            risultato = libriTrovati;
	        }    		    	             
	    } 
	    return risultato;
	}    
	public Libro ricercaLibro(Libro libro){
	    Libro result = null;
	    if (this.libri != null) {
	        for(int i=0;i< this.libri.length;i++){
	            if(this.libri[i].equals(libro)){
	                result = this.libri[i];
	            }
	        }
	    }
	    return result;
	}

	public Libro[] getLibri(){
	    return libri;
	}
	public void affittaLibro(Libro libro) throws Exception{
		Libro libroFound = ricercaLibro(libro);
		if(libroFound==null){
			throw new Exception("Libro non trovato");
		}else if(libroFound.isDisponibile()){
			libroFound.affitta();
		}else{
			throw new Exception("Libro già affittato");
		}
    }
	public void restituzioneLibro(Libro libro) throws Exception{
		Libro libroFound = ricercaLibro(libro);
		if(libroFound==null){
			throw new Exception("Libro non trovato");
		}else if(!libroFound.isDisponibile()){
			libroFound.restituisci();
		}else{
			throw new Exception("Libro già disponibile.");
		}
	}
    /*visto che fai confusione,l'operatore(not)! ti dice l'opposto da un valore impostato, ma nella selezione non ti chiede se è diverso dall'ultimo valore impostato, 
    ma ti restituisce il valore false del booleano ossia se isDisponibile è falso allora succede questa cosa. Pensala quasi come una costante se è false allora la condizione verificata
    non fare l'errore di pensare se is disponibile è uguale a true (dato che disponibile = false e !disponibile sarebbe true) allora fai questo. p come se controllasse se un valore è off, 
    controlla se il booleano è falso non se il valore della variabile è opposto a come l'hai impostato.Questo accade proprio perchè disponibile è un booleano non un numero come !=0(non !0 quello è un altro  fatto) io controllo
    !diverso da disponibile ossia disponibile=true !dispobile=false*/

	public void aggiungiLibro(Libro libro){
		Libro[] tmpLibri= new Libro[this.libri.length + 1];
		for(int i=0; i< this.libri.length;i++){
			tmpLibri[i]=this.libri[i];
		}
		tmpLibri[tmpLibri.length -1] = libro;
		this.libri = tmpLibri;
	}
	public void eliminaLibro(Libro libro){
		Libro[] tmpLibri= new Libro[this.libri.length - 1];
		boolean trovato = false;
		for(int i=0; i< this.libri.length;i++){
			if(ricercaLibro(libro)!=null){
				trovato=true;
			}else{
				if(trovato){
					tmpLibri[i-1]=this.libri[i];
				}else{
					tmpLibri[i]=this.libri[i];
				}
			}
		}
		this.libri = tmpLibri;
	}	
}