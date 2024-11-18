package it.alfasoft.esercizi.inisieme;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static final String DATI_BIBLIOTECA_SER = "datiBiblioteca.ser";
    private List<Libro> libri;

    public Biblioteca() {
        this.libri=new ArrayList<Libro>();
    }
    /*
    Metodo che carica il file serializzato nella lista dei libri
     */
    public void caricaFile() throws DeserializationException {//array che verrà usato per i libri letti da file
        List<Libro> libriCaricati = new ArrayList<Libro>();
        try(FileInputStream fileInput = new FileInputStream(DATI_BIBLIOTECA_SER)){
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);
            libriCaricati = (List<Libro>) inputStream.readObject();//casting spiegato in info
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DeserializationException("Attenzione stai cercando di deserializzare un oggetto con classi non previste.");
        }
        this.libri = libriCaricati;
    }

    public void salvaFile() throws SalvataggioException {
        try(FileOutputStream fileOutput = new FileOutputStream(DATI_BIBLIOTECA_SER)){
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(this.libri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new SalvataggioException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SalvataggioException();
        }
    }
    public void aggiungiLibro(Libro libro){
        this.libri.add(libro);
    }
    public void cancellaLibro(Libro libro){
        this.libri.remove(libro);
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public static void main(String[] args) throws SalvataggioException, DeserializationException {
        Biblioteca biblioteca = caricaBiblioteca();
        if(biblioteca.getLibri().size()==0){
            initBiblioteca(biblioteca);
        }
        stampaLibri(biblioteca.getLibri());
        biblioteca.cancellaLibro(biblioteca.getLibri().get(0));
        stampaLibri(biblioteca.getLibri());
        biblioteca.salvaFile();
    }

    private static void initBiblioteca(Biblioteca biblioteca) {
        biblioteca.aggiungiLibro(creaLibro("titolo1","autore1","editore1"));
        biblioteca.aggiungiLibro(creaLibro("titolo2","autore2","editore2"));
        biblioteca.aggiungiLibro(creaLibro("titolo3","autore3","editore3"));
    }

    private static Biblioteca caricaBiblioteca() throws DeserializationException {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.caricaFile();
        return biblioteca;
    }

    private static void stampaLibri(List<Libro> libri) {
        System.out.println("-------------------------");
        for(Libro libro : libri){
            System.out.println(libro);
        }
    }

    private static Libro creaLibro(String titolo, String autore, String editore) {
        Libro result = new Libro(titolo,autore,editore);
        return result;
    }
}
