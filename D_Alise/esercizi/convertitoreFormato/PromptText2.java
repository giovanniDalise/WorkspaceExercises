package esercizi.convertitoreFormato;

public class PromptText2{
	
	//TESTO VALORE IN INT DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreInt(){
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Integer.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Integer.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Integer.SIZE);
		return promptText;
	}
	
	//TESTO VALORE IN LONG DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreLong(){
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Long.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Long.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Long.SIZE);
		return promptText;
	}
	
	//TESTO VALORE IN DOUBLE DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreDouble(){
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Double.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Double.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Double.SIZE);
		return promptText;
	}
	
	//TESTO VALORE IN FLOAT DEL PRIMO E SECONDO NUMERO
	
	public static String testoValoreFloat(){
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + Float.MIN_VALUE) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + Float.MAX_VALUE) +
					 ("\nLo spazio occupato e' pari a " + Float.SIZE);
		return promptText;
	}
	
	//PROMPTO TESTO INT
	
	public static String promptoTestoInt(String tipo, String numero1, String numero2, int valore1, int valore2){
		String text;
		text = ("\nIl corrispettivo valore in " + tipo + " del " + numero1 + " e' pari a " + valore1 + "\n") +
			   (testoValoreInt()) +
			   ("\n\nIl corrispettivo valore in " + tipo + " del " + numero2 + " e' pari a " + valore2 + "\n") +
			   (testoValoreInt());
		return text;
	}
	
	//PROMPTO TESTO LONG
	
	public static String promptoTestoLong(String tipo, String numero1, String numero2, long valore1, long valore2){
		String text;
		text = ("\nIl corrispettivo valore in " + tipo + " del " + numero1 + " e' pari a " + valore1 + "\n") +
			   (testoValoreLong()) +
			   ("\n\nIl corrispettivo valore in " + tipo + " del " + numero2 + " e' pari a " + valore2 + "\n") +
			   (testoValoreLong());
		return text;
	}
	
	//PROMPTO TESTO DOUBLE
	
	public static String promptoTestoDouble(String tipo, String numero1, String numero2, double valore1, double valore2){
		String text;
		text = ("\nIl corrispettivo valore in " + tipo + " del " + numero1 + " e' pari a " + valore1 + "\n") +
			   (testoValoreDouble()) +
			   ("\n\nIl corrispettivo valore in " + tipo + " del " + numero2 + " e' pari a " + valore2 + "\n") +
			   (testoValoreDouble());
		return text;
	}
	
	//PROMPTO TESTO FLOAT
	
	public static String promptoTestoFloat(String tipo, String numero1, String numero2, float valore1, float valore2){
		String text;
		text = ("\nIl corrispettivo valore in " + tipo + " del " + numero1 + " e' pari a " + valore1 + "\n") +
			   (testoValoreFloat()) +
			   ("\n\nIl corrispettivo valore in " + tipo + " del " + numero2 + " e' pari a " + valore2 + "\n") +
			   (testoValoreFloat());
		return text;
	}
	
	// ATTRIBUTI TIPO
	
	public static String printType(double minValue, double maxValue, double size){
		String promptText;
		promptText = ("Il corrispettivo VALORE MINIMO e' pari a " + minValue) +
					 ("\nIl corrispettivo VALORE MASSIMO e' pari a " + maxValue) +
					 ("\nLo spazio occupato e' pari a " + size);
		return promptText;
	}
	
}