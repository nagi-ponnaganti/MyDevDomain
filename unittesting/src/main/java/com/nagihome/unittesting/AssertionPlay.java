/**
 * 
 */
package com.nagihome.unittesting;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Nagi
 *
 */
public class AssertionPlay {

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "Play".getBytes();
		byte[] actual = "Play".getBytes();
		assertArrayEquals("Bytes are not Equal", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		assertEquals("Strings are not equal", "Play", "Play");
	}

	@Test
	public void testAssertFalse() {
		assertFalse("This is true", false);
	}

	@Test
	public void testAssertNotNull() {
		assertNotNull("This Object is Null", new Object());
	}

	@Test
	public void testAssertNotSame() {
		assertNotSame("Objects are not same", new Object(), new Object());
	}

	@Test
	public void testAssertNull() {
		assertNull("this object is not null", null);
	}

	@Test
	public void testAssertSame() {
		Double doubleValue = new Double(1.23);
		assertSame("They are not same", doubleValue, doubleValue);
	}

	@Test
	public void testBothContainsStrings() {
		assertThat("Nagi Ponnaganti",
				both(containsString("a")).and(containsString("i")));
	}

	@Test
	public void testAssertThatHasContainsString() {
		assertThat(Arrays.asList("Nagi", "Ponnaganti", "Morgan Stanley"),
				hasItems("Nagi", "Ponnaganti"));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }),
				everyItem(containsString("n")));
	}

	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("good")));
		assertThat("good", not(allOf(equalTo("good"), startsWith("bad"))));
		assertThat("good", anyOf(equalTo("good"), startsWith("bad")));
		assertThat(7, not(either(equalTo(3)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}

}
