/**
 * 
 */
package com.nagihome.generics;

/**
 * @author nageswararao
 *
 */
public class GenericUtils {

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

	public static <P1 extends Number, P2 extends Number> boolean compareOnlyToIntLevel(P1 p1, P2 p2) {
		return p1.intValue() == p2.intValue();
	}

}
