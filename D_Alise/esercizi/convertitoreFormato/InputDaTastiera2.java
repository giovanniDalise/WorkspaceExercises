package esercizi.convertitoreFormato;
import java.util.Scanner;

public class InputDaTastiera2{

	static Scanner sc = new Scanner(System.in);
	
	//---------------------
	//---------------------
	
	//CHIEDE UNA STRINGA

	public static String chiediStringa(String text){
		System.out.println(text);
		String textInput = sc.nextLine();
	return textInput;		
	}

	//---------------------
	//---------------------
	
	//CHIEDE UN NUMERO INTERO

	public static int chiediInt(String text){
		System.out.println(text);
		int numeroIntero = sc.nextInt();
	return numeroIntero;
	}
	
	//---------------------
	//---------------------
	
	//CHIEDE UN NUMERO DOUBLE
	
	public static double chiediDouble(int text){
		System.out.println(text);
		double numeroDouble = sc.nextDouble();
	return numeroDouble;
	}
	
	//---------------------
	//---------------------
	
	//CONVERTITORE DA STRINGA A INTERO
	
	public static int convertiStringaToInteger(String text){
		String stringaDaConvertire = InputDaTastiera.chiediStringa(text);
		int numeroIntero = Integer.parseInt(stringaDaConvertire); //analizzo la stringa e la converto in intero
	return numeroIntero;
	}
	
	//---------------------
	//---------------------
	
	//CHIEDI UN NUMERO INTERO COMPRESO TRA "X" E "Y"
	
	public static int chiediNumeroCompreso(int numMin, int numMax){
		int scelta;
		do{
			System.out.println("Inserisci un numero compreso tra " + numMin + " e " + numMax);
			scelta = sc.nextInt();
		}while(scelta < numMin && scelta > numMax);
		return scelta;
	}
}