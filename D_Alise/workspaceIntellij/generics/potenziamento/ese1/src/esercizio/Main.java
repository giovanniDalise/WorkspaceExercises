package esercizio;

public class Main {
    public static void main(String[] args) {
        // Esempio di utilizzo della classe Scambio
        Integer num1 = 10;
        Integer num2 = 20;

        Scambio<Integer> scambio = new Scambio<>(num1, num2);
        System.out.println(scambio.toString());

        scambio.inverti();
        System.out.println(scambio.toString());
    }
}
