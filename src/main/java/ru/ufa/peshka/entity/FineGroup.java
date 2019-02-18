package ru.ufa.peshka.entity;

/**
 * штрафы группы (стартуют 4 человека)
 */
public class FineGroup extends Fine {

    /**
     * идентификационный номер забега группы (как его можно унаследовать
     * от RaceGroup или сделать наследование в другую сторону? или этого делать вообще не надо)
     * но наследвать в другу сторону думаю бесмысленно так как тот класс это забег какойто
     * группы и за этот один забег они могут получить несколько штрафов, т.е
     * будет созданно несколько экземплров классов FineGroup с разными id но они будут
     * относится к одному забегу т.е. поле raceGroupId будет у нескольких экзмепляров
     * этого класса одинаковые, но номера этапов разные соответственно.
     */
    private int raceGroupId;

    public int getRaceGroupId() {
        return raceGroupId;
    }

    public void setRaceGroupId(int raceGroupId) {
        this.raceGroupId = raceGroupId;
    }

    @Override
    public String toString() {
        return "FineGroup{" +
                "id=" + getId() +
                ", raceGroupId =" + raceGroupId +
                ", numberStage=" + getNumberStage()+
                ", fine=" + getFine()+
                ", cut=" + getCut()+
                '}';
    }
}
