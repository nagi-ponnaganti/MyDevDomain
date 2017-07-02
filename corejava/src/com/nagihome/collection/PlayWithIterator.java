/**
 * 
 */
package com.nagihome.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author nageswararao
 *
 */
public class PlayWithIterator {

	static List<String> stringList = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			stringList.add("Hello World " + i);
			System.out.println("Element Added: " + stringList.get(i));
		}
		
		Iterator<String> iterator = stringList.iterator();
		while(iterator.hasNext()) {			
			iterator.forEachRemaining(System.out::println);			
		}
		
		for (int i = 0; i < stringList.size(); i++) {
			if(i == 4) {
				stringList.remove(i);				
			}			
			System.out.println("Element Added: " + stringList.get(i));
		}
		
		for (int i = 0; i < stringList.size(); i++) {
			if(i == 4) {
				stringList.add("New Elemment");			
			}			
			System.out.println("Element Added: " + stringList.get(i));
		}
	}

}
