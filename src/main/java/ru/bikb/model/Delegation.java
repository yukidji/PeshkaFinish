package ru.bikb.model;
/**
 * делегация участников
 */
public class Delegation {
    /**
     * идентификационный номер делегации
     */
    private int idDelegation;
    /**
     * название делегации
     */
    private String nameDelegation;
    /**
     * Месторасположение делегации: город, район и т.д. делегации
     */
    private String placeDelegation;
    /**
     * ФИО представителя делегации (капитана команды)
     */
    private String fioDelegation;
    /**
     * номер телефона представителя делегации
     */
    private String numberPhoneCaptain;
    /**
     * количество участников в команде/делегации
     */
    private int sumParticipant;
    /**
     * дата прибытия делегации на соревнования
     */
    private String arriveDate;

    //***********************************************************

    public int getIdDelegation() {
        return idDelegation;
    }

    public void setIdDelegation(int idDelegation) {
        this.idDelegation = idDelegation;
    }

    public String getNameDelegation() {
        return nameDelegation;
    }

    public void setNameDelegation(String nameDelegation) {
        this.nameDelegation = nameDelegation;
    }

    public String getPlaceDelegation() {
        return placeDelegation;
    }

    public void setPlaceDelegation(String placeDelegation) {
        this.placeDelegation = placeDelegation;
    }

    public String getFioDelegation() {
        return fioDelegation;
    }

    public void setFioDelegation(String fioDelegation) {
        this.fioDelegation = fioDelegation;
    }

    public String getNumberPhoneCaptain() {
        return numberPhoneCaptain;
    }

    public void setNumberPhoneCaptain(String numberPhoneCaptain) {
        this.numberPhoneCaptain = numberPhoneCaptain;
    }

    public int getSumParticipant() {
        return sumParticipant;
    }

    public void setSumParticipant(int sumParticipant) {
        this.sumParticipant = sumParticipant;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    @Override
    public String toString() {
        return "Delegation{" +
                "idDelegation=" + idDelegation +
                ", nameDelegation='" + nameDelegation + '\'' +
                ", placeDelegation='" + placeDelegation + '\'' +
                ", fioDelegation='" + fioDelegation + '\'' +
                ", numberPhoneCaptain='" + numberPhoneCaptain + '\'' +
                ", sumParticipant=" + sumParticipant +
                ", arriveDate='" + arriveDate + '\'' +
                '}';
    }
}
