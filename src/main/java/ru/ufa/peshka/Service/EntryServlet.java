package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.UserDao;
import ru.ufa.peshka.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/entry")
public class EntryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        User user = new User();
        UserDao userDao = new UserDao();
        user.setId(null);

        user.setLogin(req.getParameter("login"));

        //читаем из БД пользователя с данным логином. соревнования в приложении одни
        try {
            userDao.readById(user, user.getLogin());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String status = user.getStatus().toString();
        if (user.getId() != null  && user.getPassword().equals(req.getParameter("password"))) {
            String login = req.getParameter("login");
            HttpSession session = req.getSession();//получаем сессию
            session.setAttribute("login", login);
            if("SECRETARY".equals(status)) {
                session.setAttribute("status", "SECRETARY");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }else{
                session.setAttribute("status", "USER");
                req.getRequestDispatcher("/index2.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("info", "Не верно введены данные логина и/или пароля");
            req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        }

    }
}
