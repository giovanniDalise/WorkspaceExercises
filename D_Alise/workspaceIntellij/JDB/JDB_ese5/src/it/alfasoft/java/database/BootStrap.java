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

        try {
            Connection conn = DriverManager.getConnection(urlDB, username, password);
            createTable(conn);
            Scanner input = new Scanner(System.in);
            int scelta = 0;

            do {
                System.out.println("Scegli un operazione:");
                System.out.println("1.Registra la spesa");
                System.out.println("2.Visualizza le spese");
                System.out.println("3.Ricerca le spese");
                System.out.println("0.Esci");

                scelta = input.nextInt();
                input.nextLine();

                switch (scelta) {
                    case 1:
                        registraSpesa(conn, input);
                        break;
                    case 2:
                        visualizzaSpese(conn);
                        break;
                    case 3:
                        ricercaSpese(conn, input);
                    case 0:
                        System.out.println("Arrivederci");
                        break;
                    default:
                        System.out.println("Scelta non valida riprova!");
                        break;
                }
            } while (scelta != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection conn)throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS spese (" +
                "idSpesa INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "data DATE NULL," +
                "tipo VARCHAR(100) NULL," +
                "luogo VARCHAR(50) NULL," +
                "importo DECIMAL NULL," +
                "note VARCHAR(255) NULL)";
        Statement stmt = conn.createStatement();
        stmt.execute(createTableQuery);
    }
    public static void registraSpesa(Connection conn, Scanner input){
        System.out.println("Inserisci la data:(YYYY-MM-DD)");
        String data = input.nextLine();
        System.out.println("Inserisci il tipo:");
        String tipo = input.nextLine();
        System.out.println("Inserisci il luogo:");
        String luogo = input.nextLine();
        System.out.println("Inserisci l'importo:");
        Double importo = input.nextDouble();
        input.nextLine();
        System.out.println("Inserisci note:");
        String note = input.nextLine();

        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO spese ( data, tipo, luogo, importo, note) VALUES (?,?,?,?,?)");

            stm.setString(1, data);
            stm.setString(2, tipo);
            stm.setString(3, luogo);
            stm.setDouble(4, importo);
            stm.setString(5, note);

            int righeInserite = stm.executeUpdate();
            System.out.println("Le righe inserite sono:" + righeInserite);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void visualizzaSpese(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT * FROM spese");
            System.out.println("Elenco spese");
            while (rst.next()) {
                int id = rst.getInt("idSpesa");
                String data = rst.getString( "data");
                String tipo = rst.getString( "tipo");
                String luogo = rst.getString("luogo");
                Double importo = rst.getDouble("importo");
                String note = rst.getString("note");

                System.out.println("Data: " + data);
                System.out.println("Tipo: " + tipo);
                System.out.println("Luogo: " + luogo);
                System.out.println("Importo: " + importo);
                System.out.println("Note: " + note);
                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void ricercaSpese(Connection conn, Scanner input){
        try {
            System.out.println("Selezionare il parametro di ricerca:");
            System.out.println("1.Tipo");
            System.out.println("2.Luogo");

            int scelta = input.nextInt();
            input.nextLine();

            String query;
            PreparedStatement statement;

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il tipo di spesa:");
                    String tipoRicerca = input.nextLine();
                    query = "SELECT * FROM spese WHERE tipo = ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, tipoRicerca);
                    break;
                case 2:
                    System.out.println("Inserisci il luogo della spesa:");
                    String luogoRicerca = input.nextLine();
                    query = "SELECT * FROM spese WHERE luogo = ?";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, luogoRicerca);
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    return;
            }
            ResultSet rst = statement.executeQuery();

            while (rst.next()) {
                int id = rst.getInt("idSpesa");
                String data = rst.getString("data");
                String tipo = rst.getString("tipo");
                String luogo = rst.getString("luogo");
                Double importo = rst.getDouble("importo");
                String note = rst.getString("note");

                System.out.println("Data: " + data);
                System.out.println("Tipo: " + tipo);
                System.out.println("Luogo: " + luogo);
                System.out.println("Importo: " + importo);
                System.out.println("Note: " + note);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}