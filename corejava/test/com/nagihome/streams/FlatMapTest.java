package com.nagihome.streams;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FlatMapTest {

	@Test
	public void testFlapMap() {

		List<Developer> team = new ArrayList<>();
		Developer polyglot = new Developer("esoteric");
		polyglot.add("clojure");
		polyglot.add("scala");
		polyglot.add("groovy");
		polyglot.add("go");

		Developer busy = new Developer("pragmatic");
		busy.add("java");
		busy.add("javascript");

		team.add(polyglot);
		team.add(busy);
		
		team.stream().map(d->d.getLanguages()).flatMap(i->i.stream()).forEach(System.out::println);

	}

}
