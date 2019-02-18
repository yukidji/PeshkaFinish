package ru.ufa.peshka.entity;

/**
 * штрафы группы (стартуют 4 человека)
 */
public class FineGroup extends Fine {
    /**
     * идентификационный номер штрафа
     */
    private int id;
    /**
     * идентификационный номер забега группы
     */
    private int raceGroupId;

    public int getId() {
        return id;
    }

    public void setId(int idFineG) {
        this.id = idFineG;
    }

    public int getRaceGroupId() {
        return raceGroupId;
    }

    public void setRaceGroupId(int raceGroupId) {
        this.raceGroupId = raceGroupId;
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
        return "FineGroup{" +
                "id=" + id +
                ", raceGroupId =" + raceGroupId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
