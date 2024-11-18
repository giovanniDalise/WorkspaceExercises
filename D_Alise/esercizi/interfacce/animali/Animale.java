package esercizi.interfacce.animali;

import java.util.Date;
import java.util.concurrent.TimeUnit;
public abstract class Animale implements Muoversi,FareIlVerso,Mangiare{
	protected long timestampCibo;
	private Posizione posizione;

	public Animale(Posizione posizione){
		this.posizione = posizione;
		this.timestampCibo = new Date().getTime();
	}
	
	public abstract boolean isAffamato();
	
	public Posizione getPosizione(){
		return this.posizione;
	}
	
	public void setPosizione(Posizione posizione){
		this.posizione = posizione;
	}
	
	public abstract String toString();
	public abstract void muoviti(Posizione p);
	public abstract String faiIlVerso();
	public abstract void mangia();
}