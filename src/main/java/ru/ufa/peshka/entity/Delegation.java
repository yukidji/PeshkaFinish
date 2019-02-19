package ru.ufa.peshka.entity;

import java.util.Date;

/**
 * делегация участников
 */
public class Delegation extends Person {
    /**
     * название делегации
     */
    private String name;
    /**
     * Месторасположение делегации: город, район и т.д. делегации
     */
    private String place;

    /**
     * номер телефона представителя делегации
     */
    private String phoneCaptain;
    /**
     * количество участников в команде/делегации
     */
    private int sumParticipant;
    /**
     * дата прибытия делегации на соревнования
     */
    private Date arriveDate;

    //***********************************************************

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneCaptain() {
        return phoneCaptain;
    }

    public void setPhoneCaptain(String phoneCaptain) {
        this.phoneCaptain = phoneCaptain;
    }

    public int getSumParticipant() {
        return sumParticipant;
    }

    public void setSumParticipant(int sumParticipant) {
        this.sumParticipant = sumParticipant;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }


    @Override
    public String toString() {
        return "Delegation{" +
                "id=" + getId() +
                ", name ='" + name + '\'' +
                ", place ='" + place + '\'' +
                ", firstName" + getFirstName() + '\'' +
                ", lastName" + getLastName() + '\'' +
                ", patronymic" + getPatronymic() + '\'' +
                ", phoneCaptain='" + phoneCaptain + '\'' +
                ", sumParticipant=" + sumParticipant +
                ", arriveDate='" + arriveDate + '\'' +
                '}';
    }
}
