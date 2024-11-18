package esercizi.oo.studenti.studenti2;

public class Classe {
    private Studente[] studenti;

    public Classe() {
    	this.studenti=new Studente[0];
    }
    public void aggiungiStudente(Studente studente){
    	Studente[]tmpStudenti = new Studente[this.studenti.length+1]; //creo un arraytemporaneo della lugnhezza del precedente + 1
    	for(int i = 0;i<studenti.length;i++){//ciclo per la lunghezza del precedente array
    		tmpStudenti[i] =this.studenti[i];//inserisco i vecchi indici nel nuovo array fino al penultimo indice(<)
    	}	
		tmpStudenti[studenti.length] = studente;//inserisco studente(appena creato) nell'ultimo indice
		this.studenti=tmpStudenti;//facciamo diventare l'aray temporaneo come array d'istanza
    }
    public Studente cercaStudenteByMail(String email){
    	Studente risultato = null;
    	int i = 0;
    	boolean trovato = false;
    	while(i<this.studenti.length && !trovato){
    	    if(this.studenti[i].email.equals(email)){
    	        trovato = true;
    	        risultato = this.studenti[i];
    	    }
    	i++;
    } 
    return risultato;
    }
	public Studente[] cercaStudentiByText(String testo){
	    Studente[] risultato = null;//creo nuovo array studenti chiamato risultato vuoto
	    int numeroStudenti = 0;
	    for(int i = 0; i < this.studenti.length; i++){//ciclo l'array studenti originale
	        if(this.studenti[i].toString().contains(testo)){
	            numeroStudenti++;
	        }
	    }
	    if(numeroStudenti > 0){ //se abbiamo trovato almeno uno studente
	        risultato = new Studente[numeroStudenti]; //inizializzo l' array risultato con lunghezza uguale al numero di strumenti trovati
	        int j = 0;
	        for(int i = 0; i < this.studenti.length; i++){
	            if(this.studenti[i].toString().contains(testo)){//passo dall'array precedente "studenti" all'array "risultato"  gli studenti che corrispondono al testo
	                risultato[j] = this.studenti[i];
	                j++;
	            }
	        }
	    }
	    return risultato;
	}
/*In pratica, il metodo scorre l'array di studenti della classe e controlla se la rappresentazione in stringa di ogni studente contiene il testo specificato. 
Se lo contiene, il metodo incrementa il contatore di studenti che soddisfano il criterio.
Se viene trovato almeno uno studente che soddisfa il criterio, il metodo crea un nuovo array di studenti che avrà come dimensione il numero di studenti trovati.
Il metodo quindi scorre nuovamente l'array di studenti e aggiunge solo gli studenti che soddisfano il criterio nell'array risultato.
Infine, il metodo restituisce l'array risultato contenente tutti gli studenti che soddisfano il criterio di ricerca. 
Se nessuno studente soddisfa il criterio, viene restituito un array vuoto.
*/

    public void ordina() {
        for (int i = 0; i < this.studenti.length - 1; i++) {
            for (int j = 0; j < this.studenti.length - i - 1; j++) {
                if (this.studenti[j].getNome().compareTo(this.studenti[j + 1].getCognome()) > 0) {
                    Studente temp = this.studenti[j];
                    this.studenti[j] = this.studenti[j + 1];
                    this.studenti[j + 1] = temp;
				}
			}
		}
	}
	public double calcolaMedia(){
		double risultato = 0;
		for(int i = 0; i< this.studenti.length;i++){
			risultato += this.studenti[i].getVotoMedio();
	    }
	    risultato= risultato/this.studenti.length;
	    return risultato;
	}
	public Studente[] getStudenti(){
		return studenti;
	}

}
