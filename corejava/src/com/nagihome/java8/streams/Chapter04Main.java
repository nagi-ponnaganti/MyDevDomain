/**
 * 
 */
package com.nagihome.java8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author nageswararao
 *
 */
public class Chapter04Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printList(getLowCalorieDishNames());
		printList(getLowCalorieSortedDishNames());
		printMap01(getListOfDishesByType());
		printList(getFirstThreeSortedDishNamesMoreThan300Calories());
	}

	private static List<String> getLowCalorieDishNames() {

		return DishDataProvider.getNewData().stream().filter(d -> d.getCalories() < 400).map(Dish::getName)
				.collect(Collectors.toList());
	}

	private static List<String> getLowCalorieSortedDishNames() {

		return DishDataProvider.getNewData().stream().filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparingInt(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
	}

	private static Map<Type, List<Dish>> getListOfDishesByType() {
		return DishDataProvider.getData().stream().collect(Collectors.groupingBy(Dish::getType));
	}

	private static List<String> getFirstThreeSortedDishNamesMoreThan300Calories() {
		return DishDataProvider.getData().stream().filter(d -> {
			System.out.println("filtering: " + d.getName());
			return d.getCalories() > 300;
		}).sorted(Comparator.comparing(Dish::getName)).map(d -> {
			System.out.println("mapping: " + d.getName());
			return d.getName();
		}).limit(3).collect(Collectors.toList());
	}

	private static void printList(List<?> list) {
		System.out.println("printing the list: " + list);
		for (Object item : list) {
			System.out.println(item);
		}
	}

	private static void printMap01(Map<Type, List<Dish>> map) {
		System.out.println("printing the map: " + map);

		for (Entry<Type, List<Dish>> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			for (Dish dish : entry.getValue()) {
				System.out.println(ToStringBuilder.reflectionToString(dish));
			}
		}
	}

}
