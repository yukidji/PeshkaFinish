package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Delegation;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashSet;

/**
 * интерфейс для работы с таблицей delegation (делегация)
 */
public interface DelegationDaoInterface {

    //create создание новой записи в БД
    void create(Delegation delegation) throws SQLException, ParseException;

    //read
    Delegation readById (String id) throws SQLException;

    //update
    void update(Delegation delegation) throws SQLException;

    //delete
    void delete (Delegation delegation) throws SQLException;

    //get All
    HashSet<Delegation> getAll() throws SQLException;

    void CloseConnection () throws SQLException;
}
