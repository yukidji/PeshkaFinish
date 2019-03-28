package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.ClassDistance;
import ru.ufa.peshka.entity.Enum.TypeDistance;

import java.util.UUID;

public class Distance extends AbstractID {

    private UUID idCompetition;
    private ClassDistance classDist;
    private int numberStage;
    private TypeDistance typeDistance;

    public UUID getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(UUID idCompetition) {
        this.idCompetition = idCompetition;
    }

    public ClassDistance getClassDist() {
        return classDist;
    }

    public void setClassDist(ClassDistance classDist) {
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
}
