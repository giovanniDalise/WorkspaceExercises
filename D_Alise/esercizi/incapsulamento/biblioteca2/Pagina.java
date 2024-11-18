package esercizi.incapsulamento.biblioteca2;
public class Pagina{
	private String testo;
	private String appunto;
	public Pagina(String testo){
		this.testo=testo;
	}
	public void inserisciAppunto(String testo){
		this.appunto=testo;
	}
	public String getTesto(){ 
		return this.testo; 
	}
	public String getAppunto(){ 
		return this.appunto; 
	}
}