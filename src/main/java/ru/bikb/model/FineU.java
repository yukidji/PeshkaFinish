package ru.bikb.model;
/**
 * штрафы участника (личка. участник стартовал один)
 */
public class FineU extends Fine{
    /**
     * идентификационный номер штрафа
     */
    private int idFineU;
    /**
     * идентификационный номер забега участника
     */
    private int idRaceU;

    public int getIdFineU() {
        return idFineU;
    }

    public void setIdFineU(int idFineU) {
        this.idFineU = idFineU;
    }

    public int getIdRaceU() {
        return idRaceU;
    }

    public void setIdRaceU(int idRaceU) {
        this.idRaceU = idRaceU;
    }

    @Override
    public String toString() {
        return "FineU{" +
                "idFineU=" + idFineU +
                ", idRaceU=" + idRaceU +
                '}';
    }
}
