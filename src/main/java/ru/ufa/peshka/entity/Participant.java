package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;

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
     * идентификационный номер делегации участника
     */
    private UUID delegationId;
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

    public UUID getDelegationId() {
        return delegationId;
    }

    public void setDelegationId(UUID delegationId) {
        this.delegationId = delegationId;
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
}