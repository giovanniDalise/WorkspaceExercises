package esercizi.array.potenziamento;
import esercizi.utility.Tastiera;

public class Potenziamento2{  
	public static void main(String[] input){
		String[] array=new String[0];
		String messaggio="Aggiungi una stringa qualsiasi al vettore o digita exit per uscire:";
		String parola=Tastiera.chiediStringa(messaggio);
		int max = 0;
		String parolaLunga = null;
		while(!parola.equalsIgnoreCase("exit")){
			array=ToolsVettore.incrementaArrayString(array);
			array[array.length-1]=parola;
			if(parola.length()>max){
				parolaLunga=parola;
			}
			parola=Tastiera.chiediStringa(messaggio);
		}
		System.out.println("La parola più lunga è " + parolaLunga);

	}
}