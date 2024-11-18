package esercizi.oo.studenti.studenti2;
public class Studente{
	String nome;
	String cognome;
	String email;
	int eta;
	double mediaVoti;
	int numVoti;

	    public Studente(String nome,String cognome,String email,int eta){
		    this.nome=nome;
		    this.cognome=cognome;
		    this.email=email;
	        this.eta=eta;
	    }	    
        public String getNome(){		
		    return nome;
		}
        public String getCognome(){		
		    return nome;
		}		
		public int getEta(){		
			return eta;
		}
		public double getVotoMedio(){		
			return mediaVoti;
		}
		public String getEmail(){		
			return email;
		}
		public String toString() {
            return this.nome +" "+ this.cognome +" "+this.email +" "+ this.eta;
        }    
		public double aggiungiVoto(double voto){
		    double media = (mediaVoti*numVoti)+voto/(numVoti+1);
		    numVoti++;
		    mediaVoti = media;
		    return mediaVoti;
}

}

