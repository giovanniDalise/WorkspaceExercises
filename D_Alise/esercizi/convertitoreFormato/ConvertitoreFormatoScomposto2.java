package esercizi.convertitoreFormato;

public class ConvertitoreFormatoScomposto2{
	public static void main(String[] input){
		
		int primoNumero = InputDaTastiera2.convertiStringaToInteger("Inserisci il primo numero:");
		int secondoNumero = InputDaTastiera2.convertiStringaToInteger("Inserisci il secondo numero:");
		
		//autoboxing da NUMERO INTERO a CONTENITORE
		Integer wrapperPrimoNumero = primoNumero;
		Integer wrapperSecondoNumero = secondoNumero;
		
		//valori int	
		System.out.println(PromptText2.promptoTestoInt("int", "PRIMO NUMERO", "SECONDO NUMERO", wrapperPrimoNumero, wrapperSecondoNumero));
		
		//valori long
		System.out.println(PromptText2.promptoTestoLong("long", "PRIMO NUMERO", "SECONDO NUMERO", wrapperPrimoNumero.longValue(), wrapperSecondoNumero.longValue()));
		
		//valori double
		System.out.println(PromptText2.promptoTestoDouble("double", "PRIMO NUMERO", "SECONDO NUMERO", wrapperPrimoNumero.doubleValue(), wrapperSecondoNumero.doubleValue()));
		
		//valori float
		System.out.println(PromptText2.promptoTestoFloat("float", "PRIMO NUMERO", "SECONDO NUMERO", wrapperPrimoNumero.floatValue(), wrapperSecondoNumero.floatValue()));
	}	
}