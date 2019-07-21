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

	public void merge(int[] inputArray, int start, int middle, int end) {

		int[] firstHalfOfArray = new int[middle - start + 1];
		int[] secondHalfOfArray = new int[end - middle];

		for (int i = 0; i < firstHalfOfArray.length; i++) {
			firstHalfOfArray[i] = inputArray[start + i];
		}
		for (int i = 0; i < secondHalfOfArray.length; i++) {
			secondHalfOfArray[i] = inputArray[middle + i + 1];
		}

		int i = 0, j = 0;
		int k = start;
		while (i < firstHalfOfArray.length && j < secondHalfOfArray.length) {
			if (firstHalfOfArray[i] <= secondHalfOfArray[j]) {
				inputArray[k] = firstHalfOfArray[i];
				i++;
			} else {
				inputArray[k] = secondHalfOfArray[j];
				j++;
			}
			k++;
		}

		while (i < firstHalfOfArray.length) {
			inputArray[k] = firstHalfOfArray[i];
			i++;
			k++;
		}

		while (j < secondHalfOfArray.length) {
			inputArray[k] = secondHalfOfArray[j];
			j++;
			k++;
		}

	}

	void mergeSortPartion(int[] inputArray, int start, int end) {
		if (start < end) {
			int middleIndex = (start + end) / 2;
			mergeSortPartion(inputArray, start, middleIndex);
			mergeSortPartion(inputArray, middleIndex + 1, end);
			merge(inputArray, start, middleIndex, end);
		}
	}

	public void mergeSort(int[] inputArray) {
		int lengthOfInput = inputArray.length;
		mergeSortPartion(inputArray, 0, lengthOfInput - 1);
		Arrays.stream(inputArray).forEach(System.out::print);
	}

	public static void main(String[] args) {

		System.out.println("Insertion Sort input { 3, 2, 1, 0, 5, 1 }");
		insertionSort(new int[] { 3, 2, 1, 0, 5, 1 });

		System.out.println("\nSelection Sort input { 3, 2, 1, 0, 5, 1 }");
		selectionSort(new int[] { 3, 2, 1, 0, 5, 1 });

		System.out.println("\nQuick Sort input { 3, 2, 1, 0, 5, 1 }");

		Sorting testRun = new Sorting();
		testRun.quickSort(new int[] { 3, 2, 1, 0, 5, 1 });

		System.out.println("\nMerge Sort input { 3, 2, 1, 0, 5, 1 }");

		testRun.mergeSort(new int[] { 3, 2, 1, 0, 5, 1 });
	}

}
