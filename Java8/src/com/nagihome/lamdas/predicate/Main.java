/**
 * 
 */
package com.nagihome.lamdas.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.nagihome.lamdas.predicate.PersonPredicates.*;

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

		CheckPerson checker = (Person person) -> {
			return person.getAge() > 20 && person.getAge() < 30
					&& person.getSex().equals(PersonSex.FEMALE);
		};

		printPeople(people, checker);

		printPeople(people, isAdultMale());
		printPeople(people, isAdultFemale());
		printPeople(people, norMaleOrFemale());

	}

	private static void printPeople(List<Person> people, CheckPerson checker) {
		for (Person person : people) {
			if (checker.check(person)) {
				System.out.println("Person Details are: " + person.toString());
			}
		}
	}

	private static void printPeople(List<Person> people,
			Predicate<Person> predicate) {
		for (Person person : people) {
			if (predicate.test(person)) {
				System.out.println("Person Details are: " + person.toString());
			}
		}
	}
}
