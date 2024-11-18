/*Crea un programma che rappresenta la classe "Veicolo" con attributi come "marca", 
"modello" e "anno di fabbricazione" e una classe figlia "Automobile" con attributi specifici come "cilindrata" e "numero di porte". 
Nel main, crea un'istanza di Automobile e stampa i suoi attributi.*/
package esercizi.ereditarieta.potenziamento.automobile;

public class AutoMain{
		public static void main(String[] args){
			Automobile automobile = new Automobile("Ferrari","Roma",3855,2);
			System.out.println(automobile);

	}
}