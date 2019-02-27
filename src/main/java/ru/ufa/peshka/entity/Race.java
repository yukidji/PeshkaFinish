package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.ClassDistance;

/**
 * абстрактный класс - забег участников
 */
public abstract class Race extends AbstractID {
    /**
     * класс дистанции
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