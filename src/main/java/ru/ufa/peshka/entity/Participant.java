package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * участники соревнований
 */
public class Participant extends Person {
    /**
     * год рождения участника (1997, 2000 ...)
     */
    private int age;
    /**
     * пол участника (м, ж)
     */
    private Gender gender;
    /**
     * разряд участника (1, 2, 3, 1ю, 2ю, 3ю, б/р, кмс, мс)
     */
    private Rank rank;
    /**
     * идент6а
     */
    private UUID deligationId;
    /**
     * идентификационный номер чипа участника
     */
    private UUID chipId;
    /**
     * идентификационный номер связки участника (забег пары)
     */
    private UUID raceTwainId;
    /**
     * идентификационный номер группы участника (забег группы)
     */
    private UUID raceGroupId;

    //**********************************************************

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

    public UUID getDeligationId() {
        return deligationId;
    }

    public void setDeligationId(UUID deligationId) {
        this.deligationId = deligationId;
    }

    public UUID getChipId() {
        return chipId;
    }

    public void setChipId(UUID chipId) {
        this.chipId = chipId;
    }

    public UUID getRaceTwainId() {
        return raceTwainId;
    }

    public void setRaceTwainId(UUID raceTwainId) {
        this.raceTwainId = raceTwainId;
    }

    public UUID getRaceGroupId() {
        return raceGroupId;
    }

    public void setRaceGroupId(UUID raceGroupId) {
        this.raceGroupId = raceGroupId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + getId() +
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