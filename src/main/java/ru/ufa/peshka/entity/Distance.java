package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.Enum.TypeDistance;

import java.util.UUID;

public class Distance extends AbstractID {

    private UUID idCompetition;
    private int classDist;
    private int numberStage;
    private TypeDistance typeDistance;
    private String data;

    public UUID getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(UUID idCompetition) {
        this.idCompetition = idCompetition;
    }

    public int getClassDist() {
        return classDist;
    }

    public void setClassDist(int classDist) {
        this.classDist = classDist;
    }

    public int getNumberStage() {
        return numberStage;
    }

    public void setNumberStage(int numberStage) {
        this.numberStage = numberStage;
    }

    public TypeDistance getTypeDistance() {
        return typeDistance;
    }

    public void setTypeDistance(TypeDistance typeDistance) {
        this.typeDistance = typeDistance;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
