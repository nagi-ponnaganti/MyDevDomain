/**
 * 
 */
package com.nagihome.mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Nagi
 *
 */
public class PlayWithVerify {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<String> mockList01 = mock(ArrayList.class);
		List<String> mockList02 = mock(ArrayList.class);
		List<String> mockList03 = mock(ArrayList.class);

		
		mockList01.add("one");

		mockList01.add("two");
		mockList01.add("two");

		mockList01.add("three");
		mockList01.add("three");
		mockList01.add("three");

		verify(mockList01, times(1)).add("one");
		verify(mockList01, times(2)).add("two");
		verify(mockList01, times(3)).add("three");

		verify(mockList01, atLeastOnce()).add("two");
		verify(mockList01, never()).add("never");
		verify(mockList01, atMost(2)).add("two");

		/*
		 * InOrder inOrder = inOrder(mockList);
		 * 
		 * inOrder.verify(mockList).add("one");
		 * inOrder.verify(mockList).add("two");
		 * inOrder.verify(mockList).add("two");
		 */
		
		verifyZeroInteractions(mockList02, mockList03);

	}
}
