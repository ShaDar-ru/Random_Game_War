package ru.shadar.game;

public class Unit {
    private final RandomInput rnd = RandomInput.getInstance();
    private double hp = 100;
    private double factor = 1.0;
    private boolean isActive = false;
    private boolean isBuffed = false;
    private boolean isDeBuffed = false;
    private boolean isCursed = false;

    private String name;
    private UnitAction[] unitActions;

    protected Unit(Race race, UnitType unitType) {
        this.name = race.getName() + "-" + unitType.getName();
        this.unitActions = unitType.createActions(this.factor);
    }

    protected void setFactor(double factor) {
        this.factor = factor;
    }

    protected boolean getActive() {
        return isActive;
    }

    protected void setActive(boolean bool) {
        this.isActive = bool;
    }

    protected boolean getBuffed() {
        return isBuffed;
    }

    protected void setBuffed(boolean buffed) {
        this.isBuffed = buffed;
    }

    protected boolean getDeBuffed() {
        return this.isDeBuffed;
    }

    protected void setDeBuffed(boolean deBuffed) {
        this.isDeBuffed = deBuffed;
    }

    protected boolean getCursed() {
        return this.isCursed;
    }

    protected void setCursed(boolean cursed) {
        this.isCursed = cursed;
    }

    protected void setClear() {
        this.setFactor(1);
        this.setBuffed(false);
        this.setCursed(false);
        this.setDeBuffed(false);
    }

    protected double getHp() {
        return this.hp;
    }

    protected void setHp(double hp) {
        this.hp = hp;
    }


    protected UnitAction getUnitAction(Team attackTeam, Team targetTeam) {
        int randomAction = rnd.nextInt(2);
        return this.getUnitAction(randomAction, attackTeam, targetTeam);
    }

    private UnitAction getUnitAction(int actionNumber, Team attackTeam, Team targetTeam) {
        UnitAction rsl = this.unitActions[actionNumber];
        rsl.setParams(this.factor, attackTeam, targetTeam, this.toString());
        return rsl;
    }

    private String getHpAsString() {
        return "[" + this.hp + " HP]";
    }

    protected String getFullInfo() {
        StringBuilder stbl = new StringBuilder();
        stbl.append(this.name)
                .append(this.getHpAsString())
                .append(this.getBuffed() ? " под баффом" : "")
                .append(this.getDeBuffed() ? " под дебаффом" : "")
                .append(this.getCursed() ? " проклят" : "");
        return stbl.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }
}