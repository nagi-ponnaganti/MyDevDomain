/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.function.BiFunction;

/**
 * @author nageswararao
 *
 */
public class BiFunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiFunction<Integer, Integer, String> biFunction = (i1, i2) -> "The Divide Of: " + i1 / i2;
		System.out.println(biFunction.apply(13, 12));
	}

}
