package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.CompetitionDao;
import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.entity.Competition;
import ru.ufa.peshka.entity.Distance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/startP")
public class StartServlet extends HttpServlet {

    private Distance distance;
    Competition competition;
    CompetitionDao competitionDao;

    //формирует стартовые протоклы (пока не заполняет)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        distance = new Distance();
        DistanceDao distanceDao = new DistanceDao();
        competition = new Competition();
        competitionDao = new CompetitionDao();
        String idDist = req.getParameter("IdDist");
        //чтение записи в БД о соревнованиях
        try {
            competitionDao.readById(competition,"054dd457-f081-427e-85db-7ebf0e56aa44");
            distanceDao.readById(distance, idDist);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //извлеченные дистанции

        //String timeHour = req.getParameter("time");
        //String timeMinute = req.getParameter("timeM");
        String name = competition.getName();
        String data = distance.getData();
        String place = competition.getPlace();
        String type = distance.getTypeDistance().toString();
        String classD = Integer.toString(distance.getClassDist());
        String nameSecretary = competition.getNameSecretary();
        req.setAttribute("name", name);
        req.setAttribute("data", data);
        req.setAttribute("place", place);
        req.setAttribute("type", type);
        req.setAttribute("classD", classD);
        req.setAttribute("nameSecretary", nameSecretary);

        //req.setAttribute("timeHour", time);
        //req.setAttribute("timeMinute", timeMinute);
        getServletContext().getRequestDispatcher("/generatorProtocol/startProtocol.jsp").forward(req, resp);
    }
}

