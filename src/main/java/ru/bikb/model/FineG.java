package ru.bikb.model;

/**
 * штрафы группы (стартуют 4 человека)
 */
public class FineG extends Fine {
    /**
     * идентификационный номер штрафа
     */
    private int idFineG;
    /**
     * идентификационный номер забега группы
     */
    private int idRaceG;

    public int getIdFineG() {
        return idFineG;
    }

    public void setIdFineG(int idFineG) {
        this.idFineG = idFineG;
    }

    public int getIdRaceG() {
        return idRaceG;
    }

    public void setIdRaceG(int idRaceG) {
        this.idRaceG = idRaceG;
    }

    @Override
    public String toString() {
        return "FineG{" +
                "idFineG=" + idFineG +
                ", idRaceG=" + idRaceG +
                '}';
    }
}
