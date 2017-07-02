/**
 * 
 */
package com.nagihome.patterns.builder;

/**
 * @author nageswararao
 *
 */
public class UserMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(
				new User.UserBuilder("Nagi", "Ponnaganti").address("London").age(30).phone("07507260541").build());

	}

}
