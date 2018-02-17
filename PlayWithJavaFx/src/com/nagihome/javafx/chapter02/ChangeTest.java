package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeTest {

    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(100);
        counter.addListener(ChangeTest::changed);
        System.out.println("Changing the counter value to 101");
        counter.set(101);

        System.out.println("Changing the counter value to 102");
        counter.set(102);

        System.out.println("Getting the counter value");
        int temp = counter.get();
        System.out.println("counter temp value: " + temp);

        System.out.println("Changing the counter value to 102");
        counter.set(102);

        System.out.println("Changing the counter value to 103");
        counter.set(103);

    }

    public static void changed(ObservableValue<? extends Number> o, Number oldValue, Number newValue) {
        System.out.printf("Changed: OldValue: %s, NewValue: %s\n", oldValue, newValue);
    }

}
