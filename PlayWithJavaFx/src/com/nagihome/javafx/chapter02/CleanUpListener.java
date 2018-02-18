package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CleanUpListener {

    public static void main(String[] args) {

        IntegerProperty counter = new SimpleIntegerProperty(100);
        ChangeListener<Number> changeListener = CleanUpListener::cleanUp;

        counter.addListener(changeListener);

        System.out.println("Changing the counter value to 101");
        counter.set(101);

        System.out.println("Removing the changeListener");
        counter.removeListener(changeListener);

        System.out.println("Changing the counter value to 102");
        counter.set(102);

    }

    private static void cleanUp(ObservableValue<? extends Number> o, Number oldValue, Number newValue) {
        System.out.printf("oldValue: %s, newValue: %s \n", oldValue, newValue);
    }

}
