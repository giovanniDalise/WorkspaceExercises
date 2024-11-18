package esercizi.potenziamento.wrapper;
import esercizi.utility.Tastiera;
public class NumeroInteger{
	public static void main(String[] args){

        int numero = Tastiera.chiediIntero("Inserisci un numero intero:");
		Integer integer = numero;
		System.out.println(integer);
	}
}