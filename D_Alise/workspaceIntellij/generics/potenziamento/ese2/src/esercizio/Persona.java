package esercizio;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public int getEta() {
        return this.eta;
    }
    public String toString() {
        return "Nome: " + this.nome + ", Cognome: "+ this.cognome + ", Età: " + this.eta;
    }
}
