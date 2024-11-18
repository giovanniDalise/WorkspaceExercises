package it.alfasoft.java.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

public class BootStrap {
    public static final String URL = "URL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String BOOKS_FILE = "libri.txt";

    public static void main(String[] args)throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("config.properties"));
        String urlDB = p.getProperty(URL);
        String username = p.getProperty(USERNAME);
        String password = p.getProperty(PASSWORD);
        try{
            Connection conn = DriverManager.getConnection(urlDB,username,password); //Connesione stabilita con il DB
            String insertQuery = "INSERT INTO esejdb2.libri (titolo, autore) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(insertQuery);

            BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                String title = bookData[0];
                String author = bookData[1];

                statement.setString(1, title);
                statement.setString(2, author);
                statement.executeUpdate();
            }
            System.out.println("Libri inseriti.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}