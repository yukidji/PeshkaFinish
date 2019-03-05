package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.RaceGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RaceGroupDao extends AbstractDao <RaceGroup> {
    public RaceGroupDao(Connection connection) {
        super(connection);
        super.sqlInsert = "INSERT INTO race_group(id, class_distance, start_time, finish_time) VALUES (?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM race_group WHERE id = ?";
        super.sqlUpdate = "UPDATE race_group SET class_distance = ?, start_time = ?, finish_time = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM race_group WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, RaceGroup raceGroup) throws SQLException {
        preparedStatement.setString(1, raceGroup.getId().toString());
        preparedStatement.setString(2, (raceGroup.getClassDistance().toString()));
        preparedStatement.setString(3, raceGroup.getTimeStart());
        preparedStatement.setString(4, raceGroup.getTimeFinish());
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, RaceGroup raceGroup, ResultSet resultSet, String id) throws SQLException {
        raceGroup.setId(UUID.fromString(resultSet.getString(id)));
        raceGroup.setClassDistance(ClassDistance.valueOf(resultSet.getString(2)));
        raceGroup.setTimeStart(resultSet.getString(3));
        raceGroup.setTimeFinish(resultSet.getString(4));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, RaceGroup raceGroup) throws SQLException {
        preparedStatement.setString(1, raceGroup.getClassDistance().toString());
        preparedStatement.setString(2, raceGroup.getTimeStart());
        preparedStatement.setString(3, raceGroup.getTimeFinish());
        preparedStatement.setString(4, raceGroup.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, RaceGroup raceGroup) throws SQLException {
        preparedStatement.setString(1,raceGroup.getId().toString());
    }
}
