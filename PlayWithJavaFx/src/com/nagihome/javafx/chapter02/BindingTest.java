package com.nagihome.javafx.chapter02;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingTest {

	private static IntegerProperty x = new SimpleIntegerProperty(100);
	private static IntegerProperty y = new SimpleIntegerProperty(101);
	
	public static void main(String[] args) {
		
		NumberBinding sum = x.add(y);
		
		System.out.println("Sum Valid: " + sum.isValid());
		System.out.println("Sum Value: " + sum.intValue());
		
		y.set(201);
		
		System.out.println("Sum Valid: " + sum.isValid());
		System.out.println("Sum Value: " + sum.intValue());
		
		y.set(201);
		
		System.out.println("Sum Valid: " + sum.isValid());
		System.out.println("Sum Value: " + sum.intValue());
		
		
	}

}
