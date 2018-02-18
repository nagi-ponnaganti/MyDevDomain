package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;

public class WeakListener {

    private static IntegerProperty counter = new SimpleIntegerProperty(100);
    public static WeakChangeListener<Number> weakListener;
    private static ChangeListener<Number> changeListener;

    public static void main(String[] args) throws InterruptedException {

        addWeakListener();

        System.out.println("Starting GC 01");
        System.gc();
        System.out.println("weakListener is GC'ed?: " + weakListener.wasGarbageCollected());

        System.out.println("Changing Value to 102");
        counter.set(102);

        System.out.println("Setting Change Listener to Null");
        changeListener = null;

        System.out.println("Starting GC *");
        System.gc();
        System.out.println("weakListener is GC'ed?: " + weakListener.wasGarbageCollected());


        System.out.println("Changing Value to 103");
        counter.set(103);

    }

    private static void addWeakListener() {
        changeListener = WeakListener::changed;
        weakListener = new WeakChangeListener<>(changeListener);
        counter.addListener(weakListener);
        System.out.println("Changing Value to 101");
        counter.set(101);
    }


    private static void changed(ObservableValue<? extends Number> o, Number oldValue, Number newValue) {
        System.out.printf("oldValue: %s newValue: %s \n", oldValue, newValue);
    }

}
