package esercizi.interfacce.potenziamento.negozioDischi;

public class Disco implements Comparable<Disco>{
	private String nome;
	private String artista;
	private double prezzo;
	private int quantita;

	public Disco (String nome, String artista, double prezzo, int quantita){
		this.nome=nome;
		this.artista=artista;
		this.prezzo=prezzo;
		this.quantita=quantita;
	}
	public int compareTo(Disco other) {
        return Double.compare(this.prezzo, other.prezzo);
    }
    public String toString(){
		return this.nome + ", " + this.artista + ", " + this.prezzo + ", " + this.quantita;	
	}

}