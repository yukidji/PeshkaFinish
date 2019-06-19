package ru.ufa.peshka.Service;

import ru.ufa.peshka.DAO.EntityDao.DelegationDao;
import ru.ufa.peshka.DAO.EntityDao.ParticipantDao;
import ru.ufa.peshka.entity.Delegation;
import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;
import ru.ufa.peshka.entity.Participant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/participant")
public class AddParticipant extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //настройка кодировки
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();//получаем сессию
        if (session.getAttribute("login") == null) req.getRequestDispatcher("/entry.jsp").forward(req, resp);
        else {
            Delegation delegation;
            delegation = (Delegation)session.getAttribute("delegation");
            DelegationDao delegationDao = new DelegationDao();

            //создание записи в бд
            try {
                delegationDao.create(delegation);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            int sumParticipant = (Integer) session.getAttribute("sumParticipant");

            for (int i=1; i<=sumParticipant;i++){
                Participant participant = new Participant();
                ParticipantDao participantDao = new ParticipantDao();

                participant.setFirstName(req.getParameter("firstName"+i));
                participant.setLastName(req.getParameter("lastName"+i));
                participant.setAge(Integer.parseInt(req.getParameter("age"+i)));
                participant.setRank(Rank.valueOf(req.getParameter("rank"+i)));
                participant.setGender(Gender.valueOf(req.getParameter("gender"+i)));
                //participant.setChipId();
                participant.setDelegationId(delegation.getId());
            }


        }
    }
}
