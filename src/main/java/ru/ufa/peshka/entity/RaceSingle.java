package ru.ufa.peshka.entity;
/**
 * личка. участник стартует один
 */
public class RaceSingle extends Race{

    /**
     * идентификационный номер участника, нужно ли его наследовать от
     * класса Participant (участник)?
     */
    private int idParticipant;

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }


    @Override
    public String toString() {
        return "RaceSingle{" +
                "id=" + getId() +
                ", idParticipant=" + idParticipant +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
