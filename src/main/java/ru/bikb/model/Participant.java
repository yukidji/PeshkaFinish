package ru.bikb.model;
/**
 * участники соревнований
 */
public class Participant {
    /**
     * идентификационный номер участника
     */
    private int idParticipant;
    /**
     * имя участника
     */
    private String firstName;
    /**
     * фамилия участника
     */
    private String lastName;
    /**
     * отчество участника
     */
    private String patronymic;
    /**
     * год рождения участника (1997, 2000 ...)
     */
    private int age;
    /**
     * пол участника (м, ж)
     */
    private Gender gender; //сделать колекцию ...
    /**
     * разряд участника (1, 2, 3, 1ю, 2ю, 3ю, б/р, кмс, мс)
     */
    private Rank rank;
    /**
     * идентификационный номер делегации участника
     */
    private int deligationId;
    /**
     * идентификационный номер чипа участника
     */
    private int chipId;
    /**
     * идентификационный номер связки участника (забег пары)
     */
    private int raceSVid;
    /**
     * идентификационный номер группы участника (забег группы)
     */
    private int raceGid;

    //**********************************************************

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getDeligationId() {
        return deligationId;
    }

    public void setDeligationId(int deligationId) {
        this.deligationId = deligationId;
    }

    public int getChipId() {
        return chipId;
    }

    public void setChipId(int chipId) {
        this.chipId = chipId;
    }

    public int getRaceSVid() {
        return raceSVid;
    }

    public void setRaceSVid(int raceSVid) {
        this.raceSVid = raceSVid;
    }

    public int getRaceGid() {
        return raceGid;
    }

    public void setRaceGid(int raceGid) {
        this.raceGid = raceGid;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "idParticipant=" + idParticipant +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", rank='" + rank + '\'' +
                ", deligationId=" + deligationId +
                ", chipId=" + chipId +
                ", raceSVid=" + raceSVid +
                ", raceGid=" + raceGid +
                '}';
    }
}

enum Gender{
    man,
    woman
}

enum Rank{
    first,
    second,
    third,
    firstJunior,
    secondJunior,
    thirdJunior,
    br, // без разряда
    kms,
    ms
}