package ru.ufa.peshka.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * получение соединения с БД
 */
public class ConnectionDB {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    private static Properties property = new Properties();

    static {
        FileInputStream file;
         try{
             file = new FileInputStream ("src/main/resources/config.properties");
             property.load(file);

             driver = property.getProperty("DRIVER");
             url = property.getProperty("URL");
             user = property.getProperty("USER");
             password = property.getProperty("PASSWORD");

         } catch (IOException e) {
             e.printStackTrace();
         }

    }

    public Connection getConnection () throws SQLException, ClassNotFoundException {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
    }

}
