package ru.ufa.peshka.entity;

import java.sql.*;

public class Main {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "mypeshka?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "612643032";

    public static void main (String[] args) throws SQLException {

        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
            if (connection != null){
                System.out.println("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        statement = connection.createStatement();
        statement.execute("insert into chip (statys) value ('free')");
        resultSet = statement.executeQuery("select * from chip");
        while (resultSet.next()){
            System.out.println(resultSet.getString("statys"));
            System.out.println(" ");
        }
        connection.close();
    }
}
