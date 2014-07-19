/**
 * 
 */
package com.nagihome.mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author Nagi
 *
 */
public class PlayWithArgmentMatcher {

	static ArgumentCaptor<Person> personArgCaptor;

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<String> mockList = mock(ArrayList.class);

		when(mockList.get(anyInt())).thenReturn("element");

		System.out.println(mockList.get(999));

		verify(mockList).get(999);

		List<String> mockList01 = mock(ArrayList.class);

		when(mockList01.addAll(argThat(new IsListOfTwoElements()))).thenReturn(
				true);

		System.out.println(mockList01.addAll(Arrays.asList(new String[] {
				"Nagi", "Ponnaganti" })));

		verify(mockList01).addAll(argThat(new IsListOfTwoElements()));	

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCaptors() {
		
		List<Person> mockList02 = mock(ArrayList.class);

		Person person = new Person();
		person.setName("Nagi");

		mockList02.add(person);

		personArgCaptor = ArgumentCaptor.forClass(Person.class);
		
		verify(mockList02).add(personArgCaptor.capture());


		assertEquals("Expected My name", "Nagi", personArgCaptor.getValue()
				.getName());

	}

	@SuppressWarnings("rawtypes")
	static class IsListOfTwoElements extends ArgumentMatcher<List> {

		@Override
		public boolean matches(Object argument) {
			return ((List) argument).size() == 2;
		}

	}

	static class Person {

		private String name;

		public void printDetails() {
			System.out.println("name: " + this.name);
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

	}

}
