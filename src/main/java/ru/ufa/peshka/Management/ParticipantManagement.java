package ru.ufa.peshka.Management;

import ru.ufa.peshka.DAO.EntityDao.ParticipantDao;
import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;
import ru.ufa.peshka.entity.Participant;

import java.sql.SQLException;

public class ParticipantManagement {

    //добавление участника
    public void addParticipant (String firstName, String lastName, String patronymic,
                                       int age, Gender gender, Rank rank) throws SQLException, ClassNotFoundException {

        DelegationManagement delegationService = new DelegationManagement();

        ParticipantDao participantDao = new ParticipantDao();

        Participant participant = new Participant();
        participant.setFirstName(firstName);
        participant.setLastName(lastName);
        participant.setPatronymic(patronymic);
        participant.setAge(age);
        participant.setGender(gender);
        participant.setRank(rank);
        participant.setDelegationId(delegationService.getIdDelegation());
        System.out.println(delegationService.getIdDelegation());

        participantDao.create(participant);

    }
}
