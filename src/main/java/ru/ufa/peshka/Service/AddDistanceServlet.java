package ru.ufa.peshka.Service;

import ru.ufa.peshka.entity.Distance;
import ru.ufa.peshka.entity.Enum.TypeDistance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/distance")
public class AddDistanceServlet extends HttpServlet {

    private Distance distance;

    //добавляет новую дистанцию в БД
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        //проверить
        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else {
            distance = new Distance();
            String typeD = req.getParameter("typeD");

            distance.setData(req.getParameter("data"));
            distance.setClassDist(Integer.parseInt(req.getParameter("classDist")));
            distance.setNumberStage(Integer.parseInt(req.getParameter("numberStage")));

            switch (typeD) {
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

            int numberStage = Integer.parseInt(req.getParameter("numberStage"));//кол-во этапов
            session.setAttribute("distance", distance);
            req.setAttribute("numberStage", numberStage);
            req.getRequestDispatcher("/pageAdd/addStage.jsp").forward(req, resp);
        }
    }
}
