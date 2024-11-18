package esercizi.ereditarieta.potenziamento.automobile;

public class Automobile extends Veicolo{
	private float cilindrata;
	private int numeroPorte;

	public Automobile(String marca,String modello,float cilindrata,int numeroPorte){
		super(marca,modello);
        this.cilindrata=cilindrata;
        this.numeroPorte=numeroPorte;
	}	
    public String toString(){
        return getMarca() + " - " + getModello() + " - " + this.cilindrata + " - " + this.numeroPorte;
    }
}