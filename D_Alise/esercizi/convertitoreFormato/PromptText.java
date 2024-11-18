package esercizi.convertitoreFormato;

public class PromptText{
	
	//TESTO VALORE IN INT DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreInt(String text){
		
		System.out.println(text);
		
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Integer.MIN_VALUE) +
		("\nIl corrispettivo VALORE MASSIMO e' pari a " + Integer.MAX_VALUE) +
		("\nLo spazio occupato e' pari a " + Integer.SIZE);

	return promptText;
	}
	
	//TESTO VALORE IN LONG DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreLong(String text){
		
		System.out.println(text);
		
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Long.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Long.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Long.SIZE);

	return promptText;
	}
	
	//TESTO VALORE IN DOUBLE DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreDouble(String text){
		
		System.out.println(text);
		
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Double.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Double.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Double.SIZE);

	return promptText;
	}
	
	//TESTO VALORE IN FLOAT DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreFloat(String text){
		
		System.out.println(text);
		
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Float.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Float.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Float.SIZE);

	return promptText;
	}
}