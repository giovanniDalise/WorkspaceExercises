package it.alfasoft.esercizi.inisieme;

import java.io.Serializable;

public class Libro implements Serializable {
    private final String titolo;
    private final String autore;
    private final String editore;

    public Libro(String titolo, String autore, String editore) {
        this.titolo = titolo;
        this.autore=autore;
        this.editore=editore;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getEditore() {
        return editore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                '}';
    }
}
