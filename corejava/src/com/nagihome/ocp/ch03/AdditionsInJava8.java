package com.nagihome.ocp.ch03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class AdditionsInJava8 {

    public static void main(String[] args) {

        List<String> someList = new ArrayList<>();
        someList.add("A");
        someList.add("AB");
        someList.add("BC");
        someList.add("CD");
        someList.add("DE");
        someList.add("EF");
        System.out.println(someList);

        someList.removeIf(s -> s.startsWith("A"));
        System.out.println(someList);

        List<Integer> intList = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> intList.add(i));
        System.out.println(intList);
        intList.replaceAll(x -> x * x);
        System.out.println(intList);

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);

        BiFunction<String, String, String> mapper = (s1, s2) -> (s1.length() > s2.length()) ? s1 : s2;

        Map<String, String> names = new HashMap<>();
        names.put("Nagi", "Nagi Ponnaganti");
        names.put("Moni", "Monika Gutta");

        names.merge("Nagi", "Nageswararao Ponnaganti", mapper);
        names.merge("Moni", "Moni Gutta", mapper);

        System.out.println("Merge Map: " + names);

        BiFunction<String, Integer, Integer> mapper1 = (k, v) -> v + 1;
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Nagi", 3);
        counts.computeIfPresent("Nagi", mapper1);
        System.out.println("counts: " + counts);



    }

}
