package ru.ufa.peshka.entity;

import java.util.UUID;

/**
 * штрафы связки (участники стартуют парами/по 2 человека)
 */
public class FineTwain extends Fine{

    /**
     * идентификационный номер забега связки
     */
    private UUID raceTwainId;

    public UUID getRaceTwainId() {
        return raceTwainId;
    }

    public void setRaceTwainId(UUID RaceTwainId) {
        this.raceTwainId = RaceTwainId;
    }
}
