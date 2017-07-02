package com.nagihome.java8.chapter07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise04 {

	public static void main(String[] args) {

		System.out.println("Checking parallel vs sequencial");

		printTimeTaken();
		Stream.iterate(1L, n -> n + 1).limit(100000).sequential().reduce(0L, Long::sum);
		printTimeTaken();

		printTimeTaken();
		Stream.iterate(1L, n -> n + 1).limit(100000).parallel().reduce(0L, Long::sum);
		printTimeTaken();

		System.out.println("Avalible Processors: " + Runtime.getRuntime().availableProcessors());
		
		printTimeTaken();
		LongStream.rangeClosed(1L, 10_000_000).reduce(0L, Long::sum);
		printTimeTaken();

		printTimeTaken();
		LongStream.rangeClosed(1L, 10_000_000).parallel().reduce(0L, Long::sum);
		printTimeTaken();
		
	}

	private static Long currentTimeLong = System.nanoTime();

	private static void printTimeTaken() {
		System.out.println("Time Taken: " + (System.nanoTime() - currentTimeLong) /1000000 + " ms");
		currentTimeLong = System.nanoTime();
	}

}
