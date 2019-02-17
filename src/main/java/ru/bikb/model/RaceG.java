package ru.bikb.model;
/**
 * группа. участники стартуют группой (по 4 человека)
 */
public class RaceG extends Race {
    /**
     * идентификационный номер забега группы
     */
    private int idRaceG;

    public int getIdRaceG() {
        return idRaceG;
    }

    public void setIdRaceG(int idRaceG) {
        this.idRaceG = idRaceG;
    }

    @Override
    public String toString() {
        return "RaceG{" +
                "idRaceG=" + idRaceG +
                '}';
    }
}
