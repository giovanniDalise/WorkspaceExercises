package esercizi.array;
import java.util.Date;
import java.util.Random;

public class BoubleSort {
    public static void main(String[] args) {
    
        Date inizio = new Date(); // Inizio del conteggio del tempo

        int [] array = new int[10000];

        Random Random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = Random.nextInt(10000) + 1;
        }

        for( int i=0; i< array.length-1;i++){
            for( int a=0; a< array.length-i-1;a++){//ottimizzazione dato che l'ultima cifra nel ciclo è alla fine quindi già ordinata 
                if(array[a]>array[a+1]){
                    int tmp = array[a];
                    array[a] = array[a+1];
                    array[a+1]=tmp;
                }    
            }
        }
        Date fine = new Date(); // Fine del conteggio del tempo
        long tempoTrascorso = fine.getTime() - inizio.getTime(); // Tempo trascorso in millisecondi
        System.out.println("Tempo di esecuzione: " + tempoTrascorso + " ms");

        ToolsVettore.stampaVettore(array,"BOUBLE SORT:");
    }
}
