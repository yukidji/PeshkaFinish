package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Chip;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ChipDaoInterface {
    Chip create() throws SQLException, ParseException;

    //read
    Chip readById (String id) throws SQLException;

    //update
    void update(Chip chip) throws SQLException;

    //delete
    void delete (Chip chip) throws SQLException;

    //get All
    List<Chip> getAll() throws SQLException;

}
