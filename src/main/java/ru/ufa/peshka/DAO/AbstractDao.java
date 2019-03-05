package ru.ufa.peshka.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public abstract class AbstractDao<T> implements GenericDao <T>{
    private Connection connection;
    public String sqlInsert;
    public String sqlSelect;
    public String sqlUpdate;
    public String sqlDelete;

    String param = "null";

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public String getSQL (String param){
        if (param.equals("INSERT")) return sqlInsert;
        if (param.equals("SELECT")) return sqlSelect;
        if (param.equals("UPDATE")) return sqlUpdate;
        if (param.equals("DELETE")) return sqlDelete;
        else {
            return null;
        }
    }

    void fillStatement (T t, String id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSQL(param));
        ResultSet resultSet = preparedStatement.executeQuery()){
            if (param.equals("INSERT")){
                mappingInsert(preparedStatement, t);
                preparedStatement.execute();
            }
            if (param.equals("SELECT")){
                preparedStatement.setString(1, id);
                //ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                mappingSelect(preparedStatement, t, resultSet, id);
            }
            if (param.equals("UPDATE")){
                mappingUpdate(preparedStatement, t);
                preparedStatement.executeUpdate();
            }
            if (param.equals("DELETE")){
                mappingDelete(preparedStatement, t);
                preparedStatement.executeUpdate();
            }
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
        fillStatement(t, null);
    }

    @Override
    public void delete(T t) throws SQLException {
        param = "DELETE";
        fillStatement(t, null);
    }

    public abstract void mappingInsert(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingSelect (PreparedStatement preparedStatement, T t, ResultSet resultSet, String id) throws SQLException;
    public abstract void mappingUpdate(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingDelete(PreparedStatement preparedStatement, T t) throws SQLException;
}
