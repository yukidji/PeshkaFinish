package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.FineSingle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FineSingleDao extends AbstractDao<FineSingle> {
    public FineSingleDao(Connection connection) {
        super(connection);
        super.sqlInsert = "INSERT INTO fine_single(id, number_stage, fine, cut, id_race_single) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM fine_single WHERE id = ?";
        super.sqlUpdate = "UPDATE fine_single SET number_stage = ?, fine = ?, cut = ?, id_race_single = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM fine_single WHERE id = ?";
    }

    //FineSingleDao, FineGroupDao, FineTwainDao код повотряется, не знаю как исправть
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, FineSingle fineSingle) throws SQLException {
        preparedStatement.setString(1, fineSingle.getId().toString());
        preparedStatement.setInt(2, fineSingle.getNumberStage());
        preparedStatement.setInt(3, fineSingle.getFine());
        preparedStatement.setString(4, Boolean.toString(fineSingle.getCut()));
        preparedStatement.setString(5, fineSingle.getRaceSingleId().toString());
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, FineSingle fineSingle, ResultSet resultSet, String id) throws SQLException {
        fineSingle.setId(UUID.fromString(resultSet.getString(id)));
        fineSingle.setNumberStage(resultSet.getInt(2));
        fineSingle.setFine(resultSet.getInt(3));
        fineSingle.setCut(Boolean.parseBoolean(resultSet.getString(4)));
        fineSingle.setRaceSingleId(UUID.fromString(resultSet.getString(5)));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, FineSingle fineSingle) throws SQLException {
        preparedStatement.setInt(1, fineSingle.getNumberStage());
        preparedStatement.setInt(2, fineSingle.getFine());
        preparedStatement.setString(3, Boolean.toString(fineSingle.getCut()));
        preparedStatement.setString(4, fineSingle.getRaceSingleId().toString());
        preparedStatement.setString(5, fineSingle.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, FineSingle fineSingle) throws SQLException {
        preparedStatement.setString(1, fineSingle.getId().toString());
    }
}
