package esercizi.array;
import java.util.Random;
public class ToolsVettore{

	public static void stampaVettore(int[] vettore, String messaggio){
		System.out.println(messaggio);
		for (int i = 0; i < vettore.length; i++) {
            System.out.print(vettore[i] + " ");
        }
		System.out.println();
	}
	
	public static void stampaVettore(String[] vettore, String messaggio){
		System.out.println(messaggio);
		for (int i = 0; i < vettore.length; i++) {
            System.out.print(vettore[i] + " ");
        }
		System.out.println();
	}
	
	public static int[] caricaVettore(int limite){ //limite è la variabile per cambiare il numero massimo raggiunto dal generatore random
		int[] vettore = new int[10];
        
		Random nRandom = new Random();
        for (int i = 0; i < vettore.length; i++) {
            vettore[i] = nRandom.nextInt(limite) + 1;
        }
		return vettore;
	}
	
	public static int[] ordinaVettore(int[] vettore){
        for (int i = 0; i < vettore.length-1; i++) {          //ottimizzazione con il -1 dato che ultimo valore sarà il primo 
            for (int x = 0; x < vettore.length-i-1; x++) {   //ad essere ordnato e non ci sarà più bisogno di considerarlo
				if(vettore[x]> vettore[x+1]){             //senza else dato che diversamente sarebbe già ordinato
					int temp = vettore[x];
					vettore [x] = vettore[x+1];
					vettore[x+1] = temp;
				}
			}
        }
		return vettore;
	}
	
	public static String[] ordinaVettore(String[] vettore){
		
        for (int i = 0; i < vettore.length-1; i++) {
            for (int x = 0; x < vettore.length-i-1; x++) {
				if(vettore[x].compareTo(vettore[x+1])>0){      //compareTo ci restituisce 1 se il primo elemento sarà più grande del secondo,
					String temp = vettore[x];                 //0 se sono uguale e -1 se il secondo è piu grande e viene utilizzato per comparare le stringhe
					vettore [x] = vettore[x+1];
					vettore[x+1] = temp;
				}
			}
        }
		return vettore;
	}
	public static String[] incrementaArrayString(String[] old){
		String[] newArray=new String[old.length+1];
		for(int i=0;i<old.length;i++){
			newArray[i]=old[i];
		}
		return newArray;
	}	
}
