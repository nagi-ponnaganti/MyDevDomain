/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.function.BiPredicate;

/**
 * @author nageswararao
 *
 */
public class BiPredicateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		BiPredicate<Integer, Integer> eq = (x, y) -> x - 2 > y;
		
		System.out.println("bi.test(8, 3): " + bi.test(8, 3));
		System.out.println("bi.or(eq).test(8, 3): " + bi.or(eq).test(3, 8));
		
	}

}
