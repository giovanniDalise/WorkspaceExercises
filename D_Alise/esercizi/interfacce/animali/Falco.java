package esercizi.interfacce.animali;

import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Falco extends Animale{
	
	public Falco(Posizione posizione){
		super(posizione);
	}
	
	public boolean isAffamato(){
		long temp = new Date().getTime();
		long differenza = temp - this.timestampCibo;
		long sec = TimeUnit.MILLISECONDS.toSeconds(differenza);
		if( sec >= 40){
			return true;
		} else{
			return false;
		}
	}
	
	public String toString(){
		Posizione p = super.getPosizione();
		return "Falco: Affamato: " + isAffamato() + " Posizione: " + p.getX() + ", " + p.getY();
	}
	
	public String faiIlVerso(){
		return "AAAAAAHHHHHH";
	}
	
	public void muoviti(Posizione p){
		super.setPosizione(p);
	}
	
	public void mangia(){
		System.out.println("Suono grato del falco");
		this.timestampCibo = new Date().getTime();
	}
}