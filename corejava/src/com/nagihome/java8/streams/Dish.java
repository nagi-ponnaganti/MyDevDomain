/**
 * 
 */
package com.nagihome.java8.streams;

/**
 * @author nageswararao
 *
 */
public class Dish {

	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;
	
	/**
	 * @param name
	 * @param vegetarian
	 * @param calories
	 * @param type
	 */
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the vegetarian
	 */
	public boolean isVegetarian() {
		return vegetarian;
	}
	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
}

