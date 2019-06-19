package ru.ufa.peshka.entity;

import java.util.Comparator;
import java.util.UUID;

public class Stage extends AbstractID {
    private UUID idDistance;
    private int number;
    private String name;
    private String controlTimeMan;
    private String controlTimeWoman;
    private String length; //длина этапа
    private String angle; // крутизна склона, град.
    private String depth; //глубина брода
    private String longLogs; //длина бревна
    private String railAngle; //угол наклона перил
    private String supportHeight; //Высота опоры для закрепления перил "вертикального маятника"

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

    public String getControlTimeMan() {
        return controlTimeMan;
    }

    public void setControlTimeMan(String controlTimeMan) {
        this.controlTimeMan = controlTimeMan;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getLongLogs() {
        return longLogs;
    }

    public void setLongLogs(String longLogs) {
        this.longLogs = longLogs;
    }

    public String getRailAngle() {
        return railAngle;
    }

    public void setRailAngle(String railAngle) {
        this.railAngle = railAngle;
    }

    public String getSupportHeight() {
        return supportHeight;
    }

    public void setSupportHeight(String supportHeight) {
        this.supportHeight = supportHeight;
    }

    public String getControlTimeWoman() {
        return controlTimeWoman;
    }

    public void setControlTimeWoman(String controlTimeWoman) {
        this.controlTimeWoman = controlTimeWoman;
    }

    //стырила потом разберусь как работает
    public static final Comparator<Stage> COMPARE_BY_NUMBER = new Comparator<Stage>() {
        @Override
        public int compare(Stage lhs, Stage rhs) {
            return lhs.getNumber() - rhs.getNumber();
        }
    };
}
