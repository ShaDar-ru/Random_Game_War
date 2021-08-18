package ru.shadar.game;

public interface UnitAction {

    String toString();

    void setParams(double factor, Team attackTeam, Team targetTeam, String info);

    void execute();
}