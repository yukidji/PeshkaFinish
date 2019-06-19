package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.DistanceDao;
import ru.ufa.peshka.entity.Distance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/table")
public class GeneratorServlet extends HttpServlet {
    private Distance distance;
    private DistanceDao distanceDao;

    //извлекает все дистанции которые имеются в БД
    //Доработать
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        distance = new Distance();
        distanceDao = new DistanceDao();

        List<Distance> distances = new ArrayList<>();

        //выбор всех дистанций
        try {
            distanceDao.getAll(distances,distance);
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("distances", distances);
        req.getRequestDispatcher("/generatorProtocol/generator.jsp").forward(req, resp);
    }
}
