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
public class FirstAttemptFilter {

	private final static Logger LOGGER = Logger.getLogger(FirstAttemptFilter.class.getSimpleName());

	private List<Apple> filterGreenApples(List<Apple> inventory) {

		LOGGER.info("Filtering apples of size " + inventory.size());

		List<Apple> filteredList = new ArrayList<Apple>();

		for (Apple apple : inventory) {
			if ("Green".equalsIgnoreCase(apple.getColor())) {
				filteredList.add(apple);
			}
		}

		return filteredList;
	}
	
	
	public static void main(String[] args) {
		
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green", new BigDecimal(150.0)));
		apples.add(new Apple("red", new BigDecimal(140.0)));
		apples.add(new Apple("white", new BigDecimal(140.0)));
				
		List<Apple> filterList = new FirstAttemptFilter().filterGreenApples(apples);
		
		LOGGER.info("filteredList Size: " + filterList.size());
				
	}

}
