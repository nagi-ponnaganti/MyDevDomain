package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CleanUpListener {

	public static void main(String[] args) {
		IntegerProperty counter = new SimpleIntegerProperty(100);
		ChangeListener<Number> listener = CleanUpListener::change;
		counter.addListener(listener);
		
		System.out.println("1. Changing the counter value");
		counter.set(101);
		
		counter.removeListener(listener);
		
		System.out.println("2. Changing the counter value");
		counter.set(102);
		
	}

	public static void change(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
		System.out.format("OldValue: %d , NewValue: %d\n", oldValue, newValue);
	}
}
