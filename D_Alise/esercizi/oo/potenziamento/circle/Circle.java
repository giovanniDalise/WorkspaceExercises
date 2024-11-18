package esercizi.oo.potenziamento.circle;

public class Circle{
	private double radius;
	private double x;
	private double y;

	public Circle(double radius, double x, double y){	
		this.radius = radius;
		this.x = x;
		this.y = y;	
	}
	public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
	
}