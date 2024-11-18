package esercizi.astrattismo.figureGeometriche;

public class Rettangolo extends FiguraGeometrica{
	private double base;
	private double altezza;
	
	public Rettangolo(double base, double altezza){
		super();
		this.base = base;
		this.altezza = altezza;
	}
	
	public double calcolaArea(){
		return base * altezza;
	}
	
	public double calcolaPerimetro(){
		return (base + altezza) * 2;
	}
	
}