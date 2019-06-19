package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.DAO.EntityDao.StageDao;
import ru.ufa.peshka.entity.Distance;
import ru.ufa.peshka.entity.Stage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@WebServlet("/stage")
public class StageServlet extends HttpServlet {

    private Distance distance;
    private DistanceDao distanceDao;

    private Stage stage;
    private StageDao stageDao;

    //извлекает информацию о дистанциях и этапах
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else {
            distance = (Distance) session.getAttribute("distance");
            stage = new Stage();

            distanceDao = new DistanceDao();
            stageDao = new StageDao();

            List<Distance> distanceList = new ArrayList<>();
            List<Stage> stageList = new ArrayList<>();

            //списки дистанций по типам
            List<Distance> listDistanceOne = new ArrayList<>();
            List<Distance> listDistanceTwo = new ArrayList<>();
            List<Distance> listDistanceFour = new ArrayList<>();

            //создаем список всех дистанций и всех этапов
            try {
                distanceDao.getAll(distanceList, distance);
                stageDao.getAll(stageList, stage);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            //сортировка по номеру этапа
            Collections.sort(stageList, Stage.COMPARE_BY_NUMBER);

            //расфасовываем дистанции по типу
            for (Distance d : distanceList) {
                if (d.getTypeDistance().toString().equals("ONE")) listDistanceOne.add(d);
                if (d.getTypeDistance().toString().equals("TWO")) listDistanceTwo.add(d);
                if (d.getTypeDistance().toString().equals("FOUR")) listDistanceFour.add(d);
            }

            req.setAttribute("distanceONE", listDistanceOne);
            req.setAttribute("distanceTWO", listDistanceTwo);
            req.setAttribute("distanceFOUR", listDistanceFour);
            req.setAttribute("stageList", stageList);
            getServletContext().getRequestDispatcher("/pageInfo/infoDistance.jsp").forward(req, resp);
        }
    }

    //создание записей этапов дистанции в бд
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else {
            distance = (Distance) session.getAttribute("distance");

            distanceDao = new DistanceDao();
            //создание записи дистанции
            try {
                distanceDao.create(distance);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            stageDao = new StageDao();
            for (int i = 1; i <= distance.getNumberStage(); i++) {
                stage = new Stage();
                stage.setIdDistance(distance.getId());
                stage.setNumber(Integer.parseInt(req.getParameter("number" + i)));
                stage.setName(req.getParameter("name" + i));
                stage.setControlTimeWoman(req.getParameter("controlTimeWoman"+i));
                stage.setControlTimeMan(req.getParameter("controlTimeMan" + i));
                stage.setLength(req.getParameter("length"+i));
                stage.setAngle(req.getParameter("angle"+i));
                stage.setDepth(req.getParameter("depth"+i));
                stage.setLongLogs(req.getParameter("longLogs"+i));
                stage.setRailAngle(req.getParameter("railAngle"+i));
                stage.setSupportHeight(req.getParameter("supportHeight"+i));

                try {
                    stageDao.create(stage);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
           resp.sendRedirect("/PeshkaFinish/pageAdd/addDistance.jsp");
        }
    }
}
