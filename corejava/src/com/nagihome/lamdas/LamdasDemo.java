/**
 * 
 */
package com.nagihome.lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author nageswararao
 *
 */
public class LamdasDemo {

	public static void main(String[] args) {

		Consumer<String> consumerTest = LamdasDemo::printNames;

		consumerTest.accept("Nagi Ponnaganti");
		consumerTest.accept("Monika Gutta");

		List<String> names = new ArrayList<String>();
		names.add("Nagi");
		names.add("Moni");

		names.stream().forEach((x) -> {
			printNames(() -> x);
		});
	}

	private static void printNames(String name) {
		System.out.println(String.format("The Name is: %s ", name));
	}

	private static void printNames(Supplier<String> arg) {
		System.out.println("The Short Name is: " + arg.get());
	}

}
