package esercizio;
public class ArrayPrinter<T> {
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element.toString());
        }
    }
}
/* in realtà in questo esempio potevo anche non fare il metodo generico dato che ho già la classe
generica che mi accetta un tipo generico, l'ho fatto solo per seguire la traccia ma se la firma del metodo
fosse stata public void printArray(T[] array) il programma avrebbe funzionato ugualmente.
Diciamo che quindi che si definisce un metodo generico in una classe senza definire anche la stessa classe generica
quando non bisogna richiamare il metodo in un contesto statico, diversamente invece per utilizzarlo
in un contesto statico o si renderà il metodo statico oltre che generico oppure se non si vuole che il metodo
sia statico si dovrà utilizzare un istanza della classe che lo implementa non rendendo più necessaria la sua firma
 generica dato che il tipo generico sarà passato dalla classe stessa.
 */