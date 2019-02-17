package ru.bikb.model;
/**
 * чип участника для регистрации времени на старте и финише
 */
public class Chip {
    /**
     * идентификационный номер чипа
     */
    private int idChip;
    /**
     * статус чипа (свободен, не свободен) определяет занят чип кем-то или нет
     */
    private Statys statys;

    public int getIdChip() {
        return idChip;
    }

    public void setIdChip(int idChip) {
        this.idChip = idChip;
    }

    public Statys getStatys() {
        return statys;
    }

    public void setStatys(Statys statys) {
        this.statys = statys;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "idChip=" + idChip +
                ", statys='" + statys + '\'' +
                '}';
    }
}

enum Statys {
    free,
    notFree
}
