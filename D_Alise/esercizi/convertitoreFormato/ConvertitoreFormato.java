package esercizi.convertitoreFormato;
import java.util.Scanner;

public class ConvertitoreFormato{
	public static void main(String[] input){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserisci il primo numero:");
		String primoNumero = sc.nextLine();
		
		System.out.println();

		
		int numeroDaStringaInteger = Integer.parseInt(primoNumero);
		System.out.println("Il corrispettivo valore in int e' pari a " + numeroDaStringaInteger);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Integer.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Integer.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Integer.SIZE);
		
		System.out.println();
		
		long numeroDaStringaLong = Long.parseLong(primoNumero);
		System.out.println("Il corrispettivo valore in long e' pari a " + numeroDaStringaLong);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Long.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Long.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Long.SIZE);
		
		System.out.println();
		
		double numeroDaStringaDouble = Double.parseDouble(primoNumero);
		System.out.println("Il corrispettivo valore in double e' pari a " + numeroDaStringaDouble);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Double.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Double.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Double.SIZE);
		
		System.out.println();
		
		float numeroDaStringaFloat = Float.parseFloat(primoNumero);
		System.out.println("Il corrispettivo valore in float e' pari a " + numeroDaStringaFloat);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Float.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Float.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Float.SIZE);
		
		//------------------------------------------------------
		//------------------------------------------------------
		//------------------------------------------------------
		
		System.out.println();
		
		System.out.println("Inserisci il secondo numero:");
		String secondoNumero = sc.nextLine();
		
		System.out.println();
		
		int secondoNumeroDaStringaInteger = Integer.parseInt(secondoNumero);
		System.out.println("Il corrispettivo valore in int e' pari a " + secondoNumeroDaStringaInteger);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Integer.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Integer.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Integer.SIZE);
		
		System.out.println();
		
		long secondoNumeroDaStringaLong = Long.parseLong(secondoNumero);
		System.out.println("Il corrispettivo valore in long e' pari a " + secondoNumeroDaStringaLong);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Long.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Long.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Long.SIZE);
		
		System.out.println();
		
		double secondoNumeroDaStringaDouble = Double.parseDouble(secondoNumero);
		System.out.println("Il corrispettivo valore in double e' pari a " + secondoNumeroDaStringaDouble);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Double.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Double.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Double.SIZE);
		
		System.out.println();
		
		float secondoNumeroDaStringaFloat = Float.parseFloat(secondoNumero);
		System.out.println("Il corrispettivo valore in float e' pari a " + secondoNumeroDaStringaFloat);
		System.out.println("Il corrispettivo VALORE MINIMO e' pari a " + Float.MIN_VALUE);
		System.out.println("Il corrispettivo VALORE MASSIMO e' pari a " + Float.MAX_VALUE);
		System.out.println("Lo spazio occupato e' pari a " + Float.SIZE);
	}
}