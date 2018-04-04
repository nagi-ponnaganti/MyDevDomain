package com.nagihome.hfdp.ch03;

public abstract class Beverage {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    @Override
    public String toString() {
        return "Beverage{" +
                "description='" + getDescription() + '\'' +
                ",cost='" + cost() + '\'' +
                '}';
    }
}
