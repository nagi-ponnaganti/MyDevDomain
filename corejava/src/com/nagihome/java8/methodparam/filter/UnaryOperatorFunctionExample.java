/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author nageswararao
 *
 */
public class UnaryOperatorFunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		applyUnaryOperatorToList(i -> i * i, Arrays.asList(new Integer[] { 10, 20, 30, 40, 50 }))
				.forEach(i -> System.out.print(" " + i));

	}

	private static List<Integer> applyUnaryOperatorToList(UnaryOperator<Integer> unaryFun, List<Integer> list) {

		List<Integer> result = new ArrayList<Integer>();

		list.forEach(i -> result.add(unaryFun.apply(i)));

		return result;
	}

}
