package esercizi.array.potenziamento;

public class Potenziamento1{
	public static void main(String[]args){
		int [] array = ToolsVettore.caricaVettore(20);
		ToolsVettore.stampaVettore(array,"Array:");
		int somma = 0;
		for(int i = 0; i<array.length;i++){
			if(array[i]%2==0){
				somma += array[i];
			}
		}
		System.out.println("La somma dei numeri pari all'interno dellarray è " + somma);

	}
}