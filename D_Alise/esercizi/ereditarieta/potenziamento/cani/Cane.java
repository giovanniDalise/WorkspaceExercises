package esercizi.ereditarieta.potenziamento.cani;
public class Cane{
	protected String verso ="bau";
	protected Boolean sazio;	

	public Cane(){
	}
	public void abbaia(){
		System.out.println(verso);
	}
	public boolean mangia(){
		this.sazio=true;
		return sazio;
	}	
}