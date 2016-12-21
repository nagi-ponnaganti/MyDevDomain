/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.function.Supplier;

/**
 * @author nageswararao
 *
 */
public class SupplierFunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Supplier<String> stringSupplier = () -> "This is supplier example";
		 * System.out.println("Supplier String: " + stringSupplier.get());
		 */
		SunPower power = new SunPower();

		SunPower p1 = produce(() -> power);
		SunPower p2 = produce(() -> power);

		System.out.println("Comparing Objects: " + p1.equals(p2));

		System.out.println(maker(Employee::new));

	}

	private static SunPower produce(Supplier<SunPower> supplier) {
		return supplier.get();
	}

	private static Employee maker(Supplier<Employee> fx) {
		return fx.get();
	}

	static class SunPower {
		public SunPower() {
			System.out.println("Sun Power Instance is Initiated");
		}
	}

	static class Employee {
		@Override
		public String toString() {
			return "A EMPLOYEE";
		}
	}

}
