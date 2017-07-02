package com.nagihome.java8.chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import com.nagihome.java8.streams.Dish;
import com.nagihome.java8.streams.DishDataProvider;
import com.nagihome.java8.streams.TradeDataProvider;
import com.nagihome.java8.streams.Transaction;
import com.nagihome.java8.streams.Type;

public class Exercise02 {

	public static void main(String[] args) {

		// filter the vegetarian dishes
		System.out.println("Filter the vegetarian:");
		data().stream().filter(d -> d.isVegetarian()).forEach(System.out::println);

		System.out.println("Distinct Even Numbers:" + Arrays.asList(1, 2, 3, 4, 4, 5, 1).stream()
				.filter(i -> (i % 2 == 0)).distinct().map(i -> i.toString()).collect(joining(",")));

		// truncate the stream
		System.out.println("Truncate the Stream:");
		data().stream().filter(d -> d.getCalories() > 300).limit(4).forEach(System.out::println);

		System.out.println("Skipping the Stream:");
		data().stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::println);

		System.out.println("Filtering First Two Meat Dishes");
		data().stream().filter(d -> d.getType().equals(Type.MEAT)).limit(2).forEach(System.out::println);

		System.out
				.println("Get All Names Of the Dishes: " + data().stream().map(d -> d.getName()).collect(joining(";")));

		System.out.println("Length Of All Words: "
				+ Arrays.asList("Java8", "Lambdas", "In", "Action").stream().map(String::length).collect(toList()));

		Arrays.asList("Hello", "World").stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList()).forEach(System.out::print);

		System.out.println("");
		System.out.print("Paired: ");
		List<Integer> a = Arrays.asList(1, 2, 3);
		List<Integer> b = Arrays.asList(4, 5);
		System.out.println(a.stream().flatMap(i -> b.stream().map(j -> new int[] { i, j }))
				.map(i -> "{" + String.valueOf(i[0]) + "," + String.valueOf(i[1]) + "}")
				.collect(Collectors.joining(",")));

		System.out.print("Match Any veg: ");
		if (data().stream().anyMatch(Dish::isVegetarian))
			System.out.println("this is veg friendly");

		System.out.print("Check if menu is healthy: ");
		if (data().stream().allMatch(d -> d.getCalories() < 1000))
			System.out.println("All dishes are healthy");

		data().stream().findAny().ifPresent(System.out::println);

		System.out.println("First Square dividable by 3");
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(x -> x * x).filter(i -> i % 3 == 0)
				.map(j -> String.valueOf(j)).collect(Collectors.joining(",")));

		System.out.println("Add: " + Arrays.asList(1, 2, 3, 4, 5, 6).stream().reduce(0, (x, y) -> x + y));
		System.out.println("Mul: " + Arrays.asList(1, 2, 3, 4, 5, 6).stream().reduce(1, (x, y) -> x * y));
		System.out.println("Add: " + Arrays.asList(1, 2, 3, 4, 5, 6).stream().reduce(0, Integer::sum));
		System.out.println("Max: " + Arrays.asList(1, 2, 3, 4, 5, 6).stream().reduce(Integer::max).get());
		System.out.println("Min: " + Arrays.asList(1, 2, 3, 4, 5, 6).stream().reduce(Integer::min).get());

		System.out.println("Total Items: " + data().stream().map(d -> 1).reduce(Integer::sum).get());

		System.out.println("Transaction Info for 2011 and there value sorted: ");
		TradeDataProvider.getTransactionData().stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);

		System.out.println("Unique Cities Where the Traders Works: ");
		TradeDataProvider.getTraderData().stream().map(t -> t.getCity()).distinct().sorted()
				.forEach(System.out::println);

		System.out.println("find all traders from cambridge and sort them by names: ");
		TradeDataProvider.getTraderData().stream().filter(t -> t.getCity().equals("Cambridge")).map(t -> t.getName())
				.sorted().forEach(System.out::println);

		System.out.println("all traders names in a string sorted by name: " + TradeDataProvider.getTraderData().stream()
				.map(t -> t.getName()).sorted().collect(Collectors.joining()));

		System.out.println("Any Trades Based in Milan: "
				+ TradeDataProvider.getTraderData().stream().anyMatch(t -> t.getCity().equals("Milan")));

		System.out.println("Print all transactions from traders living in Cambridge:");
		TradeDataProvider.getTransactionData().stream().filter(trans -> trans.getTrader().getCity().equals("Cambridge"))
				.map(t -> t.getValue()).forEach(System.out::println);

		System.out.println("What’s the highest value of all the transactions? : " + TradeDataProvider
				.getTransactionData().stream().max(Comparator.comparing(Transaction::getValue)).get().getValue());

		System.out.println("Find the transaction with the smallest value. : " + TradeDataProvider.getTransactionData()
				.stream().min(Comparator.comparing(Transaction::getValue)).get().getValue());

		System.out.println("Sum of All Calories with Reduce Method: "
				+ DishDataProvider.getData().stream().map(Dish::getCalories).reduce(0, Integer::sum));

		System.out.println("Mapping to Numeric Stream and sum: " + data().stream().mapToInt(Dish::getCalories).sum());

		System.out.println("Mapping to Numeric Stream: " + data().stream().mapToInt(Dish::getCalories).getClass());
		System.out.println(
				"Mapping to Stream Of Integer: : " + data().stream().mapToInt(Dish::getCalories).boxed().getClass());

		OptionalInt optionalInt = data().stream().mapToInt(Dish::getCalories).max();
		System.out.println("Optional Int GetAsInt:" + optionalInt.getAsInt());

		System.out.println("Even Numbers Count:" + IntStream.rangeClosed(0, 100).filter(n -> n % 2 == 0).count());

		System.out.println("Pythagorean Triples: ");
		IntStream.rangeClosed(1, 100).boxed()
				.flatMap(x -> IntStream.rangeClosed(1, 100).filter(y -> Math.sqrt(x * x + y * y) % 1.0 == 0)
						.mapToObj(y -> new int[] { x, y, (int) Math.sqrt(x * x + y * y) }))
				.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

		System.out.println("Stream Iterate: "
				+ Stream.iterate(0, n -> n + 2).limit(4).map(i -> String.valueOf(i)).reduce("", String::concat));

		System.out.println("Fibonacci series: ");
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);

		System.out.println("Generate Method:");
		Stream.generate(Math::random).limit(10).forEach(System.out::println);

	}

	private static List<Dish> data() {
		return DishDataProvider.getData();
	}

}
