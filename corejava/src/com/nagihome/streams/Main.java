/**
 * 
 */
package com.nagihome.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author nageswararao
 *
 */
public class Main {

	static List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23),
			new Person("Pamela", 23), new Person("David", 12));

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> aList = Arrays.asList("a1", "a2", "b1", "b2", "c1", "c2");
		aList.stream().filter(c -> c.startsWith("c")).map(String::toUpperCase).forEach(System.out::println);

		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);

		Stream.of(1, 2, 3).forEach(System.out::println);

		IntStream.range(0, 4).map(n -> n * 5 + 1).average().ifPresent(System.out::println);

		Stream.of("a1", "b3", "c5").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println);

		IntStream.range(0, 4).mapToObj(i -> "a" + i).forEach(System.out::println);

		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("Filter: " + s);
			return true;
		}).forEach(System.out::println);

		Stream.of("d2", "a2", "b1", "b3", "c").sorted((s1, s2) -> {
			System.out.println("Sort " + s1 + " " + s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("Filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("Map: " + s);
			return s.toUpperCase();
		}).forEach(s -> {
			System.out.println("ForEach: " + s);
		});

		List<Person> people = persons.stream().filter(p -> p.getName().startsWith("P")).collect(Collectors.toList());
		System.out.println(people);

		Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.getAge()));
		personsByAge.forEach((age, person) -> System.out.format("Age %s and Name %s \n", age, person));

		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.getAge()));
		System.out.println("averageAge :" + averageAge);

		IntSummaryStatistics intStats = persons.stream().collect(Collectors.summarizingInt(p -> p.getAge()));
		System.out.println("intStats: " + intStats);

		String phrase = persons.stream().filter(p -> p.getAge() > 18).map(p -> p.getName())
				.collect(Collectors.joining(" and ", "In germany ", " are of legal age"));
		System.out.println(phrase);

		System.out.println(persons.stream()
				.collect(Collectors.toMap(p -> p.getAge(), p -> p.getName(), (name1, name2) -> name1 + ";" + name2)));

		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | "),
				(j, r) -> r.getName().toUpperCase(), (j1, j2) -> j1.merge(j2), StringJoiner::toString);

		System.out.println(persons.stream().collect(personNameCollector));

		List<Foo> foos = new ArrayList<Foo>();
		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo " + i)));
		foos.forEach(
				f -> IntStream.range(1, 4).forEach(i -> f.getBars().add(new Bar("Bar " + i + " <- " + f.getName()))));

		foos.stream().flatMap(b -> b.getBars().stream()).forEach(b -> System.out.println(b.getName()));

		IntStream.range(1, 4).mapToObj(i -> new Foo("Foo " + i))
				.peek(f -> IntStream.range(1, 4).mapToObj(i -> new Bar("Bar " + i + " <- " + f.getName()))
						.forEach(f.getBars()::add))
				.flatMap(f -> f.getBars().stream()).forEach(b -> System.out.println(b.getName()));

		persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println);

		Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
			p1.setName(p1.getName() + p2.getName());
			p1.setAge(p1.getAge() + p2.getAge());
			return p1;
		});

		System.out.format("Name:%s and Age:%s ", result.getName(), result.getAge());

		
	}
}
