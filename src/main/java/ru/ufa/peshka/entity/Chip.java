package ru.ufa.peshka.entity;
/**
 * чип участника для регистрации времени на старте и финише
 */
public class Chip {
    /**
     * идентификационный номер чипа
     */
    private int id;
    /**
     * статус чипа (свободен, не свободен) определяет занят чип кем-то или нет
     */
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}

