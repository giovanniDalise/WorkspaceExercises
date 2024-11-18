package it.alfasoft.java.database;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.*;
public class Main {

    public static final String URL = "URL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    public static void main(String[] args) throws IOException {
        Properties p= new Properties();
        p.load(new FileInputStream("config.properties"));
        String urlDB =p.getProperty(URL);
        String username=p.getProperty(USERNAME);
        String password = p.getProperty(PASSWORD);
        try {
            Connection conn = DriverManager.getConnection(urlDB,username,password);
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("select titolo from corso.libri");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}