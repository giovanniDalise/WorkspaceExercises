package it.alfasoft.java.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class BootStrap {
    public static final String URL = "URL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("config.properties"));
        String urlDB = p.getProperty(URL);
        String username = p.getProperty(USERNAME);
        String password = p.getProperty(PASSWORD);

        try (Connection conn = DriverManager.getConnection(urlDB, username, password)) {
            createTable(conn);
            Scanner input = new Scanner(System.in);
            int scelta = 0;

            do {
                System.out.println("Scegli un'operazione:");
                System.out.println("1. Registrazione evento");
                System.out.println("2. Visualizzazione eventi");
                System.out.println("3. Ricerca eventi per zona e/o giorno e/o orario");
                System.out.println("0. Esci");

                scelta = input.nextInt();
                input.nextLine();

                switch (scelta) {
                    case 1:
                        registrazioneEvento(conn, input);
                        break;
                    case 2:
                        visualizzazioneEventi(conn);
                        break;
                    case 3:
                        ricercaEventi(conn, input);
                        break;
                    case 0:
                        System.out.println("Arrivederci!");
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova."); // non essendoci altri casi possiamo non mettere il break perchè se non avremo eseguito il caso successivo
                }
            } while (scelta != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createTable(Connection conn) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS eventi (" +
                "idEvento INT PRIMARY KEY AUTO_INCREMENT," +
                "giorno DATE," +
                "ora INT," +
                "descrizione VARCHAR(255)," +
                "zona VARCHAR(255))";
        Statement stmt = conn.createStatement();
        stmt.execute(createTableQuery);
        //excute puo essere utilizzato per qualsiasi query in questo caso una ddl e restituisce unun valore
        // booleano che indica se il risultato della query è un risultato di un insieme di risultati (true) o non ha un risultato (false).
        //mentre executeUpdate utilizzate più per le dml restituiscono un int corrispondente alle righe interessate nella query
        //infine executeQuery viene utilizzato per le SELECT (DQl) e restituisce l'oggetto(interfaccia) Resultset
    }

    public static void registrazioneEvento(Connection conn, Scanner input) throws SQLException {
        System.out.println("Inserisci la data (formato: YYYY-MM-DD):");
        String data = input.nextLine();
        System.out.println("Inserisci l'ora (formato: HHMM):");
        int ora = input.nextInt();
        input.nextLine();
        System.out.println("Inserisci la descrizione:");
        String descrizione = input.nextLine();
        System.out.println("Inserisci la zona:");
        String zona = input.nextLine();

        String insertQuery = "INSERT INTO eventi (giorno, ora, descrizione, zona) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(insertQuery);
        stmt.setString(1, data);
        stmt.setInt(2, ora);
        stmt.setString(3, descrizione);
        stmt.setString(4, zona);
        stmt.executeUpdate();

        System.out.println("Evento registrato con successo!");
    }

    public static void visualizzazioneEventi(Connection conn) throws SQLException {
        String selectQuery = "SELECT * FROM eventi";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);

        System.out.println("Elenco eventi:");
        while (rs.next()) {
            int idEvento = rs.getInt("idEvento"); //utiliziamo il nome delle colonne (columnLabel) anzicche l'indice di queste visto che abbiamo usato * e il columnLabel rende il codice più leggibile
            String giorno = rs.getString("giorno");
            int ora = rs.getInt("ora");
            String descrizione = rs.getString("descrizione");
            String zona = rs.getString("zona");

            System.out.println("ID: " + idEvento);
            System.out.println("Data: " + giorno);
            System.out.println("Ora: " + ora);
            System.out.println("Descrizione: " + descrizione);
            System.out.println("Zona: " + zona);
            System.out.println();
        }
    }

    public static void ricercaEventi(Connection conn, Scanner input) throws SQLException {
        System.out.println("Ricerca eventi per:");
        System.out.println("1. Zona");
        System.out.println("2. Giorno");
        System.out.println("3. Orario");
        System.out.println("4. Zona e Giorno");
        System.out.println("5. Zona e Orario");
        System.out.println("6. Giorno e Orario");
        System.out.println("7. Zona, Giorno e Orario");

        int scelta = input.nextInt();
        input.nextLine();

        String selectQuery = "SELECT * FROM eventi WHERE"; //inizializzo frammento di query
        String zona = null;
        String giorno = null;
        int ora = 0;

        switch (scelta) {
            case 1:
                System.out.println("Inserisci la zona:"); //completo la query inizializzata(dopo il where) con zona = 'zona che inserisco'
                zona = input.nextLine();
                selectQuery += " zona = '" + zona + "'";
                break;
            case 2:
                System.out.println("Inserisci il giorno (formato: YYYY-MM-DD):");
                giorno = input.nextLine();
                selectQuery += " giorno = '" + giorno + "'";
                break;
            case 3:
                System.out.println("Inserisci l'ora (formato: HHMM):");
                ora = input.nextInt();
                input.nextLine(); // Consuma il newline dopo nextInt()
                selectQuery += " ora = " + ora;
                break;
            case 4:
                System.out.println("Inserisci la zona:");
                zona = input.nextLine();
                System.out.println("Inserisci il giorno (formato: YYYY-MM-DD):");
                giorno = input.nextLine();
                selectQuery += " zona = '" + zona + "' AND giorno = '" + giorno + "'"; //operatoroe logico AND
                break;
            case 5:
                System.out.println("Inserisci la zona:");
                zona = input.nextLine();
                System.out.println("Inserisci l'ora (formato: HHMM):");
                ora = input.nextInt();
                input.nextLine(); // Consuma il newline dopo nextInt()
                selectQuery += " zona = '" + zona + "' AND ora = " + ora;
                break;
            case 6:
                System.out.println("Inserisci il giorno (formato: YYYY-MM-DD):");
                giorno = input.nextLine();
                System.out.println("Inserisci l'ora (formato: HHMM):");
                ora = input.nextInt();
                input.nextLine(); // Consuma il newline dopo nextInt()
                selectQuery += " giorno = '" + giorno + "' AND ora = " + ora;
                break;
            case 7:
                System.out.println("Inserisci la zona:");
                zona = input.nextLine();
                System.out.println("Inserisci il giorno (formato: YYYY-MM-DD):");
                giorno = input.nextLine();
                System.out.println("Inserisci l'ora (formato: HHMM):");
                ora = input.nextInt();
                input.nextLine(); // Consuma il newline dopo nextInt()
                selectQuery += " zona = '" + zona + "' AND giorno = '" + giorno + "' AND ora = " + ora;
                break;
            default:
                System.out.println("Scelta non valida. Ritorno al menu principale.");
                return; // ricorda che il return esce dal metodo
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);

        System.out.println("Risultati della ricerca:");
        while (rs.next()) {
            int idEvento = rs.getInt("idEvento");
            giorno = rs.getString("giorno");
            ora = rs.getInt("ora");
            String descrizione = rs.getString("descrizione");
            zona = rs.getString("zona");

            System.out.println("ID: " + idEvento);
            System.out.println("Data: " + giorno);
            System.out.println("Ora: " + ora);
            System.out.println("Descrizione: " + descrizione);
            System.out.println("Zona: " + zona);
            System.out.println();
        }
    }
}