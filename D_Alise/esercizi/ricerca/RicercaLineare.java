package esercizi.ricerca;
import esercizi.utility.Tastiera;
import esercizi.array.ToolsVettore;

public class RicercaLineare{
    public static void main(String[] input){
    	int [] array = ToolsVettore.caricaVettore(20);
        int numero = Tastiera.chiediInteroPositivo("Inserisci un numero");
        int posizione = ottieniPosizione(array,0,numero);
        ToolsVettore.stampaVettore(array, "Sequenza:");
        System.out.println("Il numero di trova nell'indice: "+ posizione);
    }
    public static int ottieniPosizione(int[]array,int indice, int numero){
        if (array[indice] ==numero){

        }else{
            if(indice<array.length-1){
            	indice =ottieniPosizione(array,++indice,numero);
            }else{
            	indice = -1;
            }
        }
        return indice;
    }
}    

