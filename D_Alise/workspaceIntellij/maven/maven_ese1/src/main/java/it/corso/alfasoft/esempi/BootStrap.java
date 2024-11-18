package it.corso.alfasoft.esempi;

import it.corso.alfasoft.esempi.Dao.DaoLibri;
import it.corso.alfasoft.esempi.Dao.IDao;
import it.corso.alfasoft.esempi.Dto.Libro;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BootStrap {
    private static IDao<Libro, String> dao = new DaoLibri();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int scelta = 0;

        do {
            System.out.println("Scegli un operazione:");
            System.out.println("1.Inserisci il libro");
            System.out.println("2.Visualizza i libri");
            System.out.println("3.Ricerca i libri");
            System.out.println("4.Cancella i libri");
            System.out.println("5.Modifica i libri");

            System.out.println("0.Esci");

            scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    inserisciLibro(input);
                    break;
                case 2:
                    visualizzaLibri();
                    break;
                case 3:
                    ricercaLibri(input);
                    break;
                case 4:
                    cancellaLibro(input);
                    break;
                case 5:
                    modificaLibro(input);
                case 0:
                    System.out.println("Arrivederci");
                    break;
                default:
                    System.out.println("Scelta non valida riprova!");
                    break;
            }
        } while (scelta != 0);
    }

    public static void inserisciLibro(Scanner input) throws IOException {
        long idLibro = new Date().getTime();
        System.out.println("Inserisci il titolo:");
        String titolo = input.nextLine();
        System.out.println("Inserisci l'autore:");
        String autore = input.nextLine();
        System.out.println("Inserisci l'editore:");
        String editore = input.nextLine();

        Libro nuovoLibro = new Libro(idLibro,titolo, autore, editore);
        Libro libroInserito = dao.create(nuovoLibro);
        System.out.println("Libro Inserito: " + libroInserito.toString());
    }

    public static void visualizzaLibri() throws IOException{
        IDao<Libro,String> dao = new DaoLibri();
        List<Libro> elencoLibri = dao.read();
        for(Libro libro: elencoLibri){
            System.out.println(libro.toString());
        }
    }
    public static void ricercaLibri(Scanner input) throws IOException{
        IDao<Libro,String> dao = new DaoLibri();
        System.out.println("Inserisci i titolo dei libri da cercare:");
        String titolo = input.nextLine();
        List<Libro> elencoLibri = dao.findByTitle(titolo);
        if (elencoLibri.isEmpty()) {
            System.out.println("Nessun libro trovato.");
        } else {
            for (Libro libro : elencoLibri) {
                System.out.println(libro.toString());
            }
        }
    }
    public static void cancellaLibro(Scanner input) throws IOException{
        System.out.println("Inserisci il titolo del libro da eliminare:");
        String titolo = input.nextLine();
        dao.delete(titolo);
    }
    public static void modificaLibro(Scanner input) throws IOException{
        System.out.println("Inserisci l'ID del libro da modificare:");
        long libriID = input.nextLong();
        input.nextLine();
        System.out.println("Inserisci il titolo del libro:");
        String titolo = input.nextLine();
        System.out.println("Inserisci l'autore del libro:");
        String autore = input.nextLine();
        System.out.println("Inserisci l'editore del libro:");
        String editore = input.nextLine();
        dao.update(new Libro(libriID, titolo, autore, editore));
    }

}

