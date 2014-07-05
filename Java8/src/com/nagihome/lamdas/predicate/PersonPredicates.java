/**
 * 
 */
package com.nagihome.lamdas.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nagihome.lamdas.objs.Person;
import com.nagihome.lamdas.objs.PersonSex;

/**
 * @author Nagi
 *
 */
public class PersonPredicates {

	public static Predicate<Person> isAdultMale() {
		return p -> p.getSex().equals(PersonSex.MALE) && p.getAge() > 20;
	}

	public static Predicate<Person> isAdultFemale() {
		return p -> p.getSex().equals(PersonSex.FEMALE) && p.getAge() > 20;
	}

	public static Predicate<Person> isBoth() {
		return p -> p.getSex().equals(PersonSex.BOTH);
	}

	public static List<Person> filterPeople(List<Person> people,
			Predicate<Person> predicate) {
		return people.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}

}
