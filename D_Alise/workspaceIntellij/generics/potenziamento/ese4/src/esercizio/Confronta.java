package esercizio;

public class Confronta {
    public <T extends Comparable<T>> T max(T value1, T value2) {//stiamo dicendo che il metodo di tipo genenerico T che estende il comparable generico T tornera un valore generico T (la T vicino al nome del metodo)
        if (value1.compareTo(value2) > 0) {
            return value1;
        } else if(value1.compareTo(value2) < 0) {
            return value2;
        }else{
            System.out.println("Le due persone hanno la stessa età");
            return null;
        }
    }
}
// Implementazione della logica di confronto
// Ritorna un valore negativo se l'oggetto corrente è "minore" di other
// Ritorna zero se l'oggetto corrente è "uguale" a other
// Ritorna un valore positivo se l'oggetto corrente è "maggiore" di