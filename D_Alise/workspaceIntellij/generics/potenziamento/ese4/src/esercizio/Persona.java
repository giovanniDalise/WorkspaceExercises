package esercizio;

public class Persona implements Comparable<Persona>  {
    private String nome;
    private  String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                '}';
    }
    @Override
    public int compareTo(Persona other) {
        // Implementa la logica di confronto basata sull'età
        return Integer.compare(this.eta, other.eta);
    }
    //devo per forza fare l'override del metodo dato che il mio oggetto Persona non implementa il metodo compareTo
    // e dovevo specificare la logica di confronto(per età).Tramite compare che accetta 2 parametri.
}
