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
            Scanner input = new Scanner(System.in);
            int scelta = 0;

            do {
                System.out.println("Scegli un operazione:");
                System.out.println("1.Registra Timbratura");
                System.out.println("2.Visualizza Timbrature");
                System.out.println("3.Visualizza Timbrature per nome");
                System.out.println("4.Uscita");
                scelta = input.nextInt();
                input.nextLine();

                switch(scelta){
                    case 1:
                        registraTimbratura(conn,input);
                        break;
                    case 2:
                        visualizzaTimbrature(conn);
                        break;
                    case 3:
                        visualizzaTimbraturePerNome(conn,input);
                        break;
                    case 0:
                        System.out.println("Arrivederci");
                        break;
                    default:
                        break;
                }
            }while(scelta!=0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void registraTimbratura(Connection conn, Scanner input) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("insert into timbrature (dipendente, ora_timbratura, tipo) values(?, ?, ?)");

        System.out.println("Inserisci il dipendente al quale annotare la timbratura:");
        System.out.println("1.Giovanni D'Alise");
        System.out.println("2.Alessio Di Stefano");
        System.out.println("3.Daniel Guidolin");
        int nuovoIdDipendente = input.nextInt();
        input.nextLine();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.println("Inserisci il tipo di timbratura (entrata/uscita):");
        String nuovoTipo = input.nextLine();

        ps.setInt(1, nuovoIdDipendente);
        ps.setTimestamp(2, timestamp);
        ps.setString(3, nuovoTipo);
        ps.executeUpdate();
    }
    public static void visualizzaTimbrature(Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("select dipendenti.nome, timbrature.ora_timbratura, timbrature.tipo from timbrature inner join dipendenti on timbrature.dipendente = dipendenti.idDipendente;");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
        }
    }
    public static void visualizzaTimbraturePerNome(Connection conn,Scanner input) throws IOException, SQLException{
        PreparedStatement ps = conn.prepareStatement("select dipendenti.nome, timbrature.ora_timbratura, timbrature.tipo from timbrature inner join dipendenti on timbrature.dipendente = dipendenti.idDipendente where nome = ?;");

        System.out.println("Inserire il nome del dipendente di cui vuoi visualizzare le timbrature:");
        String nuovoNome = input.nextLine();
        ps.setString(1, nuovoNome);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1) + " | " + rs.getString(2)+ " | " + rs.getString(3));
        }
    }
}
