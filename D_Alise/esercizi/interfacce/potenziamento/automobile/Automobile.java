package esercizi.interfacce.potenziamento.automobile;

public class Automobile{
	private String marca;
	private String modello;
	private int annoProduzione;

	public Automobile(String marca, String modello, int annoProduzione){
		this.marca=marca;
		this.modello=modello;
		this.annoProduzione=annoProduzione;
	}
	public String getModello(){
		return this.modello;
	}
	public String getMarca(){
		return this.marca;
	}
	public int getAnnoProduzione(){
		return this.annoProduzione;
	}		
	public String toString(){
		return "Marca:"+this.marca+", Modello:"+ this.modello+", Anno di Produzione:"+this.annoProduzione;
	}
	
}