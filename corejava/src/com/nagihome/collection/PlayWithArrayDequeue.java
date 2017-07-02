/**
 * 
 */
package com.nagihome.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nageswararao
 *
 */
public class PlayWithArrayDequeue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayDeque<String> arrayDequeue = new ArrayDeque<String>();
		System.out.println("Size of dequeue: " + arrayDequeue.size());
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		arrayDequeue = new ArrayDeque<String>(list);
		
		System.out.println("Dequeue: " + arrayDequeue);
		
		arrayDequeue = new ArrayDeque<String>(10);
		arrayDequeue.addAll(list);
		System.out.println("Dequeue queue size: " + arrayDequeue.size());
		
	}

}
