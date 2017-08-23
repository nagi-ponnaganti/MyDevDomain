package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeTest {

	public static void main(String[] args) {
		
		IntegerProperty counter = new SimpleIntegerProperty(100);
		counter.addListener(ChangeTest::change);
		
		System.out.println("changeing the counter 1");
		counter.set(101);
		
		System.out.println("changeing the counter 2");
		counter.set(102);
		
		System.out.println("get the counter value: " + counter.get());
		
		System.out.println("changeing the counter 3");
		counter.set(102);

		System.out.println("changeing the counter 4");
		counter.set(103);
		
	}

	public static void change(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
		System.out.println("Counter Changed");
		System.out.format("Prop: %s, oldValue: %d, newValue: %d\n", prop, oldValue, newValue);		
	}

}
