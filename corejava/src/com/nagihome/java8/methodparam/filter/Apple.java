/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.math.BigDecimal;

/**
 * @author nageswararao
 *
 */
public class Apple {

	private String color;
	private BigDecimal weight;

	public Apple(String color, BigDecimal weight) {
		this.color = color;
		this.weight = weight;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

}
