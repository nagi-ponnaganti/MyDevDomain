/**
 * 
 */
package com.nagihome.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nageswararao
 *
 */
public class Foo {

	private String name;
	private List<Bar> bars = new ArrayList<Bar>();

	public Foo(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the bars
	 */
	public List<Bar> getBars() {
		return bars;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param bars
	 *            the bars to set
	 */
	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}

}
