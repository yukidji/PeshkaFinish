package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Delegation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Set;

public interface GenericDao <T>{

    //create создание новой записи в БД
    void create(T t) throws SQLException, ParseException;

    //read
    T readById (String id) throws SQLException;

    //update
    void update(T object) throws SQLException;

    //delete
    void delete (T object) throws SQLException;

    //get All
    Set<T> getAll() throws SQLException;

}
