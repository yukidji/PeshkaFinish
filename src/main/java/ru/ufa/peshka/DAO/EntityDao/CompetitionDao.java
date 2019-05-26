package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Competition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CompetitionDao extends AbstractDao<Competition> {

    public CompetitionDao() {
        super.sqlInsert = "INSERT INTO competition (id, name, place, startDay, stopDay, " +
                "nameJudge, nameSecretary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM competition WHERE id = ?";
        super.sqlUpdate = "UPDATE competition SET name = ?, place= ?, startDay = ?, stopDay= ?, nameJudge= ?, nameSecretary= ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM competition WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM competition";
    }

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, Competition competition) throws SQLException {
        preparedStatement.setString(1, competition.getId().toString());
        preparedStatement.setString(2, competition.getName());
        preparedStatement.setString(3, competition.getPlace());
        preparedStatement.setString(4, competition.getStartDay());
        preparedStatement.setString(5, competition.getStopDay());
        preparedStatement.setString(6, competition.getNameJudge());
        preparedStatement.setString(7, competition.getNameSecretary());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, Competition competition) throws SQLException {
        preparedStatement.setString(1, competition.getName());
        preparedStatement.setString(2, competition.getPlace());
        preparedStatement.setString(3, competition.getStartDay());
        preparedStatement.setString(4, competition.getStopDay());
        preparedStatement.setString(5, competition.getNameJudge());
        preparedStatement.setString(6, competition.getNameSecretary());
        preparedStatement.setString(7, competition.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Competition competition) throws SQLException {
        preparedStatement.setString(1,competition.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(Competition competition, ResultSet resultSet) throws SQLException {
        competition.setId(UUID.fromString(resultSet.getString(1)));
        competition.setName(resultSet.getString(2));
        competition.setPlace(resultSet.getString(3));
        competition.setStartDay(resultSet.getString(4));
        competition.setStopDay(resultSet.getString(5));
        competition.setNameJudge(resultSet.getString(6));
        competition.setNameSecretary(resultSet.getString(7));
    }

    //getAll
    @Override
    public void mappingSelectAll(Competition competition, List<Competition> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            competition = new Competition();
            mappingSelect(competition, resultSet);
            list.add(competition);
        }
    }
}
