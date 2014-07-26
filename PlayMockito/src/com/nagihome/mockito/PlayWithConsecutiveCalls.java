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
public class PlayWithConsecutiveCalls {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<String> mockList = mock(ArrayList.class);

		when(mockList.get(anyInt())).thenReturn("A", "B", "C");
		
		System.out.println(mockList.get(1));
		System.out.println(mockList.get(2));
		System.out.println(mockList.get(3));
		System.out.println(mockList.get(4));
	}
}
