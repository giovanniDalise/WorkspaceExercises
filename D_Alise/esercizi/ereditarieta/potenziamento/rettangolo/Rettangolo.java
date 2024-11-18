package esercizi.ereditarieta.potenziamento.rettangolo;

public class Rettangolo extends FormaGeometrica{
	protected double altezza;
	protected double base;

	public Rettangolo(double altezza,double base){
	    super(altezza,base);	
    }
    public double calcolaPerimetro(double altezza,double base){
    	double perimetro = (base+altezza)*2;
    	return perimetro;
    } 
    public double calcolaArea(double altezza,double base){
    	double area = base*altezza;
    	return area;
    } 
}