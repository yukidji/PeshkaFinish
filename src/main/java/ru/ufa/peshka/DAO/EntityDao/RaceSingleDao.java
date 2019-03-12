package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.DAO.Enum.Time;
import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.RaceSingle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

public class RaceSingleDao extends AbstractDao <RaceSingle> {

    public RaceSingleDao() {
        super.sqlInsert = "INSERT INTO race_single(id, class_distance, start_time, finish_time, id_participant) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM race_single WHERE id = ?";
        super.sqlUpdate = "UPDATE race_single SET class_distance = ?, start_time = ?, finish_time = ?, id_participant = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM race_single WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM race_single";
    }

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, RaceSingle raceSingle) throws SQLException {
        preparedStatement.setString(1, raceSingle.getId().toString());
        preparedStatement.setString(2, (raceSingle.getClassDistance().toString()));
        preparedStatement.setString(3, raceSingle.getTimeStart());
        preparedStatement.setString(4, raceSingle.getTimeFinish());
        preparedStatement.setString(5, raceSingle.getParticipantId().toString());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, RaceSingle raceSingle) throws SQLException {
        preparedStatement.setString(1, raceSingle.getClassDistance().toString());
        if (Time.GET_TIME.toString().equals(raceSingle.getTimeStart()))
            preparedStatement.setTimestamp(2, Timestamp.from(java.time.Instant.now()));
        else preparedStatement.setString(2, raceSingle.getTimeStart());
        if (Time.GET_TIME.toString().equals(raceSingle.getTimeFinish()))
            preparedStatement.setTimestamp(3, Timestamp.from(java.time.Instant.now()));
        else preparedStatement.setString(3, raceSingle.getTimeFinish());
        preparedStatement.setString(4, raceSingle.getParticipantId().toString());
        preparedStatement.setString(5, raceSingle.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, RaceSingle raceSingle) throws SQLException {
        preparedStatement.setString(1,raceSingle.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(RaceSingle raceSingle, ResultSet resultSet) throws SQLException {
        raceSingle.setId(UUID.fromString(resultSet.getString(1)));
        raceSingle.setClassDistance(ClassDistance.valueOf(resultSet.getString(2)));
        raceSingle.setTimeStart(resultSet.getString(3));
        raceSingle.setTimeFinish(resultSet.getString(4));
        raceSingle.setParticipantId(UUID.fromString(resultSet.getString(5)));
    }

    //readAll
    @Override
    public void mappingSelectAll(RaceSingle raceSingle, Set<RaceSingle> sets, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            raceSingle = new RaceSingle();
            mappingSelect(raceSingle, resultSet);
            sets.add(raceSingle);
        }
    }
}
