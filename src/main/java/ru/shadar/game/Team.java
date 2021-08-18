package ru.shadar.game;

public class Team {

    private Army allTeamUnits = new Army();
    private Army regularUnits = new Army();
    private Army buffedUnits = new Army();
    private Army unitsCanMove = new Army();

    protected Team(Race race) {
        this.createUnitsInAllUnits(race);
        this.createRegularUnits();
    }

    private void createUnitsInAllUnits(Race race) {
        int a = allTeamUnits.getUnitsSize();
        for (int i = 0; i < allTeamUnits.getUnits().length; i++) {
            if (i == 0) {
                Unit unit = new Unit(race, new Mage(race));
                allTeamUnits.getUnits()[i] = unit;
                allTeamUnits.setUnitsSize(++a);
            }
            if (i >= 1 && i <= 3) {
                allTeamUnits.getUnits()[i] = new Unit(race, new Archer(race));
                allTeamUnits.setUnitsSize(++a);
            }
            if (i >= 4 && i <= 7) {
                allTeamUnits.getUnits()[i] = new Unit(race, new Warrior(race));
                allTeamUnits.setUnitsSize(++a);
            }
        }
    }

    private void createRegularUnits() {
        for (int i = 0; i < allTeamUnits.getUnitsSize(); i++) {
            regularUnits.plusUnit(allTeamUnits.getUnit(i));
        }
    }

    protected void createUnitsCanMove() {
        this.clearUnitsCanMove();
        if (this.buffedUnits.getUnitsSize() > 0) {
            this.createBuffedUnitsCanMove();
        }
        if (unitsCanMove.getUnitsSize() <= 0) {
            this.createNotBuffedUnitsCanMove();
        }
    }

    private void clearUnitsCanMove() {
        unitsCanMove.clearUnits();
    }

    private void createBuffedUnitsCanMove() {
        for (Unit un : this.buffedUnits.getUnits()) {
            if (un != null) {
                if (un.getActive()) {
                    this.unitsCanMove.plusUnit(un);
                }
            }
        }
    }

    private void createNotBuffedUnitsCanMove() {
        for (Unit un : this.regularUnits.getUnits()) {
            if (un != null) {
                if (un.getActive()) {
                    this.unitsCanMove.plusUnit(un);
                }
            }
        }
    }

    protected Army getAllTeamUnits() {
        return this.allTeamUnits;
    }

    protected Army getRegularUnits() {
        return this.regularUnits;
    }

    protected Army getBuffedUnits() {
        return this.buffedUnits;
    }

    protected Unit getTargetUnit() {
        return this.allTeamUnits.getRandomUnit();
    }

    protected void setTeamActive() {
        for (int i = 0; i < this.allTeamUnits.getUnitsSize(); i++) {
            allTeamUnits.getUnit(i).setActive(true);
        }
    }

    private boolean getTeamActive() {
        boolean rsl = false;
        for (int i = 0; i < allTeamUnits.getUnitsSize(); i++) {
            if (allTeamUnits.getUnits()[i].getActive()) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    protected boolean isTeamActive() {
        return this.getTeamActive();
    }

    private void unitToBuffed(Unit unit) {
        this.buffedUnits.plusUnit(unit);
        int unitPosition = this.regularUnits.findUnitIndex(unit);
        this.regularUnits.minusUnit(unitPosition);
    }

    private void unitToRegular(Unit unit) {
        this.regularUnits.plusUnit(unit);
        int unitPosition = this.buffedUnits.findUnitIndex(unit);
        this.buffedUnits.minusUnit(unitPosition);
    }

    protected void unitBuff(Unit target) {
        if (!target.getDeBuffed()) {
            target.setBuffed(true);
            target.setFactor(1.5);
            this.unitToBuffed(target);
        } else {
            target.setDeBuffed(false);
        }
    }

    protected void unitDeBuff(Unit target) {
        target.setFactor(1);
        target.setBuffed(false);
        target.setDeBuffed(true);
        if (target.getBuffed()) {
            this.unitToRegular(target);
        }
    }

    protected void unitCurse(Unit target) {
        target.setFactor(0.5);
        target.setCursed(true);
    }

    protected void unitDie() {
        for (int i = 0; i < allTeamUnits.getUnitsSize(); i++) {
            if (allTeamUnits.getUnits()[i].getHp() <= 0) {
                unitDie(i);
            }
        }
    }

    private void unitDie(int unitPos) {
        Unit deadUnit = allTeamUnits.getUnit(unitPos);
        System.out.println(deadUnit + " погиб!");
        allTeamUnits.minusUnit(unitPos);

        int unitPosInBuff = buffedUnits.findUnitIndex(deadUnit);
        if (unitPosInBuff != -1) {
            buffedUnits.minusUnit(unitPosInBuff);
        }

        int unitPosInReg = regularUnits.findUnitIndex(deadUnit);
        if (unitPosInReg != -1) {
            regularUnits.minusUnit(unitPosInReg);
        }
    }


    protected void teamNewUnitMove(Team anotherTeam) {
        this.createUnitsCanMove();
        Unit activeUnit = this.unitsCanMove.getRandomUnit();
        activeUnit.getUnitAction(this, anotherTeam).execute();
        activeUnit.setClear();
        activeUnit.setActive(false);
        if (this.buffedUnits.findUnitIndex(activeUnit) != -1) {
            this.unitToRegular(activeUnit);
        }
    }

    protected boolean isAlive() {
        return allTeamUnits.getUnitsSize() > 0;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < allTeamUnits.getUnitsSize(); i++) {
            stb.append(allTeamUnits.getUnit(i).getFullInfo())
                    .append(System.lineSeparator());
        }
        return stb.toString();
    }

}