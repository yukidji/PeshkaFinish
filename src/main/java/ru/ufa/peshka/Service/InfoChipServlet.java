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

//@WebServlet("/chip")
public class InfoChipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else{


            Chip chip = new Chip();
            ChipDao chipDao = new ChipDao();
            List<Chip> chipList = new ArrayList<>();
            try {
                chipDao.getAll(chipList, chip);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            req.setAttribute("chipList",chipList);
            req.getRequestDispatcher("/pageAdd/addChip.jsp").forward(req, resp);
        }

    }
}
