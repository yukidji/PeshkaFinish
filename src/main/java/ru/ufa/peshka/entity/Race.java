package ru.ufa.peshka.entity;
/**
 * абстрактный класс - забег участников
 */
public abstract class Race extends AbstractID {
    /**
     * класс дистанции (1, 2, 3, 4, 5 класс). стоит ли из этого делать enum?
     */
    private ClassDistance classDistance;
    /**
     * время старта
     */
    private String timeStart;
    /**
     * время финиша
     */
    private String timeFinish;


    //***************************************************

    public ClassDistance getClassDistance() {
        return classDistance;
    }

    public void setClassDistance(ClassDistance classDistance) {
        this.classDistance = classDistance;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

}