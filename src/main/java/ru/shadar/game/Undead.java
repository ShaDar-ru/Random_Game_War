package ru.shadar.game;

public class Undead implements Race {
    private static final String NAME = "Нежить";
    private static final int M_ATTACK = 5;
    private static final int ARCH_LONG_ATTACK = 4;
    private static final int ARCH_SHORT_ATTACK = 2;
    private static final int WAR_ATTACK = 18;

    @Override
    public int getMAttack() {
        return M_ATTACK;
    }

    @Override
    public int getArchLongAttack() {
        return ARCH_LONG_ATTACK;
    }

    @Override
    public int getArchShortAttack() {
        return ARCH_SHORT_ATTACK;
    }

    @Override
    public int getWarAttack() {
        return WAR_ATTACK;
    }

    @Override
    public String getName() {
        return Undead.NAME;
    }

    @Override
    public String toString() {
        return Undead.NAME;
    }
}