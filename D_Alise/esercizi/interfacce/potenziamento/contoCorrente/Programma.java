package esercizi.interfacce.potenziamento.contoCorrente;

/*Scrivi una classe che rappresenta un conto corrente bancario. L'oggetto conto corrente ha un saldo e un numero di conto. 
Implementa l'interfaccia Cloneable in modo che gli utenti possano clonare i proprio conto corrente.*/

public class Programma{
	public static void main(String[] args){
        String a = new String("ciao");
        System.out.println(a.hashCode());//riferimento di memoria di String immutabile (concetto di pool di Stringhe immutabili)
        String b = new String("ciao");   //non fare caso a questo esempio non ti funziona sta funzione finche non la attivi
        System.out.println(b.hashCode());

        ContoCorrente conto1 = new ContoCorrente(2000, "38950267947859287465");
        System.out.println("cc1" +conto1.toString());  //array di valore 0
        ContoCorrente conto2 = conto1.clone();
        System.out.println("cc1" + conto2.toString()); //array di valore 0
        conto2.getTest().getStato().add("ciao");//aggiungo un indice all'array
        System.out.println("cc1" +conto1.toString());  //array di valore 1

	}
}   /*qui ho fatto un test creando un nuovo oggetto test e vediamo che stampando il conto1 la prima e la terza volta avremo un valore diverso(size dell'array)  mentre la seconda
volta saranno uguali ma questo accadrà solo perchè il secondo conto sta semplicemente utilizzando il riferimento del contocorrente1 per clonare un
un oggetto realmente invece dovremo creare un nuovo oggetto (il super.clone invece clona il riferimento)