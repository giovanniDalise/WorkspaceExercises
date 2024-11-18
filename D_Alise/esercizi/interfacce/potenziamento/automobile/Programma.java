/*Scrivi una classe che rappresenta un'automobile. L'oggetto automobile ha una marca, un modello e un anno di produzione. 
Implementa l'interfaccia Comparator in modo che le automobili siano ordinate prima per marca,
poi per modello e infine per anno di produzione.*/

package esercizi.interfacce.potenziamento.automobile;
import java.util.Arrays;

public class Programma{
	private static Automobile[] automobili=new Automobile[3];

	public static void main(String[] args){
		automobili[0]=new Automobile("Alfa Romeo", "Giulia",2016);
		automobili[1]=new Automobile("Audi","A1 Sportback",2011);
        automobili[2]=new Automobile("BMW","M8 Coupé",2019);
        visualizzaAuto();
        ComparatorMarca cMarca = new ComparatorMarca();
		Arrays.sort(automobili, cMarca);
		System.out.println("ORDINATE PER MARCA");
		visualizzaAuto();
		ComparatorModello cModello = new ComparatorModello();
		Arrays.sort(automobili, cModello);
		System.out.println("ORDINATE PER MODELLO");
		visualizzaAuto();
        ComparatorAnnoProduzione cAnnoProduzione = new ComparatorAnnoProduzione();
		Arrays.sort(automobili, cAnnoProduzione);
		System.out.println("ORDINATE PER ANNO DI PRODUZIONE");
		visualizzaAuto();		

	}
	public static void visualizzaAuto(){
		for(int i = 0;i<automobili.length;i++){
			System.out.println(automobili[i].toString());
		}
	}
}
