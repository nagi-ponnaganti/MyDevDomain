/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author nageswararao
 *
 */
public class MethodReferencesExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);

		System.out.println("Prime Numbers are "
				+ MethodReferencesExample.findPrimeNumberList(numbers, MethodReferencesExample::isPrime));

		List<Integer> numbersList = Arrays.asList(4, 9, 16, 25, 36);

		System.out.println("After Square root Numbers are "
				+ MethodReferencesExample.listTheSquareRoots(numbersList, Integer::new));

		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Albert", 80));
		persons.add(new Person("Ben", 15));
		persons.add(new Person("Charlote", 20));
		persons.add(new Person("Dean", 6));
		persons.add(new Person("Elaine", 17));

		System.out.println("List All Ages: " + MethodReferencesExample.listAllAges(persons, Person::getAge));
	}

	private static List<Integer> findPrimeNumberList(List<Integer> numList, Predicate<Integer> p) {

		List<Integer> primeInts = new ArrayList<Integer>();

		primeInts = numList.stream().filter(p).collect(Collectors.toList());

		return primeInts;
	}

	private static boolean isPrime(Integer num) {

		if (num == null || num == 1) {
			return false;
		} else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					return false;
				}
			}
		}

		return true;
	}

	private static List<Integer> listTheSquareRoots(List<Integer> input, Function<Integer, Integer> func) {
		List<Integer> result = new ArrayList<Integer>();

		input.forEach(x -> result.add((int) Math.sqrt(func.apply(x))));

		return result;
	}

	private static List<Integer> listAllAges(List<Person> people, Function<Person, Integer> func) {
		List<Integer> ages = new ArrayList<Integer>();
		people.forEach(p -> ages.add(func.apply(p)));
		return ages;
	}

	private static class Person {

		private final String name;
		private final int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;

		}

		@SuppressWarnings("unused")
		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

	}
}
