package esercizio;

public abstract class Frutta {
    protected String nome;
    protected double prezzoKilo;

    public Frutta(String nome, double prezzoKilo) {
        this.nome = nome;
        this.prezzoKilo = prezzoKilo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzoKilo() {
        return prezzoKilo;
    }
    public abstract double calcolaPrezzoAlKilo();
}
