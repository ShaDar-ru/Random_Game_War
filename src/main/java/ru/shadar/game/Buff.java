package ru.shadar.game;

public class Buff implements UnitAction {
    private String buffer;
    private Unit target;
    private Team targetTeam;

    protected Buff() {

    }

    public void setParams(double factor, Team attackTeam, Team targetTeam, String info) {
        this.targetTeam = attackTeam;
        this.buffer = info;
    }

    @Override
    public void execute() {
        this.target = targetTeam.getRegularUnits().getRandomUnit();
        targetTeam.unitBuff(target);
        System.out.println(buffer + this);
    }

    @Override
    public String toString() {
        return " баффнул " + this.target;
    }
}