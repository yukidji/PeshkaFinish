package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.CompetitionDao;
import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.DAO.EntityDao.StageDao;
import ru.ufa.peshka.entity.Competition;
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

//@WebServlet("/startP")
public class FinishServlet extends HttpServlet {

    Distance distance;
    Competition competition;
    CompetitionDao competitionDao;
    Stage stage;
    StageDao stageDao;

    //формирует финишные протоколы (пока ничего не формирует)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        competition = new Competition();
        competitionDao = new CompetitionDao();

        distance = new Distance();
        DistanceDao distanceDao = new DistanceDao();

        stage = new Stage();
        stageDao = new StageDao();
        List<Stage> stageList = new ArrayList<>();
        List<Stage> stageListIdDist = new ArrayList<>();

        String idDist = req.getParameter("IdDist");

        //чтение записи в БД о соревнованиях
        try {
            competitionDao.readById(competition,"054dd457-f081-427e-85db-7ebf0e56aa44");
            distanceDao.readById(distance, idDist);
            stageDao.getAll(stageList, stage);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Stage s:stageList){
            if(s.getIdDistance().toString().equals(idDist))
                stageListIdDist.add(s);
        }

        Collections.sort(stageListIdDist, Stage.COMPARE_BY_NUMBER);

        //извлеченные дистанции
        String name = competition.getName();
        String data = distance.getData();
        String place = competition.getPlace();
        String type = distance.getTypeDistance().toString();
        String classD = Integer.toString(distance.getClassDist());
        String nameSecretary = competition.getNameSecretary();
        String nameJudge = competition.getNameJudge();
        req.setAttribute("name", name);
        req.setAttribute("data", data);
        req.setAttribute("place", place);
        req.setAttribute("type", type);
        req.setAttribute("classD", classD);
        req.setAttribute("nameJudge", nameJudge);
        req.setAttribute("nameSecretary", nameSecretary);
        req.setAttribute("stages", stageListIdDist);

        getServletContext().getRequestDispatcher("/generatorProtocol/finishProtocol.jsp").forward(req, resp);

    }
}
