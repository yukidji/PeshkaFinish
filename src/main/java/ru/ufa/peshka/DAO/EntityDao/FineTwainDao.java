package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.FineTwain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FineTwainDao extends AbstractDao <FineTwain> {
    public FineTwainDao() {
        super.sqlInsert = "INSERT INTO fine_twain(id, number_stage, fine, cut, id_race_tw) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM fine_twain WHERE id = ?";
        super.sqlUpdate = "UPDATE fine_twain SET number_stage = ?, fine = ?, cut = ?, id_race_tw = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM fine_twain WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, FineTwain fineTwain) throws SQLException {
        preparedStatement.setString(1, fineTwain.getId().toString());
        preparedStatement.setInt(2, fineTwain.getNumberStage());
        preparedStatement.setInt(3, fineTwain.getFine());
        preparedStatement.setString(4, Boolean.toString(fineTwain.getCut()));
        preparedStatement.setString(5, fineTwain.getRaceTwainId().toString());
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, FineTwain fineTwain, ResultSet resultSet, String id) throws SQLException {
        fineTwain.setId(UUID.fromString(resultSet.getString(id)));
        fineTwain.setNumberStage(resultSet.getInt(2));
        fineTwain.setFine(resultSet.getInt(3));
        fineTwain.setCut(Boolean.parseBoolean(resultSet.getString(4)));
        fineTwain.setRaceTwainId(UUID.fromString(resultSet.getString(5)));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, FineTwain fineTwain) throws SQLException {
        preparedStatement.setInt(1, fineTwain.getNumberStage());
        preparedStatement.setInt(2, fineTwain.getFine());
        preparedStatement.setString(3, Boolean.toString(fineTwain.getCut()));
        preparedStatement.setString(4, fineTwain.getRaceTwainId().toString());
        preparedStatement.setString(5, fineTwain.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, FineTwain fineTwain) throws SQLException {
        preparedStatement.setString(1, fineTwain.getId().toString());
    }
}
