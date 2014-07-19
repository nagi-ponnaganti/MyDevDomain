/**
 * 
 */
package com.nagihome.mockito;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

/**
 * @author Nagi
 *
 */
public class PlayVerify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("unchecked")
		List<String> mockedList = mock(List.class);
		
		mockedList.add("Nagi");
		mockedList.clear();
		
		verify(mockedList).add("Nagi");
		verify(mockedList).clear();
	}
 
}
