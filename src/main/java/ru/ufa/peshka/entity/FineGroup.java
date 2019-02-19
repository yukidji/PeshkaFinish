package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * штрафы группы (стартуют 4 человека)
 */
public class FineGroup extends Fine {

    /**
     * идентификационный номер забега группы
     */
    private UUID raceGroupId;

    public UUID getRaceGroupId() {
        return raceGroupId;
    }

    public void setRaceGroupId(UUID raceGroupId) {
        this.raceGroupId = raceGroupId;
    }

    @Override
    public String toString() {
        return "FineGroup{" +
                "id=" + getId() +
                ", raceGroupId =" + raceGroupId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
