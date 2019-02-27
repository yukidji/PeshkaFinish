package ru.ufa.peshka.entity;

/**
 * интерфейс идентификационного номера
 */
import java.util.UUID;

public interface ID {
    UUID getId ();
    void setId(UUID id);
    String toString();
}
