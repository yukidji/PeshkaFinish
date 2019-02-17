package ru.bikb.model;
/**
 * абстрактный класс - забег участников
 */
public abstract class Race {
    /**
     * класс дистанции
     */
    private int classDistance;
    /**
     * время старта
     */
    private String timeStart;
    /**
     * время финиша
     */
    private String timeFinish;
    /**
     * время на дистанции
     */
    private String time;

    //***************************************************

    public int getClassDistance() {
        return classDistance;
    }

    public void setClassDistance(int classDistance) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Race{" +
                "classDistance=" + classDistance +
                ", timeStart='" + timeStart + '\'' +
                ", timeFinish='" + timeFinish + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
