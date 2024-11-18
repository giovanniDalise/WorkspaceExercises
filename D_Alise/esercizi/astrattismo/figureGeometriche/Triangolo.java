 package esercizi.astrattismo.figureGeometriche;

public abstract class Triangolo extends FiguraGeometrica{
	protected double base;
	protected double altezza;
	
	public Triangolo(double base, double altezza){
		super();
		this.base = base;
		this.altezza = altezza;
	}
	
	public double calcolaArea(){
		return (base * altezza) / 2;
	}
	
	public abstract double calcolaPerimetro();
}