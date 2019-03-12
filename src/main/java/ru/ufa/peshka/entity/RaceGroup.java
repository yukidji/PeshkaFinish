package ru.ufa.peshka.entity;

/**
 * группа. участники стартуют группой (по 4 человека)
 */
public class RaceGroup extends Race {

    @Override
    public String toString() {
        return "RaceGroup{" +
                "id=" + getId() +
                "classDistance=" + getClassDistance() +
                "timeStart=" + getTimeStart() +
                "timeFinish=" + getTimeFinish() +
                '}';
    }
}
