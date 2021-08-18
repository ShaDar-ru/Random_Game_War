package ru.shadar.game;

public class Mage implements UnitType {
    private Race race;
    private String name;
    private String damageName;

    private UnitAction[] unActions = new UnitAction[2];

    protected Mage(Race race) {
        this.race = race;
        this.damageName = "атакой магией";
        if (race instanceof Human) {
            this.name = "Маг";
        } else if (race instanceof Elf) {
            this.name = "Маг";
        } else if (race instanceof Orc) {
            this.name = "Шаман";
        } else if (race instanceof Undead) {
            this.name = "Некромант";
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UnitAction[] createActions(double factor) {
        if (this.race instanceof Human) {
            Buff buff = new Buff();
            unActions[0] = buff;
            Attack attack = new Attack(this.race.getMAttack(), factor, this.damageName);
            unActions[1] = attack;
        } else if (this.race instanceof Elf) {
            Buff buff = new Buff();
            unActions[0] = buff;
            Attack attack = new Attack(this.race.getMAttack(), factor, this.damageName);
            unActions[1] = attack;
        } else if (this.race instanceof Orc) {
            Buff buff = new Buff();
            unActions[0] = buff;
            DeBuff deBuff = new DeBuff();
            unActions[1] = deBuff;
        } else if (this.race instanceof Undead) {
            Curse curse = new Curse();
            unActions[0] = curse;
            Attack attack = new Attack(this.race.getMAttack(), factor, this.damageName);
            unActions[1] = attack;
        }
        return this.unActions;
    }

    @Override
    public String toString() {
        return this.name;
    }
}