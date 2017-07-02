/**
 * 
 */
package com.nagihome.streams;

import java.util.Arrays;

/**
 * @author nageswararao
 *
 */
public class ParallelStreamMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(e -> {
			System.out.format("filter: %s [%s]\n", e, Thread.currentThread().getName());
			return true;
		}).map(e -> {
			System.out.format("map: %s [%s]\n", e, Thread.currentThread().getName());
			return e.toUpperCase();
		}).forEach(System.out::println);

	}

}
