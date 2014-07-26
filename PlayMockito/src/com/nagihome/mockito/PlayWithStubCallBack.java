/**
 * 
 */
package com.nagihome.mockito;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * @author Nagi
 *
 */
public class PlayWithStubCallBack {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<String> mockList = mock(ArrayList.class);
		mockList.add("Nagi");

		when(mockList.get(anyInt())).thenAnswer(new Answer<String>() {

			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Object mockObj = invocation.getMock();

				return "The element added to: " + mockObj + " is: " + args.toString();
			}
		});
		
		System.out.println(mockList.get(0));
	}

}
