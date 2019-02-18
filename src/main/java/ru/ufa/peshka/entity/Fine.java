package ru.ufa.peshka.entity;

/**
 * штрафы участника, полученные за этап на дистанции
 */
public abstract class Fine {
    /**
     * номер этапа
     */
    private int numberStage;
    /**
     * штрафные баллы за этап
     */
    private int fine;
    /**
     * снятие с этапа
     * true - участник не снят с этапа
     * false - участник снят с этапа
     */
    private boolean cut;
    //********************************************


    public int getNumberStage() {
        return numberStage;
    }

    public void setNumberStage(int numberStage) {
        this.numberStage = numberStage;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public boolean getCut() {
        return cut;
    }

    public void setCut(boolean cut) {
        this.cut = cut;
    }

}
