package ru.ufa.peshka.entity;

/**
 * связка. участники стартуют парами (по 2 человека)
 */
public class RaceTwain extends Race{

    @Override
    public String toString() {
        return "RaceTwain{" +
                "id=" + getId() +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
