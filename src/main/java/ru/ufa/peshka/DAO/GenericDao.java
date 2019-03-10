package ru.ufa.peshka.DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Set;

public interface GenericDao <T> {

    //create создание новой записи в БД
    void create(T t) throws SQLException, ParseException, ClassNotFoundException;

    //update
    void update(T object) throws SQLException, ClassNotFoundException;

    //delete
    void delete (T object) throws SQLException, ClassNotFoundException;

    //read
    T readById (T t, String id) throws SQLException, ClassNotFoundException;

     //get All
     Set<T> getAll(Set<T> set, T t) throws SQLException, ClassNotFoundException;


}
