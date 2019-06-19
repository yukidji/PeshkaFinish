package ru.ufa.peshka;

import ru.ufa.peshka.DAO.EntityDao.ChipDao;
import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.DAO.EntityDao.StageDao;
import ru.ufa.peshka.DAO.EntityDao.UserDao;
import ru.ufa.peshka.entity.Chip;
import ru.ufa.peshka.entity.Distance;
import ru.ufa.peshka.entity.Stage;
import ru.ufa.peshka.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main (String [] args) throws SQLException, ClassNotFoundException {
        /*
        Stage stage = new Stage();
        StageDao stageDao = new StageDao();
        stageDao.setSqlDelete("DELETE FROM stage WHERE idDistance = ?","idDistance");
        stage.setIdDistance(UUID.fromString("5c4a9953-b247-4f39-a70e-c9e7b069099d"));
        stageDao.delete(stage);
        */

        User user = new User();
        UserDao userDao = new UserDao();

        user.setLogin("ulia");

        //читаем из БД пользователя с данным логином. соревнования в приложении одни
        try {
            userDao.readById(user, user.getLogin());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*user.toString();*/
    }
}
