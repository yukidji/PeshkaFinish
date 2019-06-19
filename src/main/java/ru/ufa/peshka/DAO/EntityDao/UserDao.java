package ru.ufa.peshka.DAO.EntityDao;

import org.apache.log4j.Logger;
import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.StatusUser;
import ru.ufa.peshka.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super.sqlInsert = "INSERT INTO user (id, password, login, status)" +
                "VALUES (?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM user WHERE login = ?";
        super.sqlUpdate = "UPDATE user SET password = ?, login = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM user WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM user";
    }

    private static Logger logger = Logger.getLogger(ParticipantDao.class.getName());

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getId().toString());
        if (user.getPassword() == null) logger.debug("password = null");
        else preparedStatement.setString(2, user.getPassword());
        if (user.getLogin() == null) logger.debug("login = null");
        else preparedStatement.setString(3, user.getLogin());
        preparedStatement.setString(4, user.getStatus().toString());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getLogin());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1,user.getId().toString());
    }

    //readByLogin
    @Override
    public void mappingSelect(User user, ResultSet resultSet) throws SQLException {
        user.setId(UUID.fromString(resultSet.getString(1)));
        user.setPassword(resultSet.getString(2));
        user.setLogin(resultSet.getString(3));
        user.setStatus(StatusUser.valueOf(resultSet.getString(4)));
    }

    //getAll
    @Override
    public void mappingSelectAll(User user, List<User> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            user = new User();
            mappingSelect(user, resultSet);
            list.add(user);
        }
    }
}
