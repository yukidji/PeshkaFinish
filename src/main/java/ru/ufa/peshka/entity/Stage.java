package ru.ufa.peshka.entity;

import java.util.Comparator;
import java.util.UUID;

public class Stage extends AbstractID {
    private UUID idDistance;
    private int number;
    private String name;
    private String controlTime;

    public UUID getIdDistance() {
        return idDistance;
    }

    public void setIdDistance(UUID idDistance) {
        this.idDistance = idDistance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getControlTime() {
        return controlTime;
    }

    public void setControlTime(String controlTime) {
        this.controlTime = controlTime;
    }

    //стырила потом разберусь как работает
    public static final Comparator<Stage> COMPARE_BY_NUMBER = new Comparator<Stage>() {
        @Override
        public int compare(Stage lhs, Stage rhs) {
            return lhs.getNumber() - rhs.getNumber();
        }
    };
}