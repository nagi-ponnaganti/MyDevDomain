package com.nagihome.javafx.chapter02;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Item {

    private DoubleProperty weight;
    private double _weight = 0.0D;

    private double getWeight() {
        return (weight == null) ? _weight : weight.get();
    }

    private void setWeight(double newWeight) {
        if (weight == null) {
            _weight = newWeight;
        } else {
            weight.set(newWeight);
        }
    }

    private DoubleProperty weightProperty() {
        return (weight != null) ? weight : new SimpleDoubleProperty(this, "weight", _weight);
    }

}
