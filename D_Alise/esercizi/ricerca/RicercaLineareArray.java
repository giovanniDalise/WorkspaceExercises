package esercizi.ricerca;
import java.util.Scanner;
import java.util.Random;
public class RicercaLineareArray {	
	public static void main (String[] input){
		Random random =new Random();
		Scanner tastiera = new Scanner(System.in);
		int[] array = new int[10];
		for (int i=0; i<array.length; i++){
			array[i] = random.nextInt(100)+1;
		}
		System.out.println("L'array e' composto da: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println("Scegli un elemento da cercare tra quelli indicati : ");
		int elementoDesiderato = tastiera.nextInt();
		int indiceElemento = ricercaLineare (array, elementoDesiderato);
		
		if (indiceElemento == -1){
			System.out.println("Elemento non trovato");
		} else { 
			System.out.println("Elemento trovato all'indice " + indiceElemento);
		}
	}	
	/*
	public static int ricercaLineare(int[] array, int elementoDesiderato){
		for (int i=0; i<array.length; i++){
			if (array[i] == elementoDesiderato){
				return i;
			}
		}
		return -1;
	}*/
	public static int ricercaLineare (int[] array, int elementoDesiderato){
		int result =-1;
		int i=0;
		while (elementoDesiderato!=array[i] && i<array.length-1) {
			i++;
		} 
		if(elementoDesiderato==array[i]){
			result=i;
		}
		return result;
	}
	
}
