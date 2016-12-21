/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author nageswararao
 *
 */
public class ConsumerFunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Consumer<Integer> intConsumer = i -> System.out.print(" " + i);
		Consumer<Integer> intConsumerAndThen = intConsumer.andThen(i -> System.out.print(" (Print: " + i + ")"));

		List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(10), new Integer(200), new Integer(101),
				new Integer(-10), new Integer(0));

		printList(integerList, intConsumerAndThen);
	}

	private static void printList(List<Integer> intList, Consumer<Integer> intConsumer) {

		for (Integer i : intList) {
			intConsumer.accept(i);
		}
	}

}
