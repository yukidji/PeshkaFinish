package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.RaceSingle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RaceSingleDao extends AbstractDao <RaceSingle> {

    public RaceSingleDao() {
        super.sqlInsert = "INSERT INTO race_single(id, class_distance, start_time, finish_time, id_participant) VALUES (?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM race_single WHERE id = ?";
        super.sqlUpdate = "UPDATE race_single SET class_distance = ?, start_time = ?, finish_time = ?, id_participant = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM race_single WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, RaceSingle raceSingle) throws SQLException {
        preparedStatement.setString(1, raceSingle.getId().toString());
        preparedStatement.setString(2, (raceSingle.getClassDistance().toString()));
        preparedStatement.setString(3, raceSingle.getTimeStart());
        preparedStatement.setString(4, raceSingle.getTimeFinish());
        preparedStatement.setString(5, raceSingle.getParticipantId().toString());
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, RaceSingle raceSingle, ResultSet resultSet, String id) throws SQLException {
        raceSingle.setId(UUID.fromString(resultSet.getString(id)));
        raceSingle.setClassDistance(ClassDistance.valueOf(resultSet.getString(2)));
        raceSingle.setTimeStart(resultSet.getString(3));
        raceSingle.setTimeFinish(resultSet.getString(4));
        raceSingle.setParticipantId(UUID.fromString(resultSet.getString(5)));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, RaceSingle raceSingle) throws SQLException {
        preparedStatement.setString(1, raceSingle.getClassDistance().toString());
        preparedStatement.setString(2, raceSingle.getTimeStart());
        preparedStatement.setString(3, raceSingle.getTimeFinish());
        preparedStatement.setString(4, raceSingle.getParticipantId().toString());
        preparedStatement.setString(5, raceSingle.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, RaceSingle raceSingle) throws SQLException {
        preparedStatement.setString(1,raceSingle.getId().toString());
    }
}
