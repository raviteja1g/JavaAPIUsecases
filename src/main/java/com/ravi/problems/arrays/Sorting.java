package com.ravi.problems.arrays;

import java.util.Arrays;

public class Sorting {

	/**
	 * Simple Insertion sort of array of int
	 */
	public static void insertionSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			int key = inputArray[i];
			int j = i - 1;
			while (j >= 0 && inputArray[j] > key) {
				inputArray[j + 1] = inputArray[j];
				j--;
			}
			inputArray[j + 1] = key;
		}

		Arrays.stream(inputArray).forEach(System.out::print);

	}

	/**
	 * Selection sort of array of int
	 */
	public static void selectionSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] < inputArray[minIndex]) {
					minIndex = j;
				}
			}
			// swap
			int temp = inputArray[minIndex];
			inputArray[minIndex] = inputArray[i];
			inputArray[i] = temp;
		}
		Arrays.stream(inputArray).forEach(System.out::print);
	}

	/**
	 * Quick Sort of an array on int
	 */
	public void quickSort(int[] inputArray) {
		quickSortParition(inputArray, 0, inputArray.length - 1);
		Arrays.stream(inputArray).forEach(System.out::print);
	}

	public void quickSortParition(int[] inputArray, int start, int end) {
		if (start < end) {
			int paritionIndex = partition(inputArray, start, end);
			quickSortParition(inputArray, start, paritionIndex - 1);
			quickSortParition(inputArray, paritionIndex + 1, end);
		}
	}

	public int partition(int[] inputArray, int start, int end) {
		int pivot = inputArray[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (inputArray[j] <= pivot) {
				i++;
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
			}
		}
		int temp = inputArray[end];
		inputArray[end] = inputArray[i + 1];
		inputArray[i + 1] = temp;

		return i + 1;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Insertion Sort input { 3, 2, 1, 0, 5, 1 }");
		insertionSort(new int[] { 3, 2, 1, 0, 5, 1 });
		
		System.out.println(" \nSelection Sort input { 3, 2, 1, 0, 5, 1 }");
		selectionSort(new int[] { 3, 2, 1, 0, 5, 1 });

		System.out.println(" \nQuick Sort input { 3, 2, 1, 0, 5, 1 }");
		
		Sorting testRun = new Sorting();
		testRun.quickSort(new int[] { 3, 2, 1, 0, 5, 1 });
	}

}
