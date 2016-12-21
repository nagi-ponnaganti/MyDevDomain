/**
 * 
 */
package com.nagihome.algos.chapter01;

/**
 * @author nageswararao
 *
 */
public class EuclidsAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("The Greatest Common Divisor");

		new EuclidsAlgo().gcd(1221, 3445);

	}

	public int gcd(int p, int q) {

		System.out.println(String.format("Current P: %s And Q: %s", p, q));

		if (q == 0) {
			System.out.println(String.format("Return Value P: %s ", p));
			return p;
		}

		int r = p % q;

		return gcd(q, r);
	}

}
