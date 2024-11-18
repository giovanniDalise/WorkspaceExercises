package esercizi.interfacce.potenziamento.negozioDischi;
import java.util.Arrays;

/*Scrivi una classe che rappresenta un prodotto in un negozio online. 
L'oggetto prodotto ha un nome, un prezzo e una quantità disponibile. 
Implementa l'interfaccia Comparable in modo che i prodotti siano ordinati in base al prezzo.*/

public class NegozioDischi{
	private Disco[] dischi = new Disco[3];

	public static void main (String []args){
			
        NegozioDischi negozio = new NegozioDischi();
        negozio.dischi[0]= new Disco ("Field of Reeds","These New Puritans",16.22,10);
        negozio.dischi[1]= new Disco ("Roman Candle","Elliott Smith",26.24,5);
        negozio.dischi[2]= new Disco ("Spirit of Eden","Talk Talk",25.90,15);       
        negozio.visualizzaDischi();        
        negozio.ordinaDischi();
        System.out.println("Dischi in ordine di prezzo:");
        negozio.visualizzaDischi();
	}
	public void ordinaDischi(){
		Arrays.sort(dischi);

	}
	public void visualizzaDischi(){
		for(int i=0;i<dischi.length;i++){
			System.out.println(dischi[i].toString());
		}

	}
}