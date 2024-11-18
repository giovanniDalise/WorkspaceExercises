package esercizi.astrattismo.figureGeometriche;

public class Equilatero extends Triangolo{
	
	public Equilatero(double base, double altezza){
		super(base, altezza);
	}
	
	public double calcolaPerimetro(){
		return (base * 3);
	}
}