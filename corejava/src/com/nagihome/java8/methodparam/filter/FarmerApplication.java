/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nageswararao
 *
 */
public class FarmerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Apple> input = new ArrayList<Apple>();
		input.add(new Apple("green", new BigDecimal("151.4")));
		input.add(new Apple("blue", new BigDecimal("153.7")));
		input.add(new Apple("green", new BigDecimal("145.4")));
		input.add(new Apple("red", new BigDecimal("142.1")));

		new FarmerApplication().filterApples(input, new AppleGreenColorPredicate());
		new FarmerApplication().filterApples(input, new AppleWeightPredicate());

		new FarmerApplication().filterApples(input, (Apple apple) -> "red".equalsIgnoreCase(apple.getColor()));

		input.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

		System.out.println("After Sorting:");
		input.forEach((Apple a) -> System.out.println(a));

	}

	public List<Apple> filterApples(List<Apple> input, ApplePredicate predicate) {

		List<Apple> result = new ArrayList<Apple>();

		for (Apple apple : input) {

			if (predicate.check(apple)) {
				System.out.println("Apple: " + apple);
				result.add(apple);
			}
		}

		return result;

	}
}

interface ApplePredicate {
	boolean check(Apple apple);
}

class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean check(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}
}

class AppleWeightPredicate implements ApplePredicate {

	@Override
	public boolean check(Apple apple) {
		return apple.getWeight().floatValue() > 150.0;
	}
}
