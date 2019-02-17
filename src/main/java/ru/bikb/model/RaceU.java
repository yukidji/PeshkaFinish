package ru.bikb.model;
/**
 * личка. участник стартует один
 */
public class RaceU extends Race{
    /**
     * идентификационный номер забега участника (личка)
     */
    private int idRaceU;
    /**
     * идентификационный номер участника
     */
    private int idParticipant;

    public int getIdRaceU() {
        return idRaceU;
    }

    public void setIdRaceU(int idRaceU) {
        this.idRaceU = idRaceU;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    @Override
    public String toString() {
        return "RaceU{" +
                "idRaceU=" + idRaceU +
                ", idParticipant=" + idParticipant +
                '}';
    }
}
