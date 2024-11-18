package esercizi.convertitoreFormato;

public class ConvertitoreFormatoScomposto{
	public static void main(String[] input){
		
		int primoNumero = InputDaTastiera.convertiStringaToInteger("Inserisci il primo numero:");
		int secondoNumero = InputDaTastiera.convertiStringaToInteger("Inserisci il secondo numero:");
		
		//autoboxing da NUMERO INTERO a CONTENITORE
		Integer wrapperPrimoNumero = primoNumero;
		Integer wrapperSecondoNumero = secondoNumero;
		
		//valori int
		System.out.println("Il corrispettivo valore in int del PRIMO NUMERO e' pari a " + wrapperPrimoNumero);
		System.out.println(printType(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.SIZE));
		System.out.println("Il corrispettivo valore in int del SECONDO NUMERO e' pari a " + wrapperSecondoNumero);
		System.out.println(printType(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.SIZE));
		
		//valori long
		System.out.println("Il corrispettivo valore in long del PRIMO NUMERO e' pari a " + wrapperPrimoNumero.longValue());
		System.out.println(printType(Long.MIN_VALUE, Long.MAX_VALUE, Long.SIZE));
		System.out.println("Il corrispettivo valore in long del SECONDO NUMERO e' pari a " + wrapperSecondoNumero.longValue());
		System.out.println(printType(Long.MIN_VALUE, Long.MAX_VALUE, Long.SIZE));
		
		//valori double
		System.out.println("Il corrispettivo valore in double del PRIMO NUMERO e' pari a " + wrapperPrimoNumero.doubleValue());
		System.out.println(printType(Double.MIN_VALUE, Double.MAX_VALUE, Double.SIZE));
		System.out.println("Il corrispettivo valore in double del SECONDO NUMERO e' pari a " + wrapperSecondoNumero.doubleValue());
		System.out.println(printType(Double.MIN_VALUE, Double.MAX_VALUE, Double.SIZE));
		
		//valori float
		System.out.println("Il corrispettivo valore float del PRIMO NUMERO e' pari a " + wrapperPrimoNumero.floatValue());
		System.out.println(printType(Float.MIN_VALUE, Float.MAX_VALUE, Float.SIZE));
		System.out.println("Il corrispettivo valore in float del SECONDO NUMERO e' pari a " + wrapperSecondoNumero.floatValue());
		System.out.println(printType(Float.MIN_VALUE, Float.MAX_VALUE, Float.SIZE));
	}	
	
	//non serve che venga richiamato da altre classi (solo dal nostro main) quindi "private"
	private static String printType(double minValue, double maxValue, double size){
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + minValue) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + maxValue) +
					 ("\nLo spazio occupato e' pari a " + size);
		return promptText;
	}
}