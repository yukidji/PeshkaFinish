package ru.ufa.peshka.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public abstract class AbstractDao<T> implements GenericDao <T>{
    private Connection connection;
    String param = "null";

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    void fillStatement (T t, String id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSQL(param));
        ResultSet resultSet = preparedStatement.executeQuery()){
            if (param.equals("INSERT")){
                mappingInsert(preparedStatement, t);
            }
            if (param.equals("SELECT")){
                preparedStatement.setString(1, id);
                //ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                mappingSelect(preparedStatement, t, resultSet);

            }

            /**
            if (param.equals("UPDATE") || param.equals("DELETE"))preparedStatement.executeUpdate();
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(T t) throws SQLException, ParseException {
        param = "INSERT";
        fillStatement(t, null);
    }

    @Override
    public T readById(String id) throws SQLException {
        T t = (T) new Object();
        param = "SELECT";
        fillStatement(t, id);
        return t;
    }

    @Override
    public void update(T t) throws SQLException {
        param = "UPDATE";
        fillStatement(t);
    }

    @Override
    public void delete(T t) throws SQLException {
        param = "DELETE";
        fillStatement(t);
    }

    //продумать что будет возвращать и что будет возвращать
    public abstract void mappingInsert(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingSelect (PreparedStatement preparedStatement, T t, ResultSet resultSet) throws SQLException;
    public abstract T mappingUpdate(PreparedStatement preparedStatement, T t);
    public abstract T mappingDelete(PreparedStatement preparedStatement, T t);

    public abstract String getSQL (String param);


}
