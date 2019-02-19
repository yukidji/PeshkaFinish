package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * штрафы связки (участники стартуют парами/по 2 человека)
 */
public class FineTwain extends Fine{

    /**
     * идентификационный номер забега связки
     */
    private UUID RaceTwainId;

    public UUID getRaceTwainId() {
        return RaceTwainId;
    }

    public void setRaceTwainId(UUID RaceTwainId) {
        this.RaceTwainId = RaceTwainId;
    }

    @Override
    public String toString() {
        return "FineTwain{" +
                "id=" + getId() +
                ", idRaceSV=" + RaceTwainId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
