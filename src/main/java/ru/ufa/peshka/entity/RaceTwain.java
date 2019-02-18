package ru.ufa.peshka.entity;
/**
 * связка. участники стартуют парами (по 2 человека)
 */
public class RaceTwain extends Race{
    /**
     * идентификационный номер забега связки
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ru.ufa.peshka.entity.classDistance getClassDistance() {
        return super.getClassDistance();
    }

    @Override
    public void setClassDistance(ru.ufa.peshka.entity.classDistance classDistance) {
        super.setClassDistance(classDistance);
    }

    @Override
    public String getTimeStart() {
        return super.getTimeStart();
    }

    @Override
    public void setTimeStart(String timeStart) {
        super.setTimeStart(timeStart);
    }

    @Override
    public String getTimeFinish() {
        return super.getTimeFinish();
    }

    @Override
    public void setTimeFinish(String timeFinish) {
        super.setTimeFinish(timeFinish);
    }

    @Override
    public String toString() {
        return "RaceTwain{" +
                "id=" + id +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
