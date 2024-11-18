package esercizio;

import java.io.Serializable;

public class Film implements Serializable {
	private String titolo;
	private int annoUscita;
	private String genere;
	
	public Film(String titolo, int annoUscita, String genere){
		this.titolo = titolo;
		this.annoUscita = annoUscita;
		this.genere = genere;
	}
	
	public String getTitolo(){
		return this.titolo;
	}
	
	public String getGenere(){
		return this.genere;
	}
	
	public int getAnnoUscita(){
		return this.annoUscita;
	}
	
	public String toString(){
		return this.titolo + ", " + this.annoUscita + ", " + this.genere;
	}
}