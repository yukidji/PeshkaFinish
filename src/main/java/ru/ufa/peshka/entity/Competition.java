package ru.ufa.peshka.entity;

public class Competition extends AbstractID{
    private String name;
    private String place;
    private String startDay;
    private String stopDay;
    private String nameJudge;
    private String nameSecretary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStopDay() {
        return stopDay;
    }

    public void setStopDay(String stopDay) {
        this.stopDay = stopDay;
    }

    public String getNameJudge() {
        return nameJudge;
    }

    public void setNameJudge(String nameJudge) {
        this.nameJudge = nameJudge;
    }

    public String getNameSecretary() {
        return nameSecretary;
    }

    public void setNameSecretary(String nameSecretary) {
        this.nameSecretary = nameSecretary;
    }


}
