package ru.shadar.game;

public class Elf implements Race {
    private static final String NAME = "Эльф";
    private static final int M_ATTACK = 10;
    private static final int ARCH_LONG_ATTACK = 7;
    private static final int ARCH_SHORT_ATTACK = 3;
    private static final int WAR_ATTACK = 15;

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
        return Elf.NAME;
    }

    @Override
    public String toString() {
        return Elf.NAME;
    }
}