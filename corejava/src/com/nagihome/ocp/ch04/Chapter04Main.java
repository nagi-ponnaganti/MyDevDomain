package com.nagihome.ocp.ch04;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter04Main {

    public static void main(String[] args) {

        // Supplier Example
        Supplier<LocalDate> su1 = LocalDate::now;
        Supplier<LocalDate> su2 = () -> LocalDate.now();
        System.out.printf("s1 by method reference: %s \n", su1.get());
        System.out.printf("s2 by lambda: %s \n", su2.get());

        Supplier<List<String>> ls1 = ArrayList::new;
        Supplier<List<String>> ls2 = () -> new ArrayList<>();
        System.out.printf("ls1 by method reference: %s \n", ls1.get());
        System.out.printf("ls2 by lambda: %s \n", ls2.get());

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = s -> System.out.println(s);
        c1.accept("c1Annie");
        c2.accept("c2Annie");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> bic1 = map::put;
        BiConsumer<String, Integer> bic2 = (k, v) -> map.put(k, v);
        bic1.accept("One", 1);
        bic2.accept("Two", 2);
        System.out.println(map);

        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = s -> s.isEmpty();
        System.out.println("Predicate with Method Ref: " + p1.test(""));
        System.out.println("Predicate with Lambda: " + p2.test(""));

        BiPredicate<String, String> bpi1 = String::startsWith;
        BiPredicate<String, String> bpi2 = (s1, s2) -> s1.startsWith(s2);
        System.out.println("BiPredicate With Method Ref: " + bpi1.test("Chicken", "Chick"));
        System.out.println("BiPredicate With Lambda: " + bpi1.test("Chicken", "Chick"));

        Function<String, Integer> fun1 = String::length;
        Function<String, Integer> fun2 = s -> s.length();
        System.out.println("Function With Method Ref: " + fun1.apply("Chicken"));
        System.out.println("Function With Lambda: " + fun2.apply("Chicken"));

        BiFunction<String, String, String> bfun1 = String::concat;
        BiFunction<String, String, String> bfun2 = (s1, s2) -> s1.concat(s2);
        System.out.println("Bifunction By Method Reference: " + bfun1.apply("nagi", " ponnganti"));
        System.out.println("Bifunction By Lambda: " + bfun2.apply("nagi", " ponnganti"));

        Optional<String> op1 = Optional.empty();

        try {
            op1.get();
        } catch (Exception ex) {
            System.err.println("No Such Element");
        }

        Optional<String> op2 = Optional.of("Nagi Ponnaganti");
        op2.ifPresent(System.out::println);
        System.out.println("Optional Present: " + op2.isPresent());

        System.out.println("Optional OrElse: " + op1.orElse("No Name"));
        System.out.println("Optional OrElseGet: " + op1.orElseGet(String::new));
        try {
            System.out.println("Optional OrElseThrow: " + op1.orElseThrow(IllegalArgumentException::new));
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Stream<Double> doubleStream = Stream.generate(Math::random);
        doubleStream.limit(5).forEach(System.out::println);

        Stream<Integer> integerStream = Stream.iterate(1, n -> n + 1);
        integerStream.skip(2).limit(5).forEach(i -> System.out.print(String.valueOf(i) + " "));
        System.out.println();
        Stream<String> animalStream = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println("Animal Count: " + animalStream.count());
        animalStream = Stream.of("monkey", "gorilla", "bonobooo");
        System.out.println("Animal Min: " + animalStream.min(Comparator.comparingInt(String::length)));
        animalStream = Stream.of("monkey", "gorilla", "bonobooo");
        System.out.println("Animal Min: " + animalStream.max(Comparator.reverseOrder()));

        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        System.out.println("Stream Reduce: " + stream1.reduce("", String::concat));

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        System.out.println("Stream Collect: " + stream2.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append));

        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        System.out.println("Stream Collect: " + stream3.collect(Collectors.toCollection(TreeSet::new)));

        System.out.println("find any : " + Stream.of("monkey", "gorilla", "bonobo").parallel().findAny());
        System.out.println("find first : " + Stream.of("monkey", "gorilla", "bonobo").findFirst());

        System.out.println("All Match: " + Stream.of("a", "ab", "abc").allMatch(s -> s.startsWith("a")));
        System.out.println("Any Match: " + Stream.of("a", "ab", "abc").anyMatch(s -> s.length() == 3));
        System.out.println("None Match: " + Stream.of("a", "ab", "abc").anyMatch(s -> !s.isEmpty()));

        Stream.of("Am", "Bm", "C").filter(s -> s.startsWith("C")).forEach(s -> System.out.println("Predicate: " + s));
        Optional.of(Stream.of("duck", "duck", "goose").distinct()
                .collect(Collectors.joining(",")))
                .ifPresent(s -> System.out.println("Distinct: " + s));

        Optional.of(Stream.iterate(1, n -> n * 2).limit(10).map(String::valueOf)
                .collect(Collectors.joining(" -> ")))
                .ifPresent(s -> System.out.println("Limit: " + s));

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Monkey");
        List<String> two = Arrays.asList("Monkey", "Baboon");
        Optional.of(Stream.of(zero, one, two).flatMap(l -> l.stream())
                .distinct()
                .collect(Collectors.joining(";")))
                .ifPresent(s -> System.out.println("FlatMap: " + s));

        System.out.println("Sorted: " + Stream.of('y', 'L', '1', '4', 'K', 'n')
                .sorted().map(String::valueOf)
                .collect(Collectors.joining("")));

        System.out.println("Sorted Reverse: " + Stream.of('y', 'L', '1', '4', 'K', 'n')
                .sorted(Comparator.reverseOrder()).map(String::valueOf)
                .collect(Collectors.joining("")));

        System.out.println("" + Stream.of("black bear", "brown bear", "grizzly").peek(s -> System.out.print(s + ", ")).count());

        System.out.println("IntStream Avg: " + IntStream.of(1, 2, 3).average().getAsDouble());
        System.out.println("IntStream Sum: " + IntStream.of(1, 2, 3).sum());
        System.out.println("IntStream Max: " + IntStream.of(1, 2, 3).max().getAsInt());

        Optional.of(DoubleStream.generate(Math::random)
                .limit(4)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n")))
                .ifPresent(s -> System.out.println("DoubleStream Generate: " + s));

        Optional.of(DoubleStream.iterate(0.5, n -> n + 2)
                .limit(4)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n")))
                .ifPresent(s -> System.out.println("DoubleStream Iterate: " + s));


        IntSummaryStatistics stats = IntStream.of(1, 2, 3).summaryStatistics();
        System.out.println("stats.getAverage: " + stats.getAverage());
        System.out.println("stats.getMax: " + stats.getMax());
        System.out.println("stats.getMin: " + stats.getMin());
        System.out.println("stats.getSum: " + stats.getSum());

    }

}
