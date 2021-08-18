package ru.shadar.game;

public class Curse implements UnitAction {
    private String attacker;
    private Unit target;
    private Team targetTeam;


    protected Curse() {

    }

    @Override
    public void setParams(double factor, Team attackTeam, Team targetTeam, String info) {
        this.targetTeam = targetTeam;
        this.attacker = info;
    }

    @Override
    public void execute() {
        this.target = targetTeam.getAllTeamUnits().getRandomUnit();
        targetTeam.unitCurse(target);
        System.out.println(attacker + this);
    }

    @Override
    public String toString() {
        return " проклял " + this.target;
    }
}