package ru.ufa.peshka.entity;
/**
 * штрафы участника (личка. участник стартовал один)
 */
public class FineSingle extends Fine{

    /**
     * идентификационный номер забега участника
     */
    private int RaceSingleId;

    public int getRaceSingleId() {
        return RaceSingleId;
    }

    public void setRaceSingleId(int RaceSingleId) {
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
