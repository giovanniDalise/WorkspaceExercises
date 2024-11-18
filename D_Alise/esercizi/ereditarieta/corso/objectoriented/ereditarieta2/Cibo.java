package esercizi.ereditarieta.corso.objectoriented.ereditarieta2;

public class Cibo {
    public static final int CARNE = 1;
    public static final int VERDURA = 2;

    private int tipo;

    public Cibo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
    @Override
    public String toString() {
        if (tipo == CARNE) {
            return "carne";
        } else{
            return "verdura";
        }
    }
}
