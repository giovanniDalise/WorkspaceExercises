package esercizi.astrattismo.figureGeometriche;

public class Scaleno extends Triangolo{
	private double lato1;
	private double lato2;
	
	public Scaleno(double base, double altezza, double lato1, double lato2){
		super(base, altezza);
		this.lato1 = lato1;
		this.lato2 = lato2;
	}
	
	public double calcolaPerimetro(){
		return (lato1+ lato2 + base);
	}
}