package com.nagihome.javafx.chapter02;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BiDirectionalBindTest {

	public static void main(String[] args) {
		
		IntegerProperty x = new SimpleIntegerProperty(1);
		IntegerProperty y = new SimpleIntegerProperty(2);
		IntegerProperty z = new SimpleIntegerProperty(3);

		System.out.format("(x,y,z):(%d,%d,%d)", x.intValue(), y.intValue(), z.intValue());
		System.out.println("binding x with y");
		x.bindBidirectional(y);
		System.out.println("binding x with z");
		x.bindBidirectional(z);
		
		System.out.println("setting x value to 4");
		x.set(4);
		System.out.format("(x,y,z):(%d,%d,%d)", x.intValue(), y.intValue(), z.intValue());
		
		System.out.println("Unbinding y,z");
		x.unbindBidirectional(y);
		x.unbindBidirectional(z);
		
		System.out.println("setting x value to 5");
		x.set(5);
		System.out.format("(x,y,z):(%d,%d,%d)", x.intValue(), y.intValue(), z.intValue());
						
		
	}

}
