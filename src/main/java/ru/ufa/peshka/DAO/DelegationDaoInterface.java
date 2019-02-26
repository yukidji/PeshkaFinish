package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Delegation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

/**
 * интерфейс для работы с таблицей delegation (делегация)
 */
public interface DelegationDaoInterface {

    //create создание новой записи в БД
    Delegation create() throws SQLException, ParseException;

    //read
    Delegation readById (UUID id) throws SQLException;

    //update
    void update(Delegation delegation);

    //delete
    void delete (Delegation delegation);

    //get All
    List<Delegation> getAll() throws SQLException;
}