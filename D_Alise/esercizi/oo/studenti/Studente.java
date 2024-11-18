package esercizi.oo.studenti;

public class Studente{
	private String nome;
	private int eta;
	private float voto;
	private String email;

	    public Studente (String nome, int eta, float voto, String email){
	    	this.nome = nome;
	    	this.eta = eta;
	    	this.voto = voto;
	    	this.email = email;
	    }
	    public void setNome(String nuovoNome){
	    	this.nome=nuovoNome;

	    }
	    public void setEta(int nuovaEta){
            this.eta=nuovaEta;
	    }
	    public void setVoto(float nuovoVotoMedio){
	    	this.voto=nuovoVotoMedio;

	    }
	    public void setEmail(String nuovaEmail){
            this.email=nuovaEmail;
	    }
        public String getNome(){		
		    return nome;
		}
		public int getEta(){		
			return eta;
		}
		public float getVotoMedio(){		
			return voto;
		}
		public String getEmail(){		
			return email;
		}
}
