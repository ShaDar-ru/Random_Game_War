package ru.shadar.game;

public class Human implements Race {
    private static final String NAME = "Человек";
    private static final int M_ATTACK = 4;
    private static final int ARCH_LONG_ATTACK = 5;
    private static final int ARCH_SHORT_ATTACK = 3;
    private static final int WAR_ATTACK = 18;

    @Override
    public int getArchLongAttack() {
        return ARCH_LONG_ATTACK;
    }

    @Override
    public int getArchShortAttack() {
        return ARCH_SHORT_ATTACK;
    }

    @Override
    public int getMAttack() {
        return M_ATTACK;
    }

    @Override
    public String getName() {
        return Human.NAME;
    }

    @Override
    public int getWarAttack() {
        return WAR_ATTACK;
    }

    @Override
    public String toString() {
        return Human.NAME;
    }
}