package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * личка. участник стартует один
 */
public class RaceSingle extends Race{

    /**
     * идентификационный номер участника
     */
    private UUID participantId;

    public UUID getParticipantId() {
        return participantId;
    }

    public void setParticipantId(UUID participantId) {
        this.participantId = participantId;
    }

    @Override
    public String toString() {
        return "RaceSingle{" +
                "id=" + getId() +
                ", participantId=" + participantId +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
