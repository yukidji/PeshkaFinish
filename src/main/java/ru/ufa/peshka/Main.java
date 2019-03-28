package ru.ufa.peshka;

import ru.ufa.peshka.DAO.EntityDao.CompetitionDao;
import ru.ufa.peshka.entity.Competition;

import java.sql.SQLException;

public class Main {
    public static void main (String [] args) throws SQLException, ClassNotFoundException {
        Competition competition = new Competition();
        CompetitionDao competitionDao = new CompetitionDao();
        //competitionDao.create(competition);

    }
}
