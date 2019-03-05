package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Chip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ChipDao extends AbstractDao<Chip> {

    public ChipDao(Connection connection) {
        super(connection);
        super.sqlInsert = "INSERT INTO chip (id, status) VALUES (?, ?)";
        super.sqlSelect = "SELECT * FROM chip WHERE id = ?";
        super.sqlUpdate = "UPDATE chip SET status = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM chip WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, Chip chip) throws SQLException {
        preparedStatement.setString(1,chip.getId().toString());
        preparedStatement.setString(2, Boolean.toString(chip.getStatus()));
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, Chip chip, ResultSet resultSet, String id) throws SQLException {
        chip.setId(UUID.fromString(resultSet.getString(id)));
        chip.setStatus(Boolean.parseBoolean(resultSet.getString(2)));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, Chip chip) throws SQLException {
        preparedStatement.setString(1, Boolean.toString(chip.getStatus()));
        preparedStatement.setString(2, chip.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Chip chip) throws SQLException {
        preparedStatement.setString(1, chip.getId().toString());
    }
}
