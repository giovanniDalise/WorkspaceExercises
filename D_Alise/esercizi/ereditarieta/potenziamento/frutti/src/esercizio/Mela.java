package esercizio;

public class Mela extends Frutta {
    private String tipo;
    private double peso;

    public Mela(String nome, double prezzoKilo, String tipo, double peso) {
        super(nome, prezzoKilo);
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }
    public double calcolaPrezzoAlKilo(){
        double prezzo= this.peso*this.prezzoKilo;
        return prezzo;

    }
}
