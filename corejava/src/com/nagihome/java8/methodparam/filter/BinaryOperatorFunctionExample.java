/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * @author nageswararao
 *
 */
public class BinaryOperatorFunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("X", "A");
		map.put("Y", "B");
		map.put("Z", "C");

		applyBinaryOperatorForList((s1, s2) -> s1 + "_" + s2, map).forEach(s -> System.out.println(" " + s));
	}

	private static List<String> applyBinaryOperatorForList(BinaryOperator<String> binOperator,
			Map<String, String> input) {
		List<String> biList = new ArrayList<String>();
		input.forEach((s1, s2) -> biList.add(binOperator.apply(s1, s2)));
		return biList;
	}

}
