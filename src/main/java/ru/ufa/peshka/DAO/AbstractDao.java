package ru.ufa.peshka.DAO;

import org.apache.log4j.Logger;
import ru.ufa.peshka.DAO.Enum.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public abstract class AbstractDao<T> implements GenericDao <T>{
    private Connection connection;
    UtilsDB conn = new UtilsDB();

    public String sqlInsert;
    public String sqlSelect;
    public String sqlUpdate;
    public String sqlDelete;
    public String sqlSelectAll;

    public String id;
    public Set<T> sets;

    private static Logger logger = Logger.getLogger(AbstractDao.class.getName());

    public String getSQL (CRUD param){
        if (param == CRUD.INSERT) return sqlInsert;
        if (param == CRUD.SELECT) return sqlSelect;
        if (param == CRUD.UPDATE) return sqlUpdate;
        if (param == CRUD.DELETE) return sqlDelete;
        if (param == CRUD.SELECT_ALL) return sqlSelectAll;
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
                    mappingSelect(t, resultSet);
                }
            }
            if (param == CRUD.SELECT_ALL){
                try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(getSQL(param))){
                    mappingSelectAll(t, sets, resultSet);
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

    @Override
    public Set<T> getAll(Set<T> sets, T t) throws SQLException, ClassNotFoundException {
        this.sets = sets;
        fillStatement(t, CRUD.SELECT_ALL);
        return sets;
    }

    public abstract void mappingInsert(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingUpdate(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingDelete(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingSelect(T t, ResultSet resultSet) throws SQLException;
    public abstract void mappingSelectAll(T t, Set<T> sets, ResultSet resultSet)throws SQLException;
}
