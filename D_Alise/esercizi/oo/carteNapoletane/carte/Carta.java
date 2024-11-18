package esercizi.oo.carteNapoletane.carte;
import java.util.Random;
import java.util.Arrays;
import carte.tools.Tools;

public class Carta
{
	public String valore;
	public String seme;
	public boolean pescata;	
	public Carta(String valore,String seme){

		this.valore=valore;
		this.seme=seme;
		this.pescata=false;		
	}

	
	public boolean equals(Object obj){
		if(obj==this) return true;
		if (!(obj instanceof Carta)) return false;
		Carta objr = (Carta) obj;
		return objr.valore.equals(this.valore) && objr.seme.equals(this.seme);		
	}
	
	public String toString(){
		return this.valore+" di "+this.seme;
	}

}

