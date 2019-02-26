package ru.ufa.peshka.DAO;

import java.sql.*;

/**
 * получение соединения с БД
 */
public class ConnectionDB {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "mypeshka?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "612643032";

    public Connection getConnection () throws SQLException, ClassNotFoundException {
            Class.forName(DRIVER);
            //System.out.println("вход в ConnectionDB в getConnection");
            return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
    }

}
