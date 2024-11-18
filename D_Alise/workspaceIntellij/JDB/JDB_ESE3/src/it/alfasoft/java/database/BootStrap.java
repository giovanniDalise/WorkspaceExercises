package it.alfasoft.java.database;

import java.util.Scanner;
import java.io.*;
import java.util.Properties;
import java.sql.*;
public class BootStrap {

    public static final String URL = "URL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String BOOKS_FILE = "libri.txt";
    public static final String BOOKS_FILE2 = "libriImportati.txt";

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        Properties p = new Properties();
        p.load(new FileInputStream("config.properties"));
        String urlDB = p.getProperty(URL);
        String username = p.getProperty(USERNAME);
        String password = p.getProperty(PASSWORD);
        int numero = 0;
        do{
            System.out.println(" Scegli una delle seguenti operazioni:");
            System.out.println("1. Carica libri da file su tabella");
            System.out.println("2. Esporta libri da tabella su file");
            System.out.println("3. Inserisci libro");
            System.out.println("4. Modifica libro");
            System.out.println("5. Cancella libro");
            System.out.println("6. Recupera tutti i libri");
            System.out.println("7. Ricerca un libro specifico");
            System.out.println("0. Esci");
            numero = input.nextInt();
            switch (numero) {
                case 1:
                    caricaLibriSuTabella(urlDB, username, password);
                    break;
                case 2:
                    esportaLibriSuFile(urlDB, username, password);
                    break;
                case 3:
                    inserireLibri(urlDB, username, password);
                    break;
                case 4:
                    modificareLibro(urlDB, username, password);
                    break;
                case 5:
                    cancellaLibro(urlDB,username,password);
                    break;
                case 6:
                    recuperaLibri(urlDB,username,password);
                    break;
                case 7:
                    ricercaLibro(urlDB,username,password);
                case 0:
                    break;
                default:
                    System.out.println("Inserire uno dei numeri elencati:");
                    break;
            }
        }while(numero!=0);
    }
    public static void caricaLibriSuTabella(String url, String username, String password) throws IOException { //DML
        try {
            Connection conn = DriverManager.getConnection(url, username, password); //Connessione stabilita con il DB
            String insertQuery = "INSERT INTO esejdb3.libri (libroISBN, titolo, autore, editore) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(insertQuery);

            BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                long libroISBN = Long.parseLong(bookData[0]);
                String title = bookData[1];
                String author = bookData[2];
                String editor = bookData[3];

                statement.setLong(1, libroISBN);
                statement.setString(2, title);
                statement.setString(3, author);
                statement.setString(4, editor);
                statement.executeUpdate();
            }
            System.out.println("Libri inseriti.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void esportaLibriSuFile(String url, String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT libroISBN, titolo, autore, editore FROM esejdb3.libri");

            try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKS_FILE2))) {
                while (rs.next()) {
                    long ISBNlibro = rs.getLong("libroISBN");
                    String titolo = rs.getString("titolo");
                    String autore = rs.getString("autore");
                    String editore = rs.getString("editore");
                    writer.println(ISBNlibro + ", " + titolo + ", " + autore + ", " + editore);
                }
            }

            System.out.println("Libri esportati correttamente.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void inserireLibri(String url, String username, String password) { //DML
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String insertQuery = "INSERT INTO esejdb3.libri (libroISBN, titolo, autore, editore) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(insertQuery);

            statement.setLong(1, 12345678913L);
            statement.setString(2, "Ancora un Libro");
            statement.setString(3, "Luca Sorsi");
            statement.setString(4, "La Sorsi");
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Dati gia inseriti" + e.getMessage()); // gestisco l'exception per non bloccare il programma quando trova una primary keys uguale in fase di inserimento
        }
    }
    public static void modificareLibro (String url, String username, String password) { //DML
        try (Connection conn = DriverManager.getConnection(url,username, password)) {
            String updateQuery = "UPDATE esejdb3.libri SET titolo = ?,autore = ? WHERE libroISBN = ?";
            PreparedStatement statement = conn.prepareStatement(updateQuery);

            statement.setString(1, "Libro definitivo");
            statement.setString(2, "Nuovo Autore");
            statement.setLong(3, 12345678913L);

            int righeModificate = statement.executeUpdate();
            System.out.println("Numero di righe modificate: " + righeModificate);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void cancellaLibro (String url, String username, String password) { //DML
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String deleteQuiery = "DELETE FROM  WHERE libroISBN = ?";
            PreparedStatement statement = conn.prepareStatement(deleteQuiery);

            statement.setLong(1,12345678913L);
            int righeCancellate = statement.executeUpdate();
            System.out.println("Numero di righe cancellate: " + righeCancellate);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void recuperaLibri (String url, String username, String password) { //DQL
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM libri");
            while (rs.next()) {
                long libroISBN = rs.getLong("libroISBN");
                String titolo = rs.getString("titolo");
                String autore = rs.getString("autore");
                String editore = rs.getString("editore");

                System.out.println("ISBN: " + libroISBN);
                System.out.println("Titolo: " + titolo);
                System.out.println("Autore: " + autore);
                System.out.println("Editore: " + editore);
                System.out.println("-----------------------");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void ricercaLibro(String url, String username, String password) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Scanner input = new Scanner(System.in);
            System.out.println("Come vuoi cercare il libro?");
            System.out.println("1. Per ISBN");
            System.out.println("2. Per Titolo");
            System.out.println("3. Per Autore");
            System.out.println("4. Per Editore");
            int scelta = input.nextInt();
            input.nextLine();

            String query;
            PreparedStatement statement;

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci l'ISBN del libro:");
                    String isbn = input.nextLine();
                    query = "SELECT * FROM libri WHERE libroISBN = ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, isbn);
                    break;
                case 2:
                    System.out.println("Inserisci il titolo parziale del libro:");
                    String titolo = input.nextLine();
                    query = "SELECT * FROM libri WHERE titolo LIKE ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, "%" + titolo + "%"); //wildcard
                    break;
                case 3:
                    System.out.println("Inserisci il nome parziale dell'autore:");
                    String autore = input.nextLine();
                    query = "SELECT * FROM libri WHERE autore LIKE ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, "%" + autore + "%");
                    break;
                case 4:
                    System.out.println("Inserisci il nome parziale dell'editore:");
                    String editore = input.nextLine();
                    query = "SELECT * FROM libri WHERE editore LIKE ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, "%" + editore + "%");
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    return; // Termina il metodo in caso di scelta non valida
            }

            ResultSet rs = statement.executeQuery(); // la query già è stata specificata sopra per i singoli casi c'è bisogno di inserirla tra le parentesi
            while (rs.next()) {
                String isbn = rs.getString("libroISBN"); //non abbiamo il coloumnindex perchè lo richiamamo già sopra come parameterindex per ogni tipo di ricerca quando scriviamo statement.setString(1.
                String titolo = rs.getString("titolo");
                String autore = rs.getString("autore");
                String editore = rs.getString("editore");
                System.out.println("ISBN: " + isbn);
                System.out.println("Titolo: " + titolo);
                System.out.println("Autore: " + autore);
                System.out.println("Editore: " + editore);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

