package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * штрафы участника (личка. участник стартовал один)
 */
public class FineSingle extends Fine{

    /**
     * идентификационный номер забега участника
     */
    private UUID RaceSingleId;

    public UUID getRaceSingleId() {
        return RaceSingleId;
    }

    public void setRaceSingleId(UUID RaceSingleId) {
        this.RaceSingleId = RaceSingleId;
    }

    @Override
    public String toString() {
        return "FineSingle{" +
                "id=" + getId() +
                ", RaceSingleId =" + RaceSingleId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
