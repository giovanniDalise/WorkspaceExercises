/*Scrivi una classe che rappresenta un cerchio, con variabili di istanza come il raggio e la coordinata del centro. 
Implementa un metodo per calcolare l'area del cerchio.*/

package esercizi.oo.potenziamento.circle;
import esercizi.utility.Tastiera;

public class BootStrap{
	public static void main(String[] args){

        double radius = Tastiera.chiediDouble("Insert the decimal value of radius:");
        double x = Tastiera.chiediDouble("Insert the decimal value of x-coordinate of the center of rhe circle:");
        double y = Tastiera.chiediDouble("Insert the decimal value of y-coordinate of the center of rhe circle:");
        Circle circle = new Circle(radius,x,y);
        double area = circle.calculateArea();
        System.out.println("The circle area is " + area);
	}
}
