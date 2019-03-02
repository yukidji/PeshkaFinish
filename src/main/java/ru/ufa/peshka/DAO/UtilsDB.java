package ru.ufa.peshka.DAO;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * получение соединения с БД
 */
public class UtilsDB {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    private static Connection connection = null;
    private static Properties property = new Properties();
    private static Logger logger = Logger.getLogger(UtilsDB.class);

    static {
         try{
             InputStream inputStream = UtilsDB.class.getClassLoader().getResourceAsStream("config.properties");
             property.load(inputStream);

             driver = property.getProperty("DRIVER");
             url = property.getProperty("URL");
             user = property.getProperty("USER");
             password = property.getProperty("PASSWORD");

         } catch (IOException e) {
             logger.error("Properties didn't loud: ", e);
         }
    }

    public Connection getConnection () throws SQLException, ClassNotFoundException {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
