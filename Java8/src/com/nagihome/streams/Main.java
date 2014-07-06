/**
 * 
 */
package com.nagihome.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nagihome.lamdas.objs.Person;
import com.nagihome.lamdas.objs.PersonSex;
import com.nagihome.lamdas.predicate.PersonPredicates;

/**
 * @author Nagi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person[] {
				new Person("Person01", PersonSex.MALE, 22),
				new Person("Person02", PersonSex.FEMALE, 23),
				new Person("Person03", PersonSex.BOTH, 24),
				new Person("Person04", PersonSex.MALE, 25),
				new Person("Person05", PersonSex.FEMALE, 26),
				new Person("Person06", PersonSex.BOTH, 27) });

		System.out.println(" *** People details *** ");
		people.stream().forEach(p -> System.out.println(p.toString()));

		System.out.println(" *** Male And Female details *** ");
		people.stream()
				.filter(PersonPredicates.isAdultMale().or(
						PersonPredicates.isAdultFemale()))
				.forEach(p -> System.out.println(p.toString()));

		System.out.println("*** Average age of males ***");
		System.out.println(people.stream()
				.filter(PersonPredicates.isAdultMale())
				.mapToInt(Person::getAge).average().getAsDouble());

		System.out.println(" *** sum of all ages ***");
		System.out.println(people.stream().map(Person::getAge)
				.reduce(0, (a, b) -> (a + b)));

		System.out.println("*** Group by function ***");
		System.out.println(people.stream().collect(
				Collectors.groupingBy(Person::getSex)));

	}
}
