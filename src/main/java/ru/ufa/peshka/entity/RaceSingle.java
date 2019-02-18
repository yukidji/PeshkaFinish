package ru.ufa.peshka.entity;
/**
 * личка. участник стартует один
 */
public class RaceSingle extends Race{
    /**
     * идентификационный номер забега участника (личка)
     */
    private int id;
    /**
     * идентификационный номер участника
     */
    private int idParticipant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
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
        return "RaceSingle{" +
                "id=" + id +
                ", idParticipant=" + idParticipant +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
