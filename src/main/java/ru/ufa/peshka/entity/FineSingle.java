package ru.ufa.peshka.entity;
/**
 * штрафы участника (личка. участник стартовал один)
 */
public class FineSingle extends Fine{
    /**
     * идентификационный номер штрафа
     */
    private int id;
    /**
     * идентификационный номер забега участника
     */
    private int RaceSingleId;

    public int getId() {
        return id;
    }

    public void setId(int idFineU) {
        this.id = idFineU;
    }

    public int getRaceSingleId() {
        return RaceSingleId;
    }

    public void setRaceSingleId(int RaceSingleId) {
        this.RaceSingleId = RaceSingleId;
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
        return "FineSingle{" +
                "id=" + id +
                ", RaceSingleId =" + RaceSingleId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
