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
public class PlayWithDo {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<String> mockedList = mock(ArrayList.class);

		// doThrow(new
		// Exception("List can't be cleared")).when(mockedList).clear();

		mockedList.clear();
		mockedList.add("Nagi Ponnaganti");

//		doReturn("Last Element added :").when(mockedList).get(anyInt());
		
		doNothing().when(mockedList).clear();
		
		mockedList.clear();		
	}
}
