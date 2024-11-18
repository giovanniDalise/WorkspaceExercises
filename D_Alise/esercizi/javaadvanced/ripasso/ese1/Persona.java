package esercizi.javaadvanced.ripasso.ese1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona{
	protected String nome;
	protected String cognome;
	protected LocalDate dataDiNascita;

	public Persona(String nome, String cognome,LocalDate dataDiNascita){
		this.nome=nome;
		this.cognome=cognome;
		this.dataDiNascita=dataDiNascita;
	}
	public void presentati(){
		System.out.println("Ciao io mi chiamo" +this.nome +this.cognome+" e ho "+getEta()+ " anni.");
	}
	public String getNome(){
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}	

	public LocalDate getDataDiNascita(){
		return this.dataDiNascita;
	}	
	public long getEta(){
        long eta = ChronoUnit.YEARS.between(dataDiNascita,LocalDate.now());
        return eta;
	}
	public boolean equals(Object obj){
		if(obj==this){
		    return true;	
		} 
		if (!(obj instanceof Persona)){
			return false;
		}
		Persona objr = (Persona) obj;
		return objr.nome.equals(this.nome) && objr.cognome.equals(this.cognome) && objr.dataDiNascita.equals(this.dataDiNascita);		
	}

}