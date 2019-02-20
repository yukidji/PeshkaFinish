package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * штрафы участника (личка. участник стартовал один)
 */
public class FineSingle extends Fine{

    /**
     * идентификационный номер забега участника
     */
    private UUID raceSingleId;

    public UUID getRaceSingleId() {
        return raceSingleId;
    }

    public void setRaceSingleId(UUID RaceSingleId) {
        this.raceSingleId = RaceSingleId;
    }

    @Override
    public String toString() {
        return "FineSingle{" +
                "id=" + getId() +
                ", raceSingleId =" + raceSingleId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
