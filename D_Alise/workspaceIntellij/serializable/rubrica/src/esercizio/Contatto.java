package esercizio;

import java.io.Serializable;

public class Contatto implements Serializable {
    private String nome;
    private String cognome;
    private String telefono;
    private String indirizzo;

    public Contatto(String nome, String cognome, String telefono, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void stampaDati() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Telefono: " + telefono);
        System.out.println("Indirizzo: " + indirizzo);
    }
}
