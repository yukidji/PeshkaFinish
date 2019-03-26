package ru.ufa.peshka.Management;

import ru.ufa.peshka.DAO.EntityDao.DelegationDao;
import ru.ufa.peshka.entity.Delegation;
import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class DelegationManagement {

    private int sumParticipant;
    private Delegation delegation;

    //добавление делегации
    public void addDelegation (String name, String place, String firstName,
                                      String lastName, String patronymic, String phoneCaptain,
                                      int sumParticipant, Data arriveDate) throws SQLException, ClassNotFoundException {

        this.sumParticipant = sumParticipant;
        DelegationDao delegationDao = new DelegationDao();

        this.delegation = new Delegation();
        delegation.getId();
        System.out.println(delegation.getId());
        delegation.setName(name);
        delegation.setPlace(place);
        delegation.setFirstName(firstName);
        delegation.setLastName(lastName);
        delegation.setPatronymic(patronymic);
        delegation.setPhoneCaptain(phoneCaptain);
        delegation.setSumParticipant(sumParticipant);
        delegation.setArriveDate((Date) arriveDate);//???
        delegationDao.create(delegation);
    }

    public UUID getIdDelegation (){
        return this.delegation.getId();
    }

    /**как вариант перенести это в класс сервиса
    public void addDelegationParticipants() throws SQLException, ClassNotFoundException {

        int sumParticipant;
        sumParticipant = this.sumParticipant;
        ParticipantManagement participantService = new ParticipantManagement();

        for (int i = 0; i<sumParticipant; i++){
            String firstName;
            String lastName;
            String patronymic;
            int age;
            Gender gender;
            Rank rank;
            participantService.addParticipant(firstName, lastName, patronymic, age, gender, rank);
        }
    }
     */
}
