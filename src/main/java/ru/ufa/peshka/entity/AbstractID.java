package ru.ufa.peshka.entity;

/**
 * Генерация уникального id (этот класс должен наследоваться для всех классов
 * где есть необходимость в id? в chip, Participant и так далее...)
 */
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.UUID;

public abstract class AbstractID implements ID {
    private UUID id;

    @Override
    public UUID getId () {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }

    public AbstractID() {
        this.id = UUID.randomUUID();
    }

}
