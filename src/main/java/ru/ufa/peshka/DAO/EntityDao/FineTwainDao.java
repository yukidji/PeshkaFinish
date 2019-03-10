package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.Cut;
import ru.ufa.peshka.entity.FineTwain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class FineTwainDao extends AbstractDao <FineTwain> {
    public FineTwainDao() {
        super.sqlInsert = "INSERT INTO fine_twain(id, number_stage, fine, cut, id_race_tw) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM fine_twain WHERE id = ?";
        super.sqlUpdate = "UPDATE fine_twain SET number_stage = ?, fine = ?, cut = ?, id_race_tw = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM fine_twain WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM fine_twain";
    }

    //creat
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, FineTwain fineTwain) throws SQLException {
        preparedStatement.setString(1, fineTwain.getId().toString());
        preparedStatement.setInt(2, fineTwain.getNumberStage());
        preparedStatement.setInt(3, fineTwain.getFine());
        preparedStatement.setString(4, fineTwain.getCut().toString());
        preparedStatement.setString(5, fineTwain.getRaceTwainId().toString());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, FineTwain fineTwain) throws SQLException {
        preparedStatement.setInt(1, fineTwain.getNumberStage());
        preparedStatement.setInt(2, fineTwain.getFine());
        preparedStatement.setString(3, fineTwain.getCut().toString());
        preparedStatement.setString(4, fineTwain.getRaceTwainId().toString());
        preparedStatement.setString(5, fineTwain.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, FineTwain fineTwain) throws SQLException {
        preparedStatement.setString(1, fineTwain.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(FineTwain fineTwain, ResultSet resultSet) throws SQLException {
        fineTwain.setId(UUID.fromString(resultSet.getString(1)));
        fineTwain.setNumberStage(resultSet.getInt(2));
        fineTwain.setFine(resultSet.getInt(3));
        fineTwain.setCut(Cut.valueOf(resultSet.getString(4)));
        fineTwain.setRaceTwainId(UUID.fromString(resultSet.getString(5)));
    }

    @Override
    public void mappingSelectAll(FineTwain fineTwain, Set<FineTwain> sets, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            fineTwain = new FineTwain();
            mappingSelect(fineTwain,resultSet);
            sets.add(fineTwain);
        }
    }
}
