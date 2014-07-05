/**
 * 
 */
package com.nagihome.lamdas.predicate;

import java.util.function.Predicate;

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

	public static Predicate<Person> norMaleOrFemale() {
		return p -> p.getSex().equals(PersonSex.BOTH);
	}

}
