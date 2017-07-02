/**
 * 
 */
package com.nagihome.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author nageswararao
 *
 */
@RunWith(JUnit4.class)
public class ArrayListTest {

	@Test
	public void testAdd() {
		stringList01.add("Nagi");
		Assert.assertEquals("The expected and the actual is not same", stringList01.get(0), "Nagi");
	}

	@Test
	public void testAddingNullValue() {
		stringList01.add(null);
		System.out.println("List Contents: "
				+ ToStringBuilder.reflectionToString(stringList01.toArray(), ToStringStyle.SIMPLE_STYLE));
		Assert.assertNull(stringList01.get(0));
	}

	@Test
	public void testAddingValueAtIndex() {

		stringList01 = new ArrayList<String>(10);
		stringList01.add("Hello");
		stringList01.add(1, "World");

		System.out.println("List Contents: "
				+ ToStringBuilder.reflectionToString(stringList01.toArray(), ToStringStyle.SIMPLE_STYLE));

		Assert.assertEquals("The element at index 1 has to be World", stringList01.get(1), "World");

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundException() {
		stringList01.add(1, "Hello");
	}

	@Test
	public void testRemoveOperation() {
		stringList01.add("Hello");
		stringList01.add("World");

		Assert.assertEquals("Expecting the word World", "World", stringList01.remove(1));
	}

	@Test
	public void testRemoveOperationShiftElements() {
		stringList01.add("Hello");
		stringList01.add("World");

		Assert.assertEquals("Expecting Hello", "Hello", stringList01.remove(0));
		Assert.assertEquals("Expecting world", "World", stringList01.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testClearOperation() {
		stringList01.add("HelloWorld");
		stringList01.clear();
		Assert.assertNull("Expecting Null Object", stringList01.get(0));
	}

	@Test
	public void testAddAllOperationWithIndex() {
		stringList01.add("Hello");
		stringList01.add("World");
		List<String> tmpList = Arrays.asList("Again");
		stringList01.addAll(1, tmpList);
		Assert.assertEquals("Expecting Again Word", "Again", stringList01.get(1));
	}

	@Test
	public void testRemoveByIndexOperation() {
		stringList01.add("Hello");
		stringList01.add("World");
		stringList01.add("Again");
		stringList01.add("And");
		stringList01.add("Again");

		stringList01.remove(0);
		printList(stringList01);
		Assert.assertEquals("Size have to 4", 4, stringList01.size());
	}

	@Test
	public void testRemoveAllOperation() {

		stringList01.add("Hello");
		stringList01.add("World");
		stringList01.add("Again");
		stringList01.add("And");
		stringList01.add("Again");

		List<String> tmpList = Arrays.asList("Again");

		stringList01.removeAll(tmpList);
		printList(stringList01);
	}

	@Test
	public void testRetainAllOperation() {

		stringList01.add("Hello");
		stringList01.add("World");
		stringList01.add("Again");
		stringList01.add("And");
		stringList01.add("Again");

		List<String> tmpList = Arrays.asList("Again");

		stringList01.retainAll(tmpList);
		printList(stringList01);
	}
	
	public void testListIteratorOperation() {
		
	}

	public void printList(List<String> obj) {
		System.out.println(
				"List Contents: " + ToStringBuilder.reflectionToString(obj.toArray(), ToStringStyle.SIMPLE_STYLE));

//		System.out.println("HashCode:" + System.identityHashCode(obj));
	}

	private List<String> stringList01;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		stringList01 = new ArrayList<>();
	}

}
