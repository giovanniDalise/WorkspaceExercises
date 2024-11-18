package esercizi.oo.carteNapoletane.carte;
import java.util.Arrays;
import carte.exceptions.CartaInesistente;
public class BootStrap
{
	public static void main(String[] args){
		Mazzo mazzo=new Mazzo();
		System.out.println("Mazzo generato:");
		mazzo.stampaMazzo();
		System.out.println("\n");
		Carta c1=mazzo.pesca();
		Carta c2=mazzo.pesca();
		System.out.println("Prima carta pescata: "+c1.toString());
		System.out.println("Seconda carta pescata: "+c2.toString());
		if(!c1.equals(c2)){
			System.out.println("Le 2 carte sono diverse.");
		}else{
			System.out.println("Le 2 carte sono uguali.");
		}
	}
}

