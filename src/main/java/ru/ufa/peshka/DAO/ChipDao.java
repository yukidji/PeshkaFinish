package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Chip;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Set;

public class ChipDao implements GenericDao <Chip> {

    @Override
    public void create(Chip chip) throws SQLException, ParseException {

    }

    @Override
    public Chip readById(String id) throws SQLException {
        return null;
    }

    @Override
    public void update(Chip chip) throws SQLException {

    }

    @Override
    public void delete(Chip chip) throws SQLException {

    }

    @Override
    public Set<Chip> getAll() throws SQLException {
        return null;
    }
}
