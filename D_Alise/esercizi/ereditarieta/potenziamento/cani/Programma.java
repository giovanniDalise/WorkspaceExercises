/*Crea una classe "Cane" con metodi per abbaiare e mangiare e una classe figlia "CaneGuida" con metodi specifici come "vaiA" . 
Nel main, crea diverse istanze di Cane e CaneGuida e per ognuna fai abbaiare il cane e se l'istanza è di tipo CaneGuida dagli l'ordine "vaiA".
*/
package esercizi.ereditarieta.potenziamento.cani;
public class Programma{
	public static void main(String[] args){
        Cane cane = new Cane();
        CaneGuida caneGuida = new CaneGuida();
        cane.abbaia();
        caneGuida.abbaia();
        caneGuida.vaiA();
	}
}