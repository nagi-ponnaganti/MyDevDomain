/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author nageswararao
 *
 */
public class SecondAttemptFilter {

	private final static Logger LOGGER = Logger.getLogger(SecondAttemptFilter.class.getSimpleName());

	public static void main(String[] args) {

		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green", new BigDecimal(150.0)));
		apples.add(new Apple("red", new BigDecimal(140.0)));
		apples.add(new Apple("white", new BigDecimal(140.0)));
		apples.add(new Apple("white", new BigDecimal(145.0)));

		List<Apple> filterList = new SecondAttemptFilter().filterAppleByColor(apples, "white");

		LOGGER.info("filteredList Size: " + filterList.size());

	}

	public List<Apple> filterAppleByColor(List<Apple> apples, String color) {

		List<Apple> filteredApples = new ArrayList<Apple>();

		for (Apple apple : apples) {

			if (apple.getColor().equalsIgnoreCase(color)) {
				filteredApples.add(apple);
			}
		}

		return filteredApples;
	}

	public List<Apple> filterAppleGreaterThanWeight(List<Apple> apples, BigDecimal weight) {

		List<Apple> filteredApples = new ArrayList<Apple>();

		for (Apple apple : apples) {

			if (apple.getWeight().compareTo(weight) > 0) {
				filteredApples.add(apple);
			}
		}

		return filteredApples;
	}

}
