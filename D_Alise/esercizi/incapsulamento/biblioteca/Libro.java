package esercizi.incapsulamento.biblioteca;

public class Libro{
    private String titolo;
    private String autore;
    private String editore;

    public Libro(String titolo,String autore){
        this.titolo=titolo;
        this.autore=autore;
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
    	this.editore=editore;
    }
}