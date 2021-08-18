package ru.shadar.game;

public class Army {
    private final Unit[] units = new Unit[8];
    private int unitsSize = 0;

    protected Unit[] getUnits() {
        return units;
    }

    protected int getUnitsSize() {
        return unitsSize;
    }

    protected void setUnitsSize(int unitsSize) {
        this.unitsSize = unitsSize;
    }

    protected int findUnitIndex(Unit unit) {
        int rsl = -1;
        for (int i = 0; i < this.unitsSize; i++) {
            if (units[i].equals(unit)) {
                rsl = i;
            }
        }
        return rsl;
    }

    protected Unit getUnit(int unitNumber) {
        return this.units[unitNumber];
    }

    protected Unit getRandomUnit() {
        int unitNumber = RandomInput.getInstance().nextInt(unitsSize);
        return this.getUnit(unitNumber);
    }

    protected void minusUnit(int unitPosition) {
        System.arraycopy(
                this.units,
                unitPosition + 1,
                this.units,
                unitPosition,
                this.unitsSize - unitPosition - 1
        );
        this.units[this.unitsSize - 1] = null;
        this.unitsSize--;
    }

    protected void plusUnit(Unit unit) {
        this.units[unitsSize] = unit;
        this.unitsSize++;
    }

    protected void clearUnits() {
        for (int i = this.unitsSize - 1; i >= 0; i--) {
            this.units[i] = null;
        }
        this.unitsSize = 0;
    }
}