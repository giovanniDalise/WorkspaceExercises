package esercizi.arraylist;
import java.util.ArrayList;

public class EsempioArrayList {
    public static void main(String[] args) {
        // creiamo un ArrayList di numeri interi
        ArrayList<Integer> numeri = new ArrayList<Integer>();
        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        numeri.add(4);
        numeri.add(5);
        numeri.add(6);
        numeri.add(7);
        numeri.add(8);
        numeri.add(9);
        numeri.add(10);
        
        // calcoliamo la somma dei numeri pari
        int sommaPari = 0;
        for (int numero : numeri) {
            if (numero % 2 == 0) { // se il numero è pari
                sommaPari += numero; // aggiungiamo il numero alla somma dei pari
            }
        }
        
        // stampiamo la somma dei numeri pari
        System.out.println("La somma dei numeri pari è: " + sommaPari);
    }
}