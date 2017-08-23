package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class StrongListener {

	private static IntegerProperty counter = new SimpleIntegerProperty(100);

	public static void main(String[] args) {

		addChangeListener();

		System.out.println("Changing counter value");
		counter.set(101);

	}

	private static void addChangeListener() {
		ChangeListener<Number> listener = StrongListener::change;
		counter.addListener(listener);

	}

	public static void change(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
		System.out.format("oldvalue: %d, newvalue: %d\n", oldValue, newValue);
	}

}
