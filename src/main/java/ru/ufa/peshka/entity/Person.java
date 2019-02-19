package ru.ufa.peshka.entity;

/**
 * фио человека
 */
public abstract class Person extends AbstractID {
    /**
     * имя человека
     */
    private String firstName;
    /**
     * фамилия человека
     */
    private  String lastName;
    /**
     * отчество человека
     */
    private String patronymic;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
