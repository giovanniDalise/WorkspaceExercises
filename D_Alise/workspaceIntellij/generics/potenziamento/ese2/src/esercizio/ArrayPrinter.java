package esercizio;

public class ArrayPrinter{
 /*non c'è bisogno di fare ArrayPrinter come una classe generica
 semplicemente basta al suo interno un metodo generico ma attenzione l'ho fatto statico per
 richiamarlo nel main senza problemi se non fosse stato cosi avrei dovuto
 creare un istanza di arrayprinter nel main in modo da richiamare il metodo printArray
 e a quel punto la mia classe ArrayPrinter sarebbe dovuta diventare generica
 (per permettere l'utilizzo di tipi generici sia per la classe ArrayPrinter che per il metodo printArray).
  */

    public static <T> void printArray(T[] array){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i].toString());
        }
    }
}
