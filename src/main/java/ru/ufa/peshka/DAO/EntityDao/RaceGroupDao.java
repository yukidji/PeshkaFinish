package ru.ufa.peshka.DAO.EntityDao;

import org.apache.log4j.Logger;
import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.DAO.Enum.Time;
import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.RaceGroup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class RaceGroupDao extends AbstractDao <RaceGroup> {

    private String startTime = "";
    private String finishTime = "";

    public RaceGroupDao() {
        super.sqlInsert = "INSERT INTO race_group(id, class_distance, start_time, finish_time) VALUES (?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM race_group WHERE id = ?";
        super.sqlUpdate = "UPDATE race_group SET class_distance = ?, start_time = ?, finish_time = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM race_group WHERE id = ?";
        super.sqlSelectAll ="SELECT * FROM race_group";
    }

    private static Logger logger = Logger.getLogger(RaceGroupDao.class.getName());

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, RaceGroup raceGroup) throws SQLException {
        preparedStatement.setString(1, raceGroup.getId().toString());
        if (raceGroup.getClassDistance() == null) logger.debug("ClassDistance = null");
        else preparedStatement.setString(2, raceGroup.getClassDistance().toString());
        preparedStatement.setString(3, raceGroup.getTimeStart());
        preparedStatement.setString(4, raceGroup.getTimeFinish());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, RaceGroup raceGroup) throws SQLException {
        preparedStatement.setString(1, raceGroup.getClassDistance().toString());
        if (Time.GET_TIME.toString().equals(raceGroup.getTimeStart()))
            preparedStatement.setTimestamp(2, Timestamp.from(java.time.Instant.now()));
        else preparedStatement.setString(2, raceGroup.getTimeStart());
        if (Time.GET_TIME.toString().equals(raceGroup.getTimeFinish()))
            preparedStatement.setTimestamp(3, Timestamp.from(java.time.Instant.now()));
        else preparedStatement.setString(3, raceGroup.getTimeFinish());
        preparedStatement.setString(4, raceGroup.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, RaceGroup raceGroup) throws SQLException {
        preparedStatement.setString(1,raceGroup.getId().toString());
    }

    //readByKye
    @Override
    public void mappingSelect(RaceGroup raceGroup, ResultSet resultSet) throws SQLException {
        raceGroup.setId(UUID.fromString(resultSet.getString(1)));
        raceGroup.setClassDistance(ClassDistance.valueOf(resultSet.getString(2)));
        raceGroup.setTimeStart(resultSet.getString(3));
        raceGroup.setTimeFinish(resultSet.getString(4));
    }

    //readAll
    @Override
    public void mappingSelectAll(RaceGroup raceGroup, List<RaceGroup> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            raceGroup = new RaceGroup();
            mappingSelect(raceGroup, resultSet);
            list.add(raceGroup);
        }
    }
}
