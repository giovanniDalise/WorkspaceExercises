package esercizi.interfacce.libreria;
public class Libro{
	private String titolo;
	private String autore;
	private String editore;
	
	public Libro(String titolo, String autore){
		this.titolo = titolo;
		this.autore = autore;
	}
	
	public Libro(){
	}
	
	public String getTitolo(){
		return this.titolo;
	}
	
	public String getAutore(){
		return this.autore;
	}
	
	public String getEditore(){
		return this.editore;
	}
	
	public void setEditore(String editore){
		this.editore = editore;
	}
	
	public void setAutore(String autore){
		this.autore = autore;
	}
	
	public void setTitolo(String titolo){
		this.titolo = titolo;
	}
	
	public String toString(){
		String result = this.titolo + " " + this.autore;
		result.toLowerCase();
		return result;
	}
}