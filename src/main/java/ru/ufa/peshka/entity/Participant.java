package ru.ufa.peshka.entity;
/**
 * участники соревнований
 */
public class Participant extends Person {
    /**
     * идентификационный номер участника
     */
    private int id;

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
    private int raceTwainId;
    /**
     * идентификационный номер группы участника (забег группы)
     */
    private int raceGroupId;

    //**********************************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getPatronymic() {
        return super.getPatronymic();
    }

    @Override
    public void setPatronymic(String patronymic) {
        super.setPatronymic(patronymic);
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

    public int getRaceTwainId() {
        return raceTwainId;
    }

    public void setRaceTwainId(int raceTwainId) {
        this.raceTwainId = raceTwainId;
    }

    public int getRaceGroupId() {
        return raceGroupId;
    }

    public void setRaceGroupId(int raceGroupId) {
        this.raceGroupId = raceGroupId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", patronymic='" + getLastName() + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", rank='" + rank + '\'' +
                ", deligationId=" + deligationId +
                ", chipId=" + chipId +
                ", raceTwainId=" + raceTwainId +
                ", raceGroupId=" + raceGroupId +
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