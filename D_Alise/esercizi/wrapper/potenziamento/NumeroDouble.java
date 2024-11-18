package esercizi.potenziamento.wrapper;
import esercizi.utility.Tastiera;
public class NumeroDouble{
	public static void main(String[] args){

        double decimale = Tastiera.chiediDouble("Inserisci un numero decimale:");
		Double decimaleWrap  = decimale;
		System.out.println(decimaleWrap);
	}
}