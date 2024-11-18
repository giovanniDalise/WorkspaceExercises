package esercizi.wrapper;
import esercizi.Tastiera;
import java.util.Scanner;
public class ConversioniDouble{
	public static void main(String[] args){
		double valore1 = Tastiera.chiediDouble("Inserire valore 1");
		double valore2 = Tastiera.chiediDouble("Inserire valore 2");
		Double doubleValore1 = valore1;
		System.out.println(doubleValore1.intValue());
		System.out.println(Integer.SIZE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(doubleValore1.longValue());
		System.out.println(Long.SIZE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		System.out.println(doubleValore1.floatValue());
		System.out.println(Float.SIZE);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		
		System.out.println(doubleValore1);
		System.out.println(Double.SIZE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
	}
}