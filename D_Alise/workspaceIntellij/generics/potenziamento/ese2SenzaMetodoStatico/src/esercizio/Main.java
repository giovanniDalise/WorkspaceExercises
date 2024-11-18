package esercizio;
//spiegazione di questa versione nell'altro esercizio
public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};

        ArrayPrinter<Integer> intPrinter = new ArrayPrinter<>();
        intPrinter.printArray(intArray);

        ArrayPrinter<String> stringPrinter = new ArrayPrinter<>();
        stringPrinter.printArray(stringArray);
    }
}