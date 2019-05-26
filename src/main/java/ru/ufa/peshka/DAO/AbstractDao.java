package ru.ufa.peshka.DAO;

import org.apache.log4j.Logger;
import ru.ufa.peshka.DAO.Enum.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao <T>{
    protected UtilsDB conn = new UtilsDB();

    public String sqlInsert;
    public String sqlSelect;
    public String sqlUpdate;
    public String sqlDelete;
    public String sqlSelectAll;
    public String sqlSelectListById;

    public String id;
    public List<T> list;

    private static Logger logger = Logger.getLogger(AbstractDao.class.getName());

    public String getSQL (CRUD param){
        if (param == CRUD.INSERT) return sqlInsert;
        if (param == CRUD.SELECT) return sqlSelect;
        if (param == CRUD.UPDATE) return sqlUpdate;
        if (param == CRUD.DELETE) return sqlDelete;
        if (param == CRUD.SELECT_ALL) return sqlSelectAll;
        else {
            logger.debug("param is not validate");
            return null;
        }
    }

    void fillStatement (T t, CRUD param) throws SQLException, ClassNotFoundException {
        try (Connection connection = conn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getSQL(param))){

            if (param == CRUD.INSERT){
                mappingInsert(preparedStatement, t);
                preparedStatement.execute();
                logger.info("INSERT in DB: " + t.toString());
            }
            if (param == CRUD.UPDATE){
                mappingUpdate(preparedStatement, t);
                preparedStatement.executeUpdate();
                logger.info("UPDATE in DB: " + t.toString());
            }
            if (param == CRUD.DELETE){
                mappingDelete(preparedStatement, t);
                preparedStatement.executeUpdate();
                logger.info("DELETE FROM DB: " + t.toString());
            }

            if (param == CRUD.SELECT){
                preparedStatement.setString(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    mappingSelect(t, resultSet);
                    logger.info("SELECT FROM DB: " + t.toString());
                }
            }
            if (param == CRUD.SELECT_ALL){
                try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(getSQL(param))){
                    mappingSelectAll(t, list, resultSet);
                    logger.info("SELECT_ALL FROM DB: " + list.toString());
                }
            }
        } catch (SQLException e) {
            logger.error("Could not perform CRUD operation. Operation: " + param.toString()+": ", e);
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
    public List<T> getAll(List<T> list, T t) throws SQLException, ClassNotFoundException {
        this.list = list;
        fillStatement(t, CRUD.SELECT_ALL);
        return list;
    }

    public abstract void mappingInsert(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingUpdate(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingDelete(PreparedStatement preparedStatement, T t) throws SQLException;
    public abstract void mappingSelect(T t, ResultSet resultSet) throws SQLException;
    public abstract void mappingSelectAll(T t, List<T> list, ResultSet resultSet)throws SQLException;
}
