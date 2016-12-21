/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author nageswararao
 *
 */
public class BiConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");

		BiConsumer<Integer, String> biConsumer = (K, V) -> System.out.println("Key: " + K + " Value: " + V);

		map.forEach(biConsumer);
	}

}
