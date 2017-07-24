package com.nagihome.pc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountLettersInString {

	private static void countLetters(String input) {

		int i = 0;
		while (input.length() > i) {
			manipulateOutPut(input.charAt(i));
			i++;
		}

		System.out.println(input);

		System.out.println(output.replace(COLON_DE, ""));

	}

	private static String output = null;

	public static void manipulateOutPut(char input) {

		if (output != null) {
			String[] charCounts = output.split(COLON_DE);
			String lastCharCount = charCounts[charCounts.length - 1];
			char c = lastCharCount.charAt(0);
			int count = Integer.valueOf(lastCharCount.substring(1, lastCharCount.length()));

			if (input == c) {
				count++;
				String newOutput = String.valueOf(input) + count;
				charCounts[charCounts.length - 1] = newOutput;
				output = Stream.of(charCounts).collect(Collectors.joining(COLON_DE));

			} else {
				String newOutput = String.valueOf(input) + 1;
				output = output + COLON_DE + newOutput;
			}

		} else {
			String newOutput = String.valueOf(input) + 1;
			output = newOutput + COLON_DE;
		}

	}

	static String COLON_DE = ":";

	public static void main(String[] args) {
		countLetters("aabcbbbbbcccsss1");
	}

}
