/*Crea un programma che rappresenta la classe "FormaGeometrica" con metodi per il calcolo dell'area e del perimetro e una classe 
figlia "Rettangolo" che estende la classe FormaGeometrica e ha attributi specifici come "lunghezza" e "larghezza".
 Nel main, crea un'istanza di Rettangolo e stampa il suo perimetro.*/

package esercizi.ereditarieta.potenziamento.rettangolo;
import esercizi.utility.Tastiera;

public class RettangoloMain{
	public static void main(String[] args){
		double altezza=Tastiera.chiediDouble("Inserisci l'altezza del rettangolo:");
		double base=Tastiera.chiediDouble("Inserisci la base del rettangolo:");
        Rettangolo rettangolo = new Rettangolo(altezza,base);
        double perimetro=rettangolo.calcolaPerimetro(altezza,base);
        double area=rettangolo.calcolaArea(altezza,base);
        System.out.println("Area: " + area);
        System.out.println("Perimetro: " + perimetro);        
	}
}