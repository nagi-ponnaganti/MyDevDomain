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
public class PlayWithStub {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {	
		
		List<String> mockedList = mock(ArrayList.class); 
		
		when(mockedList.get(0)).thenReturn("Nagi");
//		when(mockedList.get(1)).thenThrow(new RuntimeException("Not avalible"));
		
		System.out.println(mockedList.get(0));
		System.out.println(mockedList.get(1));
		System.out.println(mockedList.get(999));
		
		verify(mockedList).get(0);
	}

}
