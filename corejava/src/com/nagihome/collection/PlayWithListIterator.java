/**
 * 
 */
package com.nagihome.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author nageswararao
 *
 */
public class PlayWithListIterator {

	static List<String> stringList = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			stringList.add("Hello World " + i);
			System.out.println("Element Added: " + stringList.get(i));
		}

		ListIterator<String> listIterator = stringList.listIterator();

		while (listIterator.hasNext()) {

			if (listIterator.nextIndex() == 4 ) {				
//				stringList.add("Exception will happen");
				System.out.println("The Element: " + listIterator.next());
				break;
			} else {
				System.out.println("Next Element: " + listIterator.next());
			}

		}
		
		listIterator.forEachRemaining(System.out::println);

		
/*		ListIterator<String> newListIterator = stringList.listIterator();
		while (newListIterator.hasNext()) {
			System.out.println("Next Element: " + newListIterator.next());
		}*/

	}

}
