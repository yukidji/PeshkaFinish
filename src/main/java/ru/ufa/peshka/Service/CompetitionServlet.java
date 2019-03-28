package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.CompetitionDao;
import ru.ufa.peshka.entity.Competition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/competition")
public class CompetitionServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        Competition competition = new Competition();
        CompetitionDao competitionDao = new CompetitionDao();

        /*
        try {
            competition = competitionDao.readById(this.competition, "054dd457-f081-427e-85db-7ebf0e56aa44");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            ex.printStackTrace();
        }
*/
        competition.setName(req.getParameter("nameCompetition"));
        competition.setPlace(req.getParameter("placeCompetition"));
        competition.setStartDay(req.getParameter("startDay"));
        competition.setStopDay(req.getParameter("stopDay"));
        competition.setNameJudge("nameJudge");
        competition.setNameSecretary("nameSecretary");
/*
        try {
            competitionDao.update(competition);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        */
        PrintWriter out = resp.getWriter();
        out.println(competition.getName() + " " + competition.getPlace());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        super.doGet(req, resp);
    }
}
