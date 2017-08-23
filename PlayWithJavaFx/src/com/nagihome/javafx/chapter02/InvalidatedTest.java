package com.nagihome.javafx.chapter02;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InvalidatedTest {

	public static void main(String[] args) {
		
		IntegerProperty counter = new SimpleIntegerProperty(100);
		counter.addListener(InvalidatedTest::invalidated);
		
		System.out.println("setting new value to counter 1");
		counter.set(101);
		
		System.out.println("setting new value to counter 2");
		counter.set(102);
		
		System.out.println("getting value from counter: " + counter.get());
		
		System.out.println("setting new value to counter 3");
		counter.set(102);
		
		System.out.println("setting new value to counter 4");
		counter.set(103);
		
	}
	
	public static void invalidated(Observable prop) {
		System.out.println("Property InValidated");
	}

}
