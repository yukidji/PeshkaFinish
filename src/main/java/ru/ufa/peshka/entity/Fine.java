package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.Cut;

/**
 * штрафы участника, полученные за этап на дистанции
 */
public abstract class Fine extends AbstractID {
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
     */
    private Cut cut;
    //********************************************

    public Fine(){
        this.cut = Cut.NOT_CUT;
    }

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

    public Cut getCut() {
        return cut;
    }

    public void setCut(Cut cut) {
        this.cut = cut;
    }

}