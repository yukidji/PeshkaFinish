package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.DelegationDao;
import ru.ufa.peshka.entity.Delegation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/delegation")
public class DelegationService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else {
            Delegation delegation = new Delegation();

            delegation.setName(req.getParameter("name"));
            delegation.setPlace(req.getParameter("place"));
            delegation.setFirstName(req.getParameter("firstName"));
            delegation.setLastName(req.getParameter("lastName"));
            delegation.setPhoneCaptain(req.getParameter("phoneCaptain"));
            delegation.setSumParticipant(Integer.parseInt(req.getParameter("sumParticipant")));
            int sumParticipant = Integer.parseInt(req.getParameter("sumParticipant"));//кол-во участников в делегации
            session.setAttribute("delegation", delegation);
            session.setAttribute("sumParticipant", sumParticipant);
            req.getRequestDispatcher("/pageAdd/addParticipant.jsp").forward(req, resp);
        }
    }
}
