/**
 * 
 */
package com.nagihome.collection;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @author nageswararao
 *
 */
@RunWith(JUnit4.class)
public class ArrayDequeTest {

	private ArrayDeque<String> arrayDeque;

	@Test
	public void testAddFirst() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.addFirst("Nagi");
		arrayDeque.addFirst("Ponnaganti");

		System.out.println("Elements: " + arrayDeque);
		assertArrayEquals("This is AddFirst", arrayDeque.toArray(), new String[] { "Ponnaganti", "Nagi" });
	}

	@Test
	public void testAddLast() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.addLast("Ponnaganti");
		arrayDeque.addLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertArrayEquals("This is AddLast", new String[] { "Ponnaganti", "Nagi" }, arrayDeque.toArray());
	}

	@Test
	public void testOfferFirst() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerFirst("Nagi");
		arrayDeque.offerFirst("Ponnaganti");

		System.out.println("Elements: " + arrayDeque);

		assertArrayEquals("This is OfferFirst", new String[] { "Ponnaganti", "Nagi" }, arrayDeque.toArray());
	}

	@Test
	public void testOfferLast() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertArrayEquals("This is OfferLast", new String[] { "Ponnaganti", "Nagi" }, arrayDeque.toArray());
	}

	@Test
	public void testRemoveFirst() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("Its has to be Ponnaganti", "Ponnaganti", arrayDeque.removeFirst());

	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstNoSuchElementException() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		System.out.println("Elements: " + arrayDeque);

		arrayDeque.removeFirst();
	}

	@Test
	public void testRemoveLast() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("The value has to be Nagi", "Nagi", arrayDeque.removeLast());
	}

	@Test
	public void testPollFirst() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("The Value has to be Ponnaganti", "Ponnaganti", arrayDeque.pollFirst());
		assertEquals("The value has to be Nagi", "Nagi", arrayDeque.pollFirst());
		assertNull(arrayDeque.pollFirst());

	}

	@Test
	public void testPollLast() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("The value has to be Nagi", "Nagi", arrayDeque.pollLast());
		assertEquals("The Value has to be Ponnaganti", "Ponnaganti", arrayDeque.pollLast());
		assertNull(arrayDeque.pollLast());
	}

	@Test
	public void testGetFirst() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("The value has to be Ponnaganti", "Ponnaganti", arrayDeque.getFirst());
		assertEquals("The value has to be Ponnaganti not to remove", "Ponnaganti", arrayDeque.getFirst());
	}

	@Test
	public void testGetLast() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("The Value has to be Nagi", "Nagi", arrayDeque.getLast());
		assertEquals("The Value has to be Nagi not to remove", "Nagi", arrayDeque.getLast());
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetLastNoSuchElementException() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.getLast();
	}

	@Test
	public void testPeekFirst() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("This one has to be Ponnaganti", "Ponnaganti", arrayDeque.peekFirst());
		assertEquals("This one has to be Ponnaganti", "Ponnaganti", arrayDeque.peekFirst());

	}

	@Test
	public void testPeekLast() {

		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("This one has to be Nagi", "Nagi", arrayDeque.peekLast());
		assertEquals("This one has to be Nagi", "Nagi", arrayDeque.peekLast());

	}

	@Test
	public void testRemoveFirstOccurance() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");
		arrayDeque.offerLast("Ponnaganti");

		System.out.println("Elements: " + arrayDeque);

		arrayDeque.removeFirstOccurrence("Ponnaganti");
		System.out.println("Elements: " + arrayDeque);

		assertArrayEquals("This has to be Nagi Ponnaganti", new String[] { "Nagi", "Ponnaganti" },
				arrayDeque.toArray());
	}

	@Test
	public void testRemoveLastOccurences() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.offerLast("Ponnaganti");
		arrayDeque.offerLast("Nagi");
		arrayDeque.offerLast("Ponnaganti");

		System.out.println("Elements: " + arrayDeque);

		arrayDeque.removeLastOccurrence("Ponnaganti");
		System.out.println("Elements: " + arrayDeque);

		assertArrayEquals("This has to be Ponnaganti Nagi ", new String[] { "Ponnaganti", "Nagi" },
				arrayDeque.toArray());

	}

	@Test
	public void testPush() {
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.push("Nagi");
		arrayDeque.push("Ponnaganti");

		System.out.println("Elements: " + arrayDeque);

		assertArrayEquals("This has to be Ponnaganti Nagi", new String[] { "Ponnaganti", "Nagi" },
				arrayDeque.toArray());
	}

	@Test
	public void testPop() {
		
		System.out.println("Current Test: " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		arrayDeque.push("Nagi");
		arrayDeque.push("Ponnaganti");

		System.out.println("Elements: " + arrayDeque);

		assertEquals("This has to be Ponnaganti", "Ponnaganti", arrayDeque.pop());
		assertEquals("This has to be Nagi", "Nagi", arrayDeque.pop());
	}
	
	@Test
	public void testShiftOperator() {		
		System.out.println("Integer Binary: " + Integer.toBinaryString(23));		
		System.out.println("Integer Binary: " + Integer.toBinaryString(23 << 2));		

	}
	
	

	@Ignore
	@Test(expected = IllegalStateException.class)
	public void testAddFirstISExecption() {
		arrayDeque = new ArrayDeque<>(0);

	}

	@Before
	public void init() {
		arrayDeque = new ArrayDeque<>();
	}

}
