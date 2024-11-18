package ese7.dao;

import ese7.dto.Spesa;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DaoSpese implements IDao<Spesa>{
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
    @Override
    public Spesa create(Spesa spesa)throws IOException {
        try (Connection conn = getConnection()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO spese (dataSpesa, tipo, luogo, importo, note) VALUES (?, ?, ?, ?, ?)");

            stm.setString(1, spesa.getData());
            stm.setString(2, spesa.getTipo());
            stm.setString(3, spesa.getLuogo());
            stm.setDouble(4, spesa.getImporto());
            stm.setString(5, spesa.getNote());

            int righeInserite = stm.executeUpdate();
            System.out.println("Le righe inserite sono: " + righeInserite);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spesa;
    }
    public List<Spesa> read() throws IOException {
        List<Spesa> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM spese");
            while (rs.next()) {
                String data = rs.getString("dataSpesa");
                String tipo = rs.getString("tipo");
                String luogo = rs.getString("luogo");
                double importo = rs.getDouble("importo");
                String note = rs.getString("note");

                result.add(new Spesa(data, tipo, luogo, importo, note));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
    @Override
    public List<Spesa> findForType(String searchText)throws IOException{
        List<Spesa> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM spese WHERE tipo = ?");
            statement.setString(1,searchText);

            ResultSet rst = statement.executeQuery();
            String data = null;
            String tipo = null;
            String luogo = null;
            double importo = 0.0;
            String note = null;
            while (rst.next()) {
                data = rst.getString("dataSpesa");
                tipo = rst.getString("tipo");
                luogo = rst.getString("luogo");
                importo = rst.getDouble("importo");
                note = rst.getString("note");
            }
            Spesa spesa = new Spesa(data, tipo, luogo, importo, note);
            result.add(spesa);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
    @Override
    public List<Spesa> findForLocation(String searchText)throws IOException{
        List<Spesa> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM spese WHERE luogo = ?");
            statement.setString(1,searchText);

            ResultSet rst = statement.executeQuery();
            String data = null;
            String tipo = null;
            String luogo = null;
            double importo = 0.0;
            String note = null;
            while (rst.next()) {
                data = rst.getString("dataSpesa");
                tipo = rst.getString("tipo");
                luogo = rst.getString("luogo");
                importo = rst.getDouble("importo");
                note = rst.getString("note");
            }
            Spesa spesa = new Spesa(data, tipo, luogo, importo, note);
            result.add(spesa);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}