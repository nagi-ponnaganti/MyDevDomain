package com.nagihome.javafx.chapter02;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeAndInvalidationTest {

    public static void main(String[] args) {

        IntegerProperty counter = new SimpleIntegerProperty(100);

        // Add an invalidation listener to the counter property
        counter.addListener(ChangeAndInvalidationTest::invalidated);

        // Add a change listener to the counter property
        counter.addListener(ChangeAndInvalidationTest::changed);

        System.out.println("Before changing the counter value-1");
        counter.set(101);
        System.out.println("After changing the counter value-1");

        System.out.println("\nBefore changing the counter value-2");
        counter.set(102);
        System.out.println("After changing the counter value-2");

        // Try to set the same value
        System.out.println("\nBefore changing the counter value-3");
        counter.set(102);
        System.out.println("After changing the counter value-3");

        // Try to set a different value
        System.out.println("\nBefore changing the counter value-4");
        counter.set(103);
        System.out.println("After changing the counter value-4");

    }


    private static void changed(ObservableValue<? extends Number> o, Number oldValue, Number newValue) {
        System.out.printf("oldValue: %s newValue: %s \n", oldValue, newValue);
    }

    private static void invalidated(Observable o) {
        System.out.println("Counter is Invalidated");
    }
}
