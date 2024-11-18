package esercizi.javaadvanced.generics.ese1;
public class Carta implements Comparable<Carta>{
	private int valore;
	private String seme;
	
	public Carta(int valore, String seme){
		this.valore = valore;
		this.seme = seme;
	}
	
	public int getValore(){
		return this.valore;
	}
	
	public String getSeme(){
		return this.seme;
	}
	
	public int compareTo(Carta carta){
		int result = this.valore - carta.getValore();
		if(result == 0){
			result = this.seme.compareTo(carta.getSeme());
		}
		return result;
	}

	public String toString(){
			return valore + "|||||||" + seme;
		}
}
