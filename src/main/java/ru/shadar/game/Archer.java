package ru.shadar.game;

public class Archer implements UnitType {
    private Race race;
    private String name;
    private String longDamageName;
    private String shortDamageName;

    private UnitAction[] unActions = new UnitAction[2];

    protected Archer(Race race) {
        this.race = race;
        if (this.race instanceof Human) {
            this.name = "Арбалетчик";
            this.longDamageName = "выстрелом из арбалета";
            this.shortDamageName = "атакой";
        } else if (this.race instanceof Elf) {
            this.name = "Лучник";
            this.longDamageName = "выстрелом из лука";
            this.shortDamageName = "атакой";
        } else if (this.race instanceof Orc) {
            this.name = "Лучник";
            this.longDamageName = "выстрелом из лука";
            this.shortDamageName = "атакой";
        } else if (this.race instanceof Undead) {
            this.name = "Охотник";
            this.longDamageName = "выстрелом из лука";
            this.shortDamageName = "атакой";
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UnitAction[] createActions(double factor) {
        Attack longAttack = new Attack(
                this.race.getArchLongAttack(), factor, this.longDamageName
        );
        Attack shortAttack = new Attack(
                this.race.getArchShortAttack(), factor, this.shortDamageName
        );
        unActions[0] = longAttack;
        unActions[1] = shortAttack;
        return this.unActions;
    }

    @Override
    public String toString() {
        return this.name;
    }
}