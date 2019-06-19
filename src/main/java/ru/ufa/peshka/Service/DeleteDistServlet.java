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
import java.util.UUID;

//@WebServlet("/deleteDistance")
public class DeleteDistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDist = req.getParameter("idDist");

        Distance distance = new Distance();
        DistanceDao distanceDao = new DistanceDao();
        distance.setId(UUID.fromString(idDist));

        Stage stage = new Stage();
        StageDao stageDao = new StageDao();
        stageDao.setSqlDelete("DELETE FROM stage WHERE idDistance = ?","idDistance");
        stage.setIdDistance(UUID.fromString(idDist));

        //удаление дистанции и ее этапов
        try {
            stageDao.delete(stage);
            distanceDao.delete(distance);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/stage").forward(req, resp);
    }
}
