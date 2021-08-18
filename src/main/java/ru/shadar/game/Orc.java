package ru.shadar.game;

public class Orc implements Race {
    private static final String NAME = "Орк";
    private static final int ARCH_LONG_ATTACK = 3;
    private static final int ARCH_SHORT_ATTACK = 2;
    private static final int WAR_ATTACK = 20;

    @Override
    public int getMAttack() {
        return 0;
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
        return Orc.NAME;
    }

    @Override
    public String toString() {
        return Orc.NAME;
    }
}