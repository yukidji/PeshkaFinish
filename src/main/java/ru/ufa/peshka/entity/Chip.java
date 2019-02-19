package ru.ufa.peshka.entity;
/**
 * чип участника для регистрации времени на старте и финише
 */
public class Chip  extends AbstractID{

    /**
     * статус чипа (свободен, не свободен) определяет занят чип кем-то или нет
     */
    private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "id=" + getId() +
                ", status='" + status + '\'' +
                '}';
    }
}

