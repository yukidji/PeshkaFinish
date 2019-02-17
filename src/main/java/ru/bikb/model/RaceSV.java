package ru.bikb.model;
/**
 * связка. участники стартуют парами (по 2 человека)
 */
public class RaceSV extends Race{
    /**
     * идентификационный номер забега связки
     */
    private int idRaceSV;

    public int getIdRaceSV() {
        return idRaceSV;
    }

    public void setIdRaceSV(int idRaceSV) {
        this.idRaceSV = idRaceSV;
    }

    @Override
    public String toString() {
        return "RaceSV{" +
                "idRaceSV=" + idRaceSV +
                '}';
    }
}
