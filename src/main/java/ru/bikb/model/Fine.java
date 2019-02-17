package ru.bikb.model;

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
     * снятие с этапа (да/нет; снят/не снят с этапа
     * true - не снят с этапа
     * false - снят с этапа)
     */
    private boolean sn;
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

    public boolean isSn() {
        return sn;
    }

    public void setSn(boolean sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "numberStage=" + numberStage +
                ", fine=" + fine +
                ", sn=" + sn +
                '}';
    }
}
