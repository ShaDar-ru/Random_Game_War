package ru.shadar.game;

public class DeBuff implements UnitAction {
    private String deBuffer;
    private Unit target;
    private Team targetTeam;

    protected DeBuff() {

    }

    @Override
    public void setParams(double factor, Team attackTeam, Team targetTeam, String info) {
        this.targetTeam = targetTeam;
        this.deBuffer = info;
    }

    @Override
    public void execute() {
        if (targetTeam.getBuffedUnits().getUnitsSize() > 0) {
            this.target = targetTeam.getBuffedUnits().getRandomUnit();
            targetTeam.unitDeBuff(target);
            System.out.println(deBuffer + " снял бафф с противника: " + this);
        } else {
            this.target = targetTeam.getRegularUnits().getRandomUnit();
            targetTeam.unitDeBuff(target);
            System.out.println(deBuffer + " лишил возможности быть бафнутым на 1 ход противника: " + this);
        }
    }

    @Override
    public String toString() {
        return this.target.toString();
    }
}