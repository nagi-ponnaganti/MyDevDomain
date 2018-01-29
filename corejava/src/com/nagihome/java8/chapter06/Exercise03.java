/**
 * 
 */
package com.nagihome.java8.chapter06;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.nagihome.java8.streams.Dish;
import com.nagihome.java8.streams.DishDataProvider;
import com.nagihome.java8.streams.TradeDataProvider;
import com.nagihome.java8.streams.Transaction;
import static java.util.stream.Collectors.*;

/**
 * @author nageswararao
 *
 */
public class Exercise03 {

	public static void main(String[] args) {


		// Transactions Group by Currency
		TradeDataProvider.getTransactionData().stream().collect(groupingBy(Transaction::getCurrency)).entrySet()
				.forEach(e -> System.out.format("key: %s value: %s \n", e.getKey(),
						e.getValue().stream().map(v -> v.toString()).collect(joining("; "))));

		// Number of dishes in menu
		System.out.println("Number Of Dishes: " + dishStream().collect(counting()));

		// Max Calories Dish
		dishStream().max(Comparator.comparing(Dish::getCalories))
				.ifPresent(v -> System.out.println("Max Calorie Dish: " + v));

		// Min Calories Dish
		dishStream().min(Comparator.comparing(Dish::getCalories))
				.ifPresent(v -> System.out.println("Min Calorie Dish: " + v));

		// Total Calories in Menu
		System.out.println(
				"Int Summary for calories in Menu: " + dishStream().collect(summarizingInt(Dish::getCalories)));

		// Total Calories using reducing function
		System.out.println("Total Calories using reducing function: " + DishDataProvider.getData().stream()
				.collect(reducing(0, Dish::getCalories, (i, j) -> i + j)).intValue());

		System.out.println("Total Calories using reducing function 2: "
				+ DishDataProvider.getData().stream().map(Dish::getCalories).collect(reducing(Integer::sum)));

		dishStream().collect(groupingBy(Dish::getType)).entrySet().stream()
				.forEach(e -> System.out.format("Key: %s :: Value: %s \n", e.getKey(),
						e.getValue().stream().map(Dish::toString).collect(joining("; "))));

		// Multi Level Grouping
		dishStream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		})));

		dishStream().collect(groupingBy(Dish::getType, counting())).entrySet()
				.forEach(e -> System.out.format("Key: %s Value: %s \n", e.getKey(), e.getValue()));

		dishStream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories)))).entrySet()
				.forEach(e -> System.out.format("Key: %s Value: %s \n", e.getKey(), e.getValue()));

		System.out.println("CollectingAndGet: " + dishStream().collect(groupingBy(Dish::getType,
				collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get))));

		dishStream().collect(partitioningBy(Dish::isVegetarian)).entrySet().stream()
				.forEach(e -> System.out.format("Key: %s \nValues: \n%s \n", e.getKey(),
						e.getValue().stream().map(v -> v.toString()).collect(joining(";\n"))));

		dishStream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType))).entrySet().stream()
				.forEach(e -> System.out.format("Key: %s \nValue: \n%s\n", e.getKey(), e.getValue()));

		dishStream().collect(partitioningBy(Dish::isVegetarian, maxBy(Comparator.comparing(Dish::getCalories))))
				.entrySet().stream()
				.forEach(e -> System.out.format("Key: %s \nValue: \n%s\n", e.getKey(), e.getValue()));

		dishStream()
				.collect(partitioningBy(Dish::isVegetarian,
						collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)))
				.entrySet().stream()
				.forEach(e -> System.out.format("Key: %s \nValue: \n%s\n", e.getKey(), e.getValue()));

		IntStream.rangeClosed(2, 10).boxed().collect(partitioningBy(i -> isPrime(i))).entrySet()
				.forEach(e -> System.out.format("\nKey: %s \nValue: %s", e.getKey(), e.getValue()));
		
		
	}

	private static boolean isPrime(Integer candidate) {
		return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
	}

	static Stream<Dish> dishStream() {
		return DishDataProvider.getData().stream();
	}

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}

}
