package it.corso.alfasoft.esempi.Dao;

import it.corso.alfasoft.esempi.Dto.Libro;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DaoLibri implements IDao<Libro,String> {
    private static final String URL = "URL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    private Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String urlDB = properties.getProperty(URL);
        String username = properties.getProperty(USERNAME);
        String password = properties.getProperty(PASSWORD);
        return DriverManager.getConnection(urlDB, username, password);
    }
    public Libro create(Libro libro)throws IOException {
        try (Connection conn = getConnection()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO libri (libroISBN,titolo, autore, editore) VALUES (?, ?, ?, ?)");

            stm.setLong(1, libro.getId());
            stm.setString(2, libro.getTitolo());
            stm.setString(3, libro.getAutore());
            stm.setString(4, libro.getEditore());

            int righeInserite = stm.executeUpdate();
            System.out.println("Le righe inserite sono: " + righeInserite);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }
    public List<Libro> read() throws IOException {
        List<Libro> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM libri");
            while (rs.next()) {
                long id = rs.getLong("libroISBN");
                String titolo = rs.getString("titolo");
                String autore = rs.getString("autore");
                String editore = rs.getString("editore");

                result.add(new Libro(id,titolo, autore, editore));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
    public List<Libro> findByTitle(String searchText)throws IOException{
        List<Libro> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM libri WHERE titolo = ?");
            statement.setString(1,searchText);

            ResultSet rst = statement.executeQuery();
            long isbn = 0;
            String titolo = null;
            String autore = null;
            String editore = null;
            while (rst.next()) {
                isbn = rst.getLong("libroISBN");
                titolo = rst.getString("titolo");
                autore = rst.getString("autore");
                editore = rst.getString("editore");
            }
            Libro libro = new Libro(isbn, titolo, autore, editore);
            result.add(libro);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
    public void delete(String titolo) throws IOException{
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("delete from libri where titolo = ?");
            ps.setString(1, titolo);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Libro libroModificato) throws IOException{
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("update libri set titolo = ?, autore = ?, editore = ? where libroISBN = ?");

            ps.setString(1, libroModificato.getTitolo());
            ps.setString(2, libroModificato.getAutore());
            ps.setString(3, libroModificato.getEditore());
            ps.setLong(4, libroModificato.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
