package com.nagihome.java8.chapter04;

import java.util.Comparator;
import java.util.stream.Collectors;

import com.nagihome.java8.streams.Dish;

public class Exercise01 {

	public static void main(String[] args) {

		// names of dishes that are low in calories(400), sorted by number of
		// calories
		System.out.print("Names of dishes by low calories, sorted: ");
		System.out.println(DishDataProvider.getData().stream().filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.joining(", ")));

		// Dishes By Type
		System.out.println("Dishes By Type:");
		DishDataProvider.getData().stream().collect(Collectors.groupingBy(Dish::getType)).entrySet().stream()
				.forEach(e -> {
					System.out.println(e.getKey().toString().concat(
							" : " + e.getValue().stream().map(ie -> ie.getName()).collect(Collectors.joining(", "))));
				});

		// Get any three High Calorie Dish Names
		System.out.println("Get any three High Calorie Dish Names");
		DishDataProvider.getData().stream().filter(d -> d.getCalories() > 400).limit(3).map(d -> d.getName())
				.forEach(System.out::
					println);

	}

}
