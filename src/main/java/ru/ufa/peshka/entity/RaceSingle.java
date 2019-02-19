package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * личка. участник стартует один
 */
public class RaceSingle extends Race{

    /**
     * идентификационный номер участника
     */
    private UUID idParticipant;

    public UUID getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(UUID idParticipant) {
        this.idParticipant = idParticipant;
    }

    @Override
    public String toString() {
        return "RaceSingle{" +
                "id=" + getId() +
                ", idParticipant=" + idParticipant +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
