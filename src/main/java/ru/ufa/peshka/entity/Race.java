package ru.ufa.peshka.entity;
/**
 * абстрактный класс - забег участников
 */
public abstract class Race extends AbstractID {
    /**
     * класс дистанции
     */
    private CLASS_DISTANCE classDistance;
    /**
     * время старта
     */
    private String timeStart;
    /**
     * время финиша
     */
    private String timeFinish;


    //***************************************************

    public CLASS_DISTANCE getClassDistance() {
        return classDistance;
    }

    public void setClassDistance(CLASS_DISTANCE classDistance) {
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