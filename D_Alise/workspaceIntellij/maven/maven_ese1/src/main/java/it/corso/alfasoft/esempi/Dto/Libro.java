package it.corso.alfasoft.esempi.Dto;

public class Libro {
    private long id;
    private String titolo;
    private String autore;
    private String editore;


    public Libro(long id,String titolo, String autore, String editore) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
    }

    public long getId() {
        return id;
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
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                '}';
    }
}
