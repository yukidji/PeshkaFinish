package ru.ufa.peshka.entity;

import ru.ufa.peshka.DAO.UtilsDB;
import ru.ufa.peshka.DAO.EntityDao.DelegationDao;

import java.sql.*;
import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws SQLException, ClassNotFoundException, ParseException {
        UtilsDB utilsDB = new UtilsDB();
        DelegationDao delegationDao = new DelegationDao(utilsDB.getConnection());
        Delegation delegation = new Delegation();
        utilsDB.closeConnection();
    }
}
