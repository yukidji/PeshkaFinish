package ru.ufa.peshka.entity;
/**
 * штрафы связки (участники стартуют парами/по 2 человека)
 */
public class FineTwain extends Fine{

    /**
     * идентификационный номер забега связки
     */
    private int RaceTwainId;

    public int getRaceTwainId() {
        return RaceTwainId;
    }

    public void setRaceTwainId(int RaceTwainId) {
        this.RaceTwainId = RaceTwainId;
    }

    @Override
    public String toString() {
        return "FineTwain{" +
                "id=" + getId() +
                ", idRaceSV=" + RaceTwainId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
