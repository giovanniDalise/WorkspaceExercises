package esercizi.interfacce.animali;

import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Tigre extends Animale{
	
	public Tigre(Posizione posizione){
		super(posizione);
	}
	
	public boolean isAffamato(){
		long differenza = (new Date().getTime()) - this.timestampCibo;
		long sec = TimeUnit.MILLISECONDS.toSeconds(differenza);
		if( sec >= 80){
			return true;
		} else{
			return false;
		}
	}
	
	public String toString(){
		Posizione p = super.getPosizione();
		return "Tigre: Affamato: " + isAffamato() + " Posizione: " + p.getX() + ", " + p.getY();
	}
	
	public String faiIlVerso(){
		return "ROOOAR";
	}
	
	public void muoviti(Posizione p){
		super.setPosizione(p);
	}
	
	public void mangia(){
		System.out.println("Suono grato della tigre");
		this.timestampCibo = new Date().getTime();
	}
}