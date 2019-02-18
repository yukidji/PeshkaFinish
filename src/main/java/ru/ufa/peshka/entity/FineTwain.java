package ru.ufa.peshka.entity;
/**
 * штрафы связки (участники стартуют парами/по 2 человека)
 */
public class FineTwain extends Fine{
    /**
     * идентификационный номер штрафа
     */
    private int id;
    /**
     * идентификационный номер забега связки
     */
    private int RaceTwainId;

    public int getId() {
        return id;
    }

    public void setId(int idFineSV) {
        this.id = idFineSV;
    }

    public int getRaceTwainId() {
        return RaceTwainId;
    }

    public void setRaceTwainId(int RaceTwainId) {
        this.RaceTwainId = RaceTwainId;
    }

    @Override
    public int getNumberStage() {
        return super.getNumberStage();
    }

    @Override
    public void setNumberStage(int numberStage) {
        super.setNumberStage(numberStage);
    }

    @Override
    public int getFine() {
        return super.getFine();
    }

    @Override
    public void setFine(int fine) {
        super.setFine(fine);
    }

    @Override
    public boolean getCut() {
        return super.getCut();
    }

    @Override
    public void setCut(boolean cut) {
        super.setCut(cut);
    }

    @Override
    public String toString() {
        return "FineTwain{" +
                "id=" + id +
                ", idRaceSV=" + RaceTwainId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
