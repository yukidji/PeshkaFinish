package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Chip;
import ru.ufa.peshka.entity.Enum.StatusChip;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class ChipDao extends AbstractDao<Chip> {

    public ChipDao() {
        super.sqlInsert = "INSERT INTO chip (id, status) VALUES (?, ?)";
        super.sqlSelect = "SELECT * FROM chip WHERE id = ?";
        super.sqlUpdate = "UPDATE chip SET status = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM chip WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM chip";
    }

    //Create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, Chip chip) throws SQLException {
        preparedStatement.setString(1,chip.getId().toString());
        preparedStatement.setString(2, chip.getStatus().toString());
    }

    //Update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, Chip chip) throws SQLException {
        preparedStatement.setString(1, chip.getStatus().toString());
        preparedStatement.setString(2, chip.getId().toString());
    }

    //Delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Chip chip) throws SQLException {
        preparedStatement.setString(1, chip.getId().toString());
    }

    //readBy
    @Override
    public void mappingSelect(Chip chip, ResultSet resultSet) throws SQLException {
        chip.setId(UUID.fromString(resultSet.getString(1)));
        chip.setStatus(StatusChip.valueOf(resultSet.getString(2)));
    }

    //readAll
    @Override
    public void mappingSelectAll(Chip chip, Set<Chip> sets, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            chip = new Chip();
            mappingSelect(chip,resultSet);
            sets.add(chip);
        }
    }
}
