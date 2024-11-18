package esercizi.astrattismo.figureGeometriche;

public class Cerchio extends FiguraGeometrica{
	private double raggio;
	private double p = Math.PI;
	
	public Cerchio(double raggio){
		super();
		this.raggio = raggio;
	}
	
	public double calcolaArea(){
		return (raggio * raggio) * p;
	}
	
	public double calcolaPerimetro(){
		return (2 * p* raggio);
	}
	
}