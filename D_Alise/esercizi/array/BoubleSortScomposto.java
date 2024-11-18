package esercizi.array;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import esercizi.utility.Tastiera;
public class BoubleSortScomposto{
	public static void main(String[] input) throws FileNotFoundException{
		ordinaVettoreInteri();
		ordinaVettoreStringhe();
	}
	public static void ordinaVettoreStringhe() throws FileNotFoundException{
		String[] vettore = leggiFile(Tastiera.chiediStringa("Inserire Nome File"));
		String[] vettoreOrdinato = ToolsVettore.ordinaVettore(vettore);
		ToolsVettore.stampaVettore(vettoreOrdinato,"Vettore Ordinato");
	}
	public static void ordinaVettoreInteri(){
		int[] vettore = ToolsVettore.caricaVettore(101);
		ToolsVettore.stampaVettore(vettore,"Array caricato");
		int[] vettoreOrdinato = ToolsVettore.ordinaVettore(vettore);
		ToolsVettore.stampaVettore(vettoreOrdinato,"Array Ordinato");
	}
	public static String[] leggiFile(String nomeFile) throws FileNotFoundException{
		String[] array = new String[0]; //array vuoto
		File input = new File(nomeFile); //creazione della variabile input di tipo file che legge il nostro file(nomefile)
		Scanner sc = new Scanner(input); //scanner per leggere l'input
		while(sc.hasNext()){ //fino a che scanner avrà un prossimo token nel file
			String parola = sc.next(); //string parola prenderà il valore letto da scanner con next(ossia prossimo token)
			String[] arrayTmp= new String[array.length+1];//dobbiamo creare un array temporaneo nel caso in cui la lunghezza dell'array originale fosse troppo piccola per il numero di parole da inserire(+1 di lunghezza rispetto all'array originale)
			arrayTmp[arrayTmp.length-1]= parola;//qui diciamo che parola viene copiata nell'ultimo indice dell array temporaneo(ultimo indice ossia lunghezza meno 1 dato che l'indice parte da zero rispetto alla lunghezza che parte da 1)
			for(int i=0; i< array.length; i++){ 
				arrayTmp[i]= array[i];//Viene quindi copiato il contenuto dell'array originale nell'array temporaneo, utilizzando un ciclo for.
			}                         //Infine, l'array originale viene sostituito con l'array temporaneo.
			array= arrayTmp;//In questo modo, ogni volta che viene letta una nuova parola dal file, l'array viene espanso di una posizione e la nuova parola viene aggiunta alla fine dell'array. 
		}                   //Alla fine del ciclo while, l'array conterrà tutte le parole lette dal file.
		return array;
	}
}