package ru.ufa.peshka.DAO;

import ru.ufa.peshka.DAO.Enum.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class AbstractDao<T> implements GenericDao <T>{
    private Connection connection;
    UtilsDB conn = new UtilsDB();

    public String sqlInsert;
    public String sqlSelect;
    public String sqlUpdate;
    public String sqlDelete;

    public String id;

    public String getSQL (CRUD param){
        if (param == CRUD.INSERT) return sqlInsert;
        if (param == CRUD.SELECT) return sqlSelect;
        if (param == CRUD.UPDATE) return sqlUpdate;
        if (param == CRUD.DELETE) return sqlDelete;
        else {
            return null;
        }
    }

    void fillStatement (T t, CRUD param) throws SQLException, ClassNotFoundException {
            this.connection = conn.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSQL(param))){

            if (param == CRUD.INSERT){
                mappingInsert(preparedStatement, t);
                preparedStatement.execute();
            }
            if (param == CRUD.UPDATE){
                mappingUpdate(preparedStatement, t);
                preparedStatement.executeUpdate();
            }
            if (param == CRUD.DELETE){
                mappingDelete(preparedStatement, t);
                preparedStatement.executeUpdate();
            }

            if (param == CRUD.SELECT){
                preparedStatement.setString(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    mappingSelect(preparedStatement, t, resultSet, id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(T t) throws SQLException, ClassNotFoundException {
        fillStatement(t, CRUD.INSERT);
    }

    @Override
    public void update(T t) throws SQLException, ClassNotFoundException {
        fillStatement(t, CRUD.UPDATE);
    }

    @Override
    public void delete(T t) throws SQLException, ClassNotFoundException {
        fillStatement(t, CRUD.DELETE);
    }

    @Override
    public T readById(T t, String id) throws SQLException, ClassNotFoundException {
        this.id = id;
        fillStatement(t, CRUD.SELECT);
        return t;
    }

    public abstract void mappingInsert(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingSelect(PreparedStatement preparedStatement, T t, ResultSet resultSet, String id) throws SQLException;
    public abstract void mappingUpdate(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingDelete(PreparedStatement preparedStatement, T t) throws SQLException;
}
