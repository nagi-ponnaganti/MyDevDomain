package com.nagihome.javafx.chapter02;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class InvalidatedTest {

    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(100);
        counter.addListener(InvalidatedTest::invalidated);

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

    private static void invalidated(Observable o) {
        System.out.println("The Value is Invalidated: ");
    }

}
