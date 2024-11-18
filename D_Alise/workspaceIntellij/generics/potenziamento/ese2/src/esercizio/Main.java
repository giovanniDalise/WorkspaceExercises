package esercizio;

public class Main {
    public static void main(String[] args) {
        Integer[] interi = {3, 4, 7};
        Double[] doubles = {8.3, 6.4, 7.2};
        Persona persona1 = new Persona("Mario", "Rossi", 23);
        Persona persona2 = new Persona("Luca", "Verdi", 45);
        Persona persona3 = new Persona("Anna", "Monti", 19);
        Persona[] persone = {persona1, persona2, persona3} ;
        ArrayPrinter.printArray(interi);
        ArrayPrinter.printArray(doubles);
        ArrayPrinter.printArray(persone);
    }
}