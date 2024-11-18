package esercizi.astrattismo.potenziamento.studente;

public class Studente extends Persona{
	int matricola;
	String corsoStudi;

	public Studente(){
		super();
    }
    public void setMatricola(int matricola){
    	this.matricola=matricola;
    }
    public void setCorsoStudi(String corsoStudi){
    	this.corsoStudi=corsoStudi;
    }    
    public int getMatricola(){
    	return this.matricola;
    }
    public String getCorsoStudi(){
    	return this.corsoStudi;
    }        
}