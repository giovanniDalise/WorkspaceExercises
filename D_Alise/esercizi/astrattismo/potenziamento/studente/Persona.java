package esercizi.astrattismo.potenziamento.studente;

public abstract class Persona{
	private String nome;
	private String cognome;

	public Persona(){
    }
    public void setNome(String nome){
    	this.nome=nome;
    }
    public void setCognome(String cognome){
    	this.cognome=cognome;
    }    
    public String getNome(){
    	return this.nome;
    }
    public String getCognome(){
    	return this.nome;
    }    
}    