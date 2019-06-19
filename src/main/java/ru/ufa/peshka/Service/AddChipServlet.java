package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.ChipDao;
import ru.ufa.peshka.entity.Chip;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/addChip")
public class AddChipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else{
            ChipDao chipDao = new ChipDao();
            int sumChip = Integer.parseInt(req.getParameter("sumChip"));
            for (int i=1; i<=sumChip; i++){
                Chip chip = new Chip();
                try {
                    chipDao.create(chip);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            req.getRequestDispatcher("/chip").forward(req, resp);
        }
    }
}
