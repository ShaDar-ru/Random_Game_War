package ru.shadar.game;

public class Attack implements UnitAction {
    private String attacker;
    private String name;
    private int attackPower;
    private double factor;
    private double damage;
    private Team targetTeam;
    private Unit target;

    protected Attack(int attackPower, double factor, String damageName) {
        this.attackPower = attackPower;
        this.factor = factor;
        this.damage = attackPower * factor;
        this.name = damageName;
    }

    @Override
    public void setParams(double factor, Team attackTeam, Team targetTeam, String info) {
        this.factor = factor;
        this.targetTeam = targetTeam;
        this.attacker = info;
    }

    @Override
    public void execute() {
        this.damage = this.attackPower * this.factor;
        this.target = targetTeam.getTargetUnit();
        target.setHp(target.getHp() - damage);
        System.out.println(attacker + this.toString());
    }

    @Override
    public String toString() {
        return " нанес "
                + this.damage
                + " урона "
                + this.name
                + " притивнику: "
                + this.target.getFullInfo();
    }
}