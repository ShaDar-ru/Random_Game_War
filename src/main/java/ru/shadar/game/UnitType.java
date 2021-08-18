package ru.shadar.game;

public interface UnitType {

    String getName();

    UnitAction[] createActions(double factor);
}