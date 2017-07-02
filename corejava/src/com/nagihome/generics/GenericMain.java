/**
 * 
 */
package com.nagihome.generics;

import java.math.BigDecimal;

/**
 * @author nageswararao
 *
 */
public class GenericMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Box<Integer> integerBox = new Box<>();
		integerBox.set(1234);

		Box<String> stringBox = new Box<>();
		stringBox.set("Hello");

		System.out.println("integerBox : " + integerBox.get());
		System.out.println("stringBox : " + stringBox.get());

		Pair<String, Integer> stringIntPair = new OrderedPair<>("Hello", 4);
		Pair<String, String> stringPair = new OrderedPair<>("Hello", "World");

		System.out.println("stringIntPair: " + stringIntPair);
		System.out.println("stringPair: " + stringPair);

		Pair<Integer, String> p1 = new OrderedPair<>(1, "Hello");
		Pair<Integer, String> p2 = new OrderedPair<>(2, "Hello");

		System.out.println("Generic Methods: " + GenericUtils.<Integer, String>compare(p1, p2));

		System.out.println("Bounded Generic Types: "
				+ GenericUtils.compareOnlyToIntLevel(new BigDecimal(22.22), new BigDecimal(22.2234)));

		System.out.println("Bounded Generic Types: " + GenericUtils.<Integer, Integer>compareOnlyToIntLevel(22, 22));

	}

}
