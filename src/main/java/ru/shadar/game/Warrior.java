package ru.shadar.game;

public class Warrior implements UnitType {
    private Race race;
    private String name;
    private String damage;

    private UnitAction[] unActions = new UnitAction[2];

    protected Warrior(Race race) {
        this.race = race;
        if (race instanceof Human) {
            this.name = "Воин";
            this.damage = "атакой мечем";
        } else if (race instanceof Elf) {
            this.name = "Воин";
            this.damage = "атакой мечем";
        } else if (race instanceof Orc) {
            this.name = "Гоблин";
            this.damage = "атакой дубиной";
        } else if (race instanceof Undead) {
            this.name = "Зомби";
            this.damage = "ударом копья";
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UnitAction[] createActions(double factor) {
        Attack attack = new Attack(this.race.getWarAttack(), factor, this.damage);
        unActions[0] = attack;
        unActions[1] = unActions[0];
        return this.unActions;
    }

    @Override
    public String toString() {
        return this.name;
    }
}