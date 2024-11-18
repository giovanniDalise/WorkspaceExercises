package esercizio;

public class Scambio<T> {
    private T variabile1;
    private T variabile2;

    public Scambio(T variabile1, T variabile2) {
        this.variabile1 = variabile1;
        this.variabile2 = variabile2;
    }

    public void inverti() {
        T temp = variabile1;
        variabile1 = variabile2;
        variabile2 = temp;
    }

    @Override
    public String toString() {
        return "variabile1 = " + variabile1 + ", variabile2 = " + variabile2;
    }
}