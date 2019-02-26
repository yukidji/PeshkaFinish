package ru.ufa.peshka.entity;

import ru.ufa.peshka.DAO.ConnectionDB;
import ru.ufa.peshka.DAO.DelegationDao;

import java.sql.*;
import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws SQLException, ClassNotFoundException, ParseException {
        ConnectionDB connectionDB = new ConnectionDB();
        DelegationDao delegationDao = new DelegationDao(connectionDB.getConnection());
        Delegation delegation = new Delegation();
        delegationDao.delete(delegation);

    }
}
