package ru.ufa.peshka.entity;

import ru.ufa.peshka.entity.Enum.StatusChip;

/**
 * чип участника для регистрации времени на старте и финише
 */
public class Chip extends AbstractID {

    /**
     * статус чипа (свободен, не свободен) определяет занят чип кем-то или нет
     */
    private StatusChip status;

    public Chip (){
        this.status = StatusChip.FREE;
    }

    public StatusChip getStatus() {
        return status;
    }

    public void setStatus(StatusChip status) {
        this.status = status;
    }
}

