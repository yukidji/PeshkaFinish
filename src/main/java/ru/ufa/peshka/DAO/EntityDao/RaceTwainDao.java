package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.RaceTwain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RaceTwainDao extends AbstractDao <RaceTwain> {

    public RaceTwainDao(Connection connection) {
        super(connection);
        super.sqlInsert = "INSERT INTO race_twain(id, class_distance, start_time, finish_time) VALUES (?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM race_twain WHERE id = ?";
        super.sqlUpdate = "UPDATE race_twain SET class_distance = ?, start_time = ?, finish_time = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM race_twain WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, RaceTwain raceTwain) throws SQLException {
        preparedStatement.setString(1, raceTwain.getId().toString());
        preparedStatement.setString(2, (raceTwain.getClassDistance().toString()));
        preparedStatement.setString(3, raceTwain.getTimeStart());
        preparedStatement.setString(4, raceTwain.getTimeFinish());
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, RaceTwain raceTwain, ResultSet resultSet, String id) throws SQLException {
        raceTwain.setId(UUID.fromString(resultSet.getString(id)));
        raceTwain.setClassDistance(ClassDistance.valueOf(resultSet.getString(2)));
        raceTwain.setTimeStart(resultSet.getString(3));
        raceTwain.setTimeFinish(resultSet.getString(4));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, RaceTwain raceTwain) throws SQLException {
        preparedStatement.setString(1, raceTwain.getClassDistance().toString());
        preparedStatement.setString(2, raceTwain.getTimeStart());
        preparedStatement.setString(3, raceTwain.getTimeFinish());
        preparedStatement.setString(4, raceTwain.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, RaceTwain raceTwain) throws SQLException {
        preparedStatement.setString(1,raceTwain.getId().toString());
    }
}
