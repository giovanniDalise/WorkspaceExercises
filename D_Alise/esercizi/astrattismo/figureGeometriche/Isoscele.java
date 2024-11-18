package esercizi.astrattismo.figureGeometriche;

public class Isoscele extends Triangolo{
	private double lati;
	
	public Isoscele(double base, double altezza, double lati){
		super(base, altezza);
		this.lati = lati;
	}
	
	public double calcolaPerimetro(){
		return (lati * 2) + base;
	}
}