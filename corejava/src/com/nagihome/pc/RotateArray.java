package com.nagihome.pc;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6 };

		System.out.println(Arrays.toString(rotateArrayByPlacesByTempArray(input, 3)));
		System.out.println(Arrays.toString(rotateArrayByPlacesByBubbleSort(input, 2)));
	}

	private static int[] rotateArrayByPlacesByTempArray(int[] intArray, int byPlaces) {

		if (byPlaces > intArray.length) {
			byPlaces = byPlaces % intArray.length;
		}

		int[] results = new int[intArray.length];

		int rotateStartPoint = intArray.length - byPlaces;

		int k = 0;
		// 0 1 2 3 4
		for (int i = rotateStartPoint; i < intArray.length; i++) {
			results[k++] = intArray[i];
		}

		for (int j = 0; j < rotateStartPoint; j++) {
			results[k++] = intArray[j];
		}

		return results;
	}

	private static int[] rotateArrayByPlacesByBubbleSort(int[] intArray, int byPlaces) {

		for (int i = 0; i < byPlaces; i++) {
			for (int j = intArray.length - 1; j > 0; j--) {
				int temp = intArray[j];
				intArray[j] = intArray[j - 1];
				intArray[j - 1] = temp;
			}
		}

		return intArray;
	}
	
	
}
