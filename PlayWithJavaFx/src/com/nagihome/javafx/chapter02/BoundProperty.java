package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BoundProperty {

	public static void main(String[] args) {
		IntegerProperty x = new SimpleIntegerProperty(10);
		IntegerProperty y = new SimpleIntegerProperty(20);
		IntegerProperty z = new SimpleIntegerProperty(50);

		z.bind(x.add(y));

		System.out.format("z is bound: %s, and values are (x,y,z):(%d,%d,%d)\n", z.isBound(), x.intValue(),
				y.intValue(), z.intValue());

		System.out.println("changing x and y values");
		x.set(15);
		y.set(25);

		System.out.format("z is bound: %s, and values are (x,y,z):(%d,%d,%d)\n", z.isBound(), x.intValue(),
				y.intValue(), z.intValue());

		System.out.println("unbinding z");
		z.unbind();

		System.out.println("changing x and y values");
		x.set(12);
		y.set(22);

		System.out.format("z is bound: %s, and values are (x,y,z):(%d,%d,%d)\n", z.isBound(), x.intValue(),
				y.intValue(), z.intValue());

	}

}
