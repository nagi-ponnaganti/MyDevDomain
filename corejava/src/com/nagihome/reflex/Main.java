package com.nagihome.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String args[]) throws Exception {

		Customer nagi = new Customer();

		System.out.println(String.format("The Canonical Name is: %s ", nagi
				.getClass().getCanonicalName()));

		System.out.println(String.format("The Name of a class is: %s ", nagi
				.getClass().getSimpleName()));

		Method[] methods = nagi.getClass().getMethods();

		for (Method m : methods) {
			System.out.println(m.getName());
		}
		new Main().printConstructorArgs();

	}

	@SuppressWarnings("unchecked")
	public void printConstructorArgs() throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Customer cust = new Customer();

		Constructor<Customer>[] cons = (Constructor<Customer>[]) cust
				.getClass().getConstructors();

		System.out.println(cons[0].newInstance());

	}
}
