package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.CompetitionDao;
import ru.ufa.peshka.entity.Competition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/competition")
public class CompetitionServlet extends HttpServlet  {

    private Competition competition;
    private CompetitionDao competitionDao;

    @Override
    public void init() throws ServletException {
        competition = new Competition();
        competitionDao = new CompetitionDao();
    }

    //обновление записи о соревнованиях в бд и перенеправление на страницу infoCompetition для ее просмотра
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        try {
           competitionDao.readById(competition, "054dd457-f081-427e-85db-7ebf0e56aa44");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        competition.setName(req.getParameter("name"));
        competition.setPlace(req.getParameter("place"));
        competition.setStartDay(req.getParameter("startDay"));
        competition.setStopDay(req.getParameter("stopDay"));
        competition.setNameJudge(req.getParameter("nameJudge"));
        competition.setNameSecretary(req.getParameter("nameSecretary"));

        try {
            competitionDao.update(competition);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            e.printStackTrace();
        }

        req.setAttribute("competition", competition);
        getServletContext().getRequestDispatcher("/pageInfo/infoCompetition.jsp").forward(req, resp);
    }

    //извлекает данные из бд и выводит их на странице
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String action = req.getParameter("action");

        try {
            competitionDao.readById(competition, "054dd457-f081-427e-85db-7ebf0e56aa44");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("competition", competition);
        switch (action == null? "info" : "update"){
            case "info":
                //путь не трогать /pageInfo/infoCompetition.jsp. не добавлять к нему PeshkaFinish бла бла бла
                getServletContext().getRequestDispatcher("/pageInfo/infoCompetition.jsp").forward(req, resp);
                break;
            case "update":
                getServletContext().getRequestDispatcher("/pageAdd/addCompetition.jsp").forward(req, resp);
                break;
        }

    }
}
