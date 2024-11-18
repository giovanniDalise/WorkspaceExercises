package esercizi.javaadvanced.generics.ese1;
import java.time.LocalDate;
public class Persona implements Comparable<Persona>{
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	
	public Persona(String nome, String cognome, LocalDate dataDiNascita){
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
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
	
	public int compareTo(Persona persona){
		int result = this.nome.compareTo(persona.getNome());
		if(result == 0){
			result = this.cognome.compareTo(persona.getCognome());
			if( result == 0){
				result = this.dataDiNascita.compareTo(persona.getDataDiNascita());
			}
		}
		return result;
	}
	
	public String toString(){
			return nome + "|||||||" + cognome;
		}
}