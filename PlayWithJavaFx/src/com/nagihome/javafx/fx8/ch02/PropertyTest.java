package com.nagihome.javafx.fx8.ch02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyTest {

    public static void main(String[] args) {

        IntegerProperty counter = new SimpleIntegerProperty(300);
        System.out.printf("Integer Property Value: %s \n", counter.getValue());
        counter.setValue(301);
        System.out.printf("Integer Property Value After Increment: %s \n", counter.getValue());

        ReadOnlyIntegerWrapper iWrapper = new ReadOnlyIntegerWrapper(100);
        ReadOnlyIntegerProperty iProperty = iWrapper.getReadOnlyProperty();

        System.out.printf("iWrapper: %s, iProperty: %s\n", iWrapper.get(), iProperty.get());

        iWrapper.set(101);
        System.out.printf("iWrapper: %s, iProperty: %s\n", iWrapper.get(), iProperty.get());


    }

}
