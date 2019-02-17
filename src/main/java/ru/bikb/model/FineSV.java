package ru.bikb.model;
/**
 * штрафы связки (участники стартуют парами/по 2 человека)
 */
public class FineSV extends Fine{
    /**
     * идентификационный номер штрафа
     */
    private int idFineSV;
    /**
     * идентификационный номер забега связки
     */
    private int idRaceSV;

    public int getIdFineSV() {
        return idFineSV;
    }

    public void setIdFineSV(int idFineSV) {
        this.idFineSV = idFineSV;
    }

    public int getIdRaceSV() {
        return idRaceSV;
    }

    public void setIdRaceSV(int idRaceSV) {
        this.idRaceSV = idRaceSV;
    }

    @Override
    public String toString() {
        return "FineSV{" +
                "idFineSV=" + idFineSV +
                ", idRaceSV=" + idRaceSV +
                '}';
    }
}
