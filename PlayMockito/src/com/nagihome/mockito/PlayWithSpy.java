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
public class PlayWithSpy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		List<String> spyList = spy(list);

		when(spyList.size()).thenReturn(100);

		spyList.add("Nagi");
		spyList.add("Ponnaganti");

		System.out.println(spyList.size());

		System.out.println(spyList.get(0));
		System.out.println(spyList.get(1));

		verify(spyList).add("Nagi");
		verify(spyList).add("Ponnaganti");

		verify(spyList).get(0);
		verify(spyList).get(1);

		doReturn(" Yes it Can ").when(spyList).get(2);
		// when(spyList.get(2)).thenReturn("Can't be");

	}
}
