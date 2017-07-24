/**
 * 
 */
package com.nagihome;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nageswararao
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
	public static void main(String[] args) throws Exception {

		double d = 0.0 / 0.0;
		System.out.println(d);

		// int i = 0 / 0;
		// System.out.println(i);

		A a = new B();
		System.out.println(a.i);
		System.out.println(a.j);
		System.out.println(a.m());
		B b = new B();
		System.out.println(b.m());
		System.out.println(b.j);

		System.out.println("a: " + 1 + 2 + 3);

		List l1 = new ArrayList();
		List l2 = new ArrayList();

		l1.add(l1);
		l2.add(l2);

		System.out.println(l1 == l2);
		System.out.println(l1.equals(l2));

	}

}

class A {
	int i = 1;
	static double j = 1.0;

	public int m() throws Exception {
		return i;
	}
}

class B extends A {
	int i = 2;
	static double j = 2.0;

}
