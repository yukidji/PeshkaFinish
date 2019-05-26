package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.DAO.EntityDao.StageDao;
import ru.ufa.peshka.entity.Distance;
import ru.ufa.peshka.entity.Stage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

//@WebServlet("/stage")
public class StageServlet extends HttpServlet {

    private Distance distance;
    private DistanceDao distanceDao;

    private Stage stage;
    private StageDao stageDao;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    //извлекает информацию о дистанциях и этапах
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        distance = new Distance();
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
            /*
            if (listDistanceOne.size() == 0) req.setAttribute("infoONE", "Такого вида дистанций нет");
            if (listDistanceTwo.size() == 0) req.setAttribute("infoTWO", "Такого вида дистанций нет");
            if (listDistanceFour.size() == 0) req.setAttribute("infoFOUR", "Такого вида дистанций нет");*/

        req.setAttribute("distanceONE", listDistanceOne);
        req.setAttribute("distanceTWO", listDistanceTwo);
        req.setAttribute("distanceFOUR", listDistanceFour);
        req.setAttribute("stageList", stageList);
        getServletContext().getRequestDispatcher("/pageInfo/infoDistance.jsp").forward(req, resp);
    }

    //создание записей этапов дистанции в бд
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        stageDao = new StageDao();

        String idDist = req.getParameter("idDist");
        String numberS = req.getParameter("numberS");//количество этапов

        for(int i=1; i<=Integer.parseInt(numberS); i++){
            stage = new Stage();
            stage.getId();
            stage.setIdDistance(UUID.fromString(idDist));
            stage.setNumber(Integer.parseInt(req.getParameter("number"+i)));
            stage.setName(req.getParameter("name"+i));
            stage.setControlTime(req.getParameter("controlTime"+i));

            try {
                stageDao.create(stage);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/PeshkaFinish/pageAdd/addDistance.jsp");
    }

}
