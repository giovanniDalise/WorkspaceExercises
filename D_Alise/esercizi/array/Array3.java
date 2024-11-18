package esercizi.array;
import esercizi.utility.Tastiera;
import java.util.Arrays;
public class Array3
{  
	public static void main(String[] input){
		String[] array=new String[0];
		String messaggio="Aggiungi una stringa qualsiasi al vettore o digita exit per uscire:";
		String parola=Tastiera.chiediStringa(messaggio);
		while(!parola.equalsIgnoreCase("exit")){
			//v=Arrays.copyOf(v,v.length+1);
			array=ToolsVettore.incrementaArrayString(array);
			array[array.length-1]=parola;
			parola=Tastiera.chiediStringa(messaggio);
		}
		System.out.println("Array finale: "+Arrays.toString(array));
	}
}