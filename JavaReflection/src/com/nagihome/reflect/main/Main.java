/**
 * 
 */
package com.nagihome.reflect.main;

import java.lang.reflect.Method;

import com.nagihome.reflect.domainobjs.Person;

/**
 * @author Nagi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person = new Person();
		
		Method[] methods = person.getClass().getMethods();
		
		for(int i = 0; i<methods.length;i++){
			System.out.println("Method Name: " + methods[i].getName());
		}

	}

}
