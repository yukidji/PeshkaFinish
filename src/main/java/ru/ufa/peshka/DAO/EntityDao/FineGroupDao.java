package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.FineGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class FineGroupDao extends AbstractDao <FineGroup> {

    public FineGroupDao(Connection connection) {
        super(connection);
        super.sqlInsert = "INSERT INTO fine_group(id, number_stage, fine, cut, id_race_group) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM fine_group WHERE id = ?";
        super.sqlUpdate = "UPDATE fine_group SET number_stage = ?, fine = ?, cut = ?, id_race_group = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM fine_group WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, FineGroup fineGroup) throws SQLException {
        preparedStatement.setString(1, fineGroup.getId().toString());
        preparedStatement.setInt(2, fineGroup.getNumberStage());
        preparedStatement.setInt(3, fineGroup.getFine());
        preparedStatement.setString(4, Boolean.toString(fineGroup.getCut()));
        preparedStatement.setString(5, fineGroup.getRaceGroupId().toString());
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, FineGroup fineGroup, ResultSet resultSet, String id) throws SQLException {
        fineGroup.setId(UUID.fromString(resultSet.getString(id)));
        fineGroup.setNumberStage(resultSet.getInt(2));
        fineGroup.setFine(resultSet.getInt(3));
        fineGroup.setCut(Boolean.parseBoolean(resultSet.getString(4)));
        fineGroup.setRaceGroupId(UUID.fromString(resultSet.getString(5)));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, FineGroup fineGroup) throws SQLException {
        preparedStatement.setInt(1, fineGroup.getNumberStage());
        preparedStatement.setInt(2, fineGroup.getFine());
        preparedStatement.setString(3, Boolean.toString(fineGroup.getCut()));
        preparedStatement.setString(4, fineGroup.getRaceGroupId().toString());
        preparedStatement.setString(5, fineGroup.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, FineGroup fineGroup) throws SQLException {
        preparedStatement.setString(1, fineGroup.getId().toString());
    }
}