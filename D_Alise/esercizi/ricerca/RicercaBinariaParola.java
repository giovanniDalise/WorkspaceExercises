package esercizi.ricerca;
import esercizi.utility.Tastiera;
import esercizi.array.ToolsVettore;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RicercaBinariaParola {	
	public static void main (String[] args){

	    try{
            Scanner input = new Scanner(new File("./esercizi/array/Beatles.txt"));//creo uno scanner a cui do come input un file.txt
		    String[] array=new String[0]; //array vuoto
            while(input.hasNext()){ //incremento di 1 alla volta l'array vuoto e contemporaneamente lo popolo con le parole del file
				array = ToolsVettore.incrementaArrayString(array);
				array[array.length-1]=input.next();
		    }
            ToolsVettore.ordinaVettore(array);

            String parolaRicercata = Tastiera.chiediStringa("Inserisci la parola da cercare:");
            int indiceElemento = ricercaDicotomica(array,parolaRicercata);
			if (indiceElemento == -1){
				System.out.println("Elemento non trovato");
			} else { 
				System.out.println("Elemento trovato all'indice " + indiceElemento);
			}
		}catch(FileNotFoundException file_not_found){
				System.out.println("\nFILE_NON_TROVATO " + file_not_found.getMessage());
				file_not_found.printStackTrace();
		}
	}	

	public static int ricercaDicotomica(String[] array, String parola) {
	        int sinistra = 0; //primo indice a sinistra
	        int destra = array.length - 1; //ultimo indice ossia la lunghezza dell'array meno 1

	        while (sinistra <= destra) {//finche l'indice iniziale sarà più piccolo o uguale a quello finale
	            int medio = (sinistra + destra) / 2;// indice medio somma più divisione dato che il ciclo di ripete e sinistra e destra cambiano utilizziamo questa formula
		     int confronto = array[medio].compareToIgnoreCase(parola);//si confronta l'indice medio e la parola per ordine lessicografica(alfabetico secondo l'ASCII) restituendo un numero positivo o negativo
		        if (confronto == 0) { // in questa parte divide di volta in volta l'array in due parti partendo dal confronto tra la variabile confronto e indice medio in modo da non considerare una delle due parti(quella minore di medio o maggiore di medio)
		            return medio;
		        } else if (confronto < 0) {
		            sinistra = medio + 1;
		        } else {
		            destra = medio - 1;
		        }
		    }
		    return -1;
		}
}