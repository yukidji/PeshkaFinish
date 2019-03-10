package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.DAO.Enum.Time;
import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.RaceTwain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

public class RaceTwainDao extends AbstractDao <RaceTwain> {

    public RaceTwainDao() {
        super.sqlInsert = "INSERT INTO race_twain(id, class_distance, start_time, finish_time) VALUES (?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM race_twain WHERE id = ?";
        super.sqlUpdate = "UPDATE race_twain SET class_distance = ?, start_time = ?, finish_time = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM race_twain WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM race_twain";
    }

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, RaceTwain raceTwain) throws SQLException {
        preparedStatement.setString(1, raceTwain.getId().toString());
        preparedStatement.setString(2, (raceTwain.getClassDistance().toString()));
        preparedStatement.setString(3, raceTwain.getTimeStart());
        preparedStatement.setString(4, raceTwain.getTimeFinish());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, RaceTwain raceTwain) throws SQLException {
        preparedStatement.setString(1, raceTwain.getClassDistance().toString());
        if (Time.GET_TIME.toString().equals(raceTwain.getTimeStart()))
            preparedStatement.setTimestamp(2, Timestamp.from(java.time.Instant.now()));
        else preparedStatement.setString(2, raceTwain.getTimeStart());
        if (Time.GET_TIME.toString().equals(raceTwain.getTimeFinish()))
            preparedStatement.setTimestamp(3, Timestamp.from(java.time.Instant.now()));
        else preparedStatement.setString(3, raceTwain.getTimeFinish());
        preparedStatement.setString(4, raceTwain.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, RaceTwain raceTwain) throws SQLException {
        preparedStatement.setString(1,raceTwain.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(RaceTwain raceTwain, ResultSet resultSet) throws SQLException {
        raceTwain.setId(UUID.fromString(resultSet.getString(1)));
        raceTwain.setClassDistance(ClassDistance.valueOf(resultSet.getString(2)));
        raceTwain.setTimeStart(resultSet.getString(3));
        raceTwain.setTimeFinish(resultSet.getString(4));
    }

    //readAll
    @Override
    public void mappingSelectAll(RaceTwain raceTwain, Set<RaceTwain> sets, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            raceTwain = new RaceTwain();
            mappingSelect(raceTwain, resultSet);
            sets.add(raceTwain);
        }
    }
}
