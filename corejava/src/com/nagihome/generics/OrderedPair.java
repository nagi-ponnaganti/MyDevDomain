/**
 * 
 */
package com.nagihome.generics;

/**
 * @author nageswararao
 *
 */
class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.generics.Pair#getKey()
	 */
	@Override
	public K getKey() {
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.generics.Pair#getValue()
	 */
	@Override
	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "OrderedPair [key=" + key + ", value=" + value + "]";
	}

}
