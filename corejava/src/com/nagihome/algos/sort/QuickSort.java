/**
 * 
 */
package com.nagihome.algos.sort;

/**
 * @author nageswararao
 *
 */
public class QuickSort {

	private int[] numbers;
	private int number;

	public void sort(int[] values) {

		if (values != null && values.length == 0) {
			System.out.println("array is null or array length is empty");
			return;
		}

		numbers = values;
		number = values.length;

		System.out.format(" The array size: %s\n", number);

		System.out.println(" Quick Sort Started...");

		System.out.println(" array contents: ");

		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println(" ");

		quickSort(0, number - 1);
		
		System.out.println("\n array contents after sorting: ");

		for (int i : numbers) {
			System.out.print(i + " ");
		}

	}

	private void quickSort(int low, int high) {

		System.out.format("\n Low: %s and High: %s ", low, high);

		int pivot = numbers[low + ((high - low) / 2)];

		int i = low, j = high;

		if (i <= j) {

			while (numbers[i] < pivot) {
				i++;
			}

			while (numbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
			
			System.out.println("");

			for (int k : numbers) {
				System.out.print(k + " ");
			}

			if (low < j){
				System.out.println("low < j");
				quickSort(low, j);
			}
				
			if (i < high) {
				System.out.println("i < high");
				quickSort(i, high);
			}
				

		}
	}

	private void exchange(int i, int j) {
//		System.out.format("\n exchanging number i: %s and j: %s ", i, j);
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new QuickSort().sort(new int[] { 3, 4, 1, 2, 7, 5, 6, 9, 8 });

	}

}
