package ese8.dao;

import ese8.dto.Timbratura;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DaoTimbrature implements IDao<Timbratura>{
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
    public List<Timbratura> read() throws IOException{
        List<Timbratura> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT timbrature.dipendente, timbrature.ora_timbratura, timbrature.tipo FROM timbrature INNER JOIN dipendenti ON timbrature.dipendente = dipendenti.idDipendente;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int idDipendente = rs.getInt("dipendente");
                Timestamp ora_timbratura = rs.getTimestamp("ora_timbratura");
                String tipo = rs.getString("tipo");


                result.add(new Timbratura(idDipendente, ora_timbratura, tipo));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
    @Override
    public List<Timbratura> findForName(String nome) throws IOException{
        List<Timbratura> result = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT timbrature.dipendente, timbrature.ora_timbratura, timbrature.tipo FROM timbrature INNER JOIN dipendenti ON timbrature.dipendente = dipendenti.idDipendente WHERE dipendenti.nome = ?");
            statement.setString(1,nome);

            ResultSet rst = statement.executeQuery();

            while (rst.next()) {
                int idDipendente = rst.getInt("dipendente");
                Timestamp ora_timbratura = rst.getTimestamp("ora_timbratura");
                String tipo = rst.getString("tipo");

                result.add(new Timbratura(idDipendente, ora_timbratura, tipo));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public Timbratura create(Timbratura timbratura) throws IOException{
        try (Connection conn = getConnection()) {
            PreparedStatement stm = conn.prepareStatement("insert into timbrature (dipendente, ora_timbratura, tipo) values(?, ?, ?)");

            stm.setInt(1, timbratura.getIdDipendente());
            stm.setTimestamp(2, timbratura.getTimbraturaTempo());
            stm.setString(3, timbratura.getTipo());

            int righeInserite = stm.executeUpdate();
            System.out.println("Le righe inserite sono: " + righeInserite);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timbratura;
    }

}
