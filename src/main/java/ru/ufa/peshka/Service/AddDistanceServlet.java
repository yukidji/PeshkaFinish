package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.entity.Distance;
import ru.ufa.peshka.entity.Enum.TypeDistance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/distance")
public class AddDistanceServlet extends HttpServlet {

    private Distance distance;
    private DistanceDao distanceDao;

    //добавляет новую дистанцию в БД
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        distance = new Distance();
        distanceDao = new DistanceDao();
        String typeD = req.getParameter("typeD");

        distance.getId();
        distance.setData(req.getParameter("data"));
        distance.setClassDist(Integer.parseInt(req.getParameter("classDist")));
        distance.setNumberStage(Integer.parseInt(req.getParameter("numberStage")));

        switch (typeD){
            case "one":
                distance.setTypeDistance(TypeDistance.ONE);
                break;
            case "two":
                distance.setTypeDistance(TypeDistance.TWO);
                break;
            case "four":
                distance.setTypeDistance(TypeDistance.FOUR);
                break;
            default:
                break;
        }

        //создание записи
        try {
            distanceDao.create(distance);
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        int numberStage = Integer.parseInt(req.getParameter("numberStage"));
        String idDistance = distance.getId().toString();

        req.setAttribute("idDistance", idDistance);
        req.setAttribute("numberStage", numberStage);
        getServletContext().getRequestDispatcher("/pageAdd/addStage.jsp").forward(req, resp);
    }
}
