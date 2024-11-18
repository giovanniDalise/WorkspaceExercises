package esercizi.ricerca;
import esercizi.utility.Tastiera;
import esercizi.array.ToolsVettore;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RicercaLineareParola {	
	public static void main (String[] args){

	    try{
            // Apri il file di testo in input
            Scanner input = new Scanner(new File("./esercizi/array/BeatlesOut.txt"));

		    String[] array=new String[0]; //array vuoto

            while(input.hasNext()){          //incremento di 1 alla volta l'array vuoto e contemporaneamente lo popolo con le parole del file
				array=ToolsVettore.incrementaArrayString(array);
				array[array.length-1]=input.next();
		    }
            String parolaRicercata = Tastiera.chiediStringa("Inserisci la parola da cercare:");
					int indiceElemento = ricercaLineare (array, parolaRicercata);
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

	public static int ricercaLineare(String[] array, String parolaRicercata) {
	    int result = -1;
	    int i = 0;
	    while (i < array.length && !parolaRicercata.equalsIgnoreCase(array[i])) {
	        i++;
	    }
        if (i < array.length && parolaRicercata.equalsIgnoreCase(array[i])) {
            result = i;
	    }
	    return result;
    }
			
}
		            