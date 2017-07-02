/**
 * 
 */
package com.nagihome.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author nageswararao
 *
 */
public class Chapter05Main {

	static List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

	static List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");

	static List<String> letter01 = Arrays.asList("A", "B", "C");
	static List<String> letter02 = Arrays.asList("D", "E");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		numbers.stream().filter(i -> (i % 2 == 0)).distinct().forEach(System.out::println);
		printDishesWithMoreCaloriesSkipFirstwo();
		printFirstTwoMeatDishes();
		words.stream().map(s -> s.length()).forEach(System.out::println);
		printNameAndLengthOfAllDishes();
		words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);

		letter01.stream().flatMap(i -> letter02.stream().map(j -> new char[] { i.charAt(0), j.charAt(0) }))
				.forEach(System.out::println);

		printToCheckIfMenuVeggieFriendly();

		System.out
				.println("isHealthy: " + DishDataProvider.getNewData().stream().allMatch(d -> d.getCalories() < 1000));

		DishDataProvider.getData().stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);

		printSumOfAllNumbers();

		printTheMaxOfAllNumbers();
		printTheMinOfAllNumbers();

		Optional.of(numbers.stream().map(d -> 1).reduce(0, (a, b) -> a + b)).ifPresent(System.out::println);

		System.out.println("sorted Trsactions of 2011: ");
		TradeDataProvider.getTransactionData().stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);

		System.out.println("Unique Cities: ");
		// TradeDataProvider.getTraderData().stream().map(t ->
		// t.getCity()).distinct().forEach(System.out::println);
		TradeDataProvider.getTransactionData().stream().map(t -> t.getTrader()).map(t -> t.getCity()).distinct()
				.forEach(System.out::println);

		System.out.println("Sorted Traders Names from Cambridge ");
		// TradeDataProvider.getTraderData().stream().filter(t ->
		// "Cambridge".equals(t.getCity())).map(t -> t.getName())
		// .sorted().forEach(System.out::println);
		TradeDataProvider.getTransactionData().stream().map(t -> t.getTrader())
				.filter(t -> "Cambridge".equals(t.getCity())).map(t -> t.getName()).distinct().sorted()
				.forEach(System.out::println);

		System.out.println("Milan Traders");
		TradeDataProvider.getTransactionData().stream().map(t -> t.getTrader()).filter(t -> "Milan".equals(t.getCity()))
				.distinct().forEach(System.out::print);

		System.out.println("All Transaction from Cambridge");
		TradeDataProvider.getTransactionData().stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
				.map(t -> t.getValue()).sorted().forEach(System.out::println);

		System.out.println("Highest Values Of All Transactions");
		TradeDataProvider.getTransactionData().stream().map(t -> t.getValue()).reduce(Integer::max);

		Optional.of(DishDataProvider.getData().stream().map(Dish::getCalories).reduce(Integer::sum))
				.ifPresent(System.out::print);
		
		System.out.println("Sum:" + DishDataProvider.getData().stream().mapToInt(Dish::getCalories).sum());

		IntStream stream = DishDataProvider.getData().stream().mapToInt(Dish::getCalories);
		stream.max().ifPresent(System.out::println);
		
		
	}

	private static void printTheMaxOfAllNumbers() {
		Optional.of(numbers.stream().reduce(Integer::max)).ifPresent(System.out::println);
	}

	private static void printTheMinOfAllNumbers() {
		Optional.of(numbers.stream().reduce(Integer::min)).ifPresent(System.out::println);
	}

	private static void printSumOfAllNumbers() {
		System.out.println("printSumOfAllNumbers: ");
		Optional<Integer> sum = Optional.of(numbers.stream().reduce(0, (a, b) -> a + b));
		sum.ifPresent(System.out::println);
	}

	private static void printDishesWithMoreCaloriesSkipFirstwo() {
		System.out.println("printDishesWithMoreCaloriesSkipFirstwo: ");
		DishDataProvider.getNewData().stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::println);
	}

	private static void printFirstTwoMeatDishes() {
		System.out.println("printFirstTwoMeatDishes: ");

		DishDataProvider.getNewData().stream().filter(d -> d.getType().equals(Type.MEAT)).limit(2)
				.forEach(System.out::println);
	}

	private static void printNameAndLengthOfAllDishes() {
		System.out.println("printNameAndLengthOfAllDishes: ");
		DishDataProvider.getNewData().stream().map(d -> "Name: " + d.getName() + " And Calories: " + d.getCalories())
				.forEach(System.out::println);

	}

	private static void printToCheckIfMenuVeggieFriendly() {
		if (DishDataProvider.getNewData().stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("Menu Looks a bit Vegiterian friendly");
		}
	}

}
