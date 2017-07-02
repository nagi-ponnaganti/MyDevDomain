/**
 * 
 */
package com.nagihome.algos.sort;

/**
 * @author nageswararao
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 10, 34, 2, 56, 1, 67, 88, 42 };
		int[] arr2 = doInsertsionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}

	}

	public static int[] doInsertsionSort(int[] inputArray) {

		int temp;

		for (int i = 1; i < inputArray.length; i++) {
			for (int j = i; j > 0; j--) {
				if (inputArray[j] < inputArray[j - 1]) {
					System.out.println("Swapping " + inputArray[j] + " and " + inputArray[j - 1]);
					temp = inputArray[j];
					inputArray[j] = inputArray[j - 1];
					inputArray[j - 1] = temp;
				} else {
					System.out.println("No Swapping " + inputArray[j] + " and " + inputArray[j - 1]);
				}
			}
		}

		return inputArray;
	}

}
