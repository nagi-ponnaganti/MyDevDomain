/**
 * 
 */
package com.nagihome.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nageswararao
 *
 */
public class Chapter05Main01 {

	static List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
	static List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");

	static List<Integer> numbers1 = Arrays.asList(1, 2, 3);
	static List<Integer> numbers2 = Arrays.asList(3, 4);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("veg dishes: "
				+ DishDataProvider.getData().stream().filter(Dish::isVegetarian).collect(Collectors.toList()));

		System.out.print("Distinct Even Numbers: ");
		numbers.stream().filter(i -> (i % 2 == 0)).distinct().map(i -> i + ",").forEach(System.out::print);

		System.out.println("\n Limit: ");
		DishDataProvider.getData().stream().filter(d -> d.getCalories() > 300).limit(2).forEach(System.out::print);

		System.out.println("\n Skip: ");
		DishDataProvider.getData().stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::print);

		System.out.println("\n first two MEAT elements");
		DishDataProvider.getData().stream().filter(d -> d.getType() == Type.MEAT).limit(2).forEach(System.out::print);

		System.out.println("\nMappings dishes to Names:");
		DishDataProvider.getData().stream().map(d -> d.getName()).distinct().forEach(System.out::println);

		System.out.println("\nMappings Strings to lengths: ");
		words.stream().map(w -> w.length()).forEach(System.out::println);

		System.out.println("\nDistinct characters: ");
		words.stream().map(w -> w.split("")).flatMap(Arrays::stream).forEach(System.out::print);

		System.out.println("Square root: ");
		Stream.of(1, 2, 3, 4, 5).map(i -> i * i + ",").forEach(System.out::print);

		System.out.println("\nNumbers Mapping: ");
		numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j })).map(Arrays::toString)
				.forEach(System.out::print);

		System.out.println("\nfinding anyMatch: " + DishDataProvider.getData().stream().anyMatch(Dish::isVegetarian));

		System.out.println("All match: " + DishDataProvider.getData().stream().allMatch(d -> d.getCalories() < 1000));

		Optional<Dish> findAny = DishDataProvider.getData().stream().findAny();
		System.out.println("findAny: " + findAny.get());
		
	}

}
