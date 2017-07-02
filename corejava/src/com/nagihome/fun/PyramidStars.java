package com.nagihome.fun;

public class PyramidStars {

	private static String ASTRIK = "*";
	private static String SPACE = " ";

	public static void main(String[] args) {
		printPyramidStars(10);
	}

	public static void printPyramidStars(int levels) {
		
		for (int i = 0; i < levels; i++) {

			for (int j = levels - i; j > 0; j--) {
				System.out.print(SPACE);
			}

			for (int k = 0; k <= i; k++) {
				System.out.print(SPACE + ASTRIK);
			}
			
			System.out.println();
		}
	}
}
