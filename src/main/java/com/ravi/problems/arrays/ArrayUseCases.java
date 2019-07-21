package com.ravi.problems.arrays;

import java.util.Arrays;

public class ArrayUseCases {

	/**
	 * Input Array --> [1, 0, 3, 0, 0, 2 ] Output Array --> [1, 3, 2, 0, 0, 0]
	 * 
	 * Constraints:- 1. In single pass of the array 2. Do not make a copy of array
	 * nor create new array and move the zeros within the input array
	 */
	public static int[] moveZerosToTheEnd(int[] inputArray) {
		int currentZeroIndex = -1;
		int numberOfZeros = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == 0) {
				currentZeroIndex = i - numberOfZeros;
				numberOfZeros++;
			} else {
				if (currentZeroIndex != -1) {
					inputArray[currentZeroIndex] = inputArray[i];
					inputArray[i] = 0;
					currentZeroIndex = i - numberOfZeros;
				}
			}

		}

		return inputArray;
	}

	public static void main(String[] args) {
		
		System.out.println("Move Zeros to end problem input: [ 1, 0, 0, 4, 0, 3, 0, 0, 2 ]");
		Arrays.stream(moveZerosToTheEnd(new int[] { 1, 0, 0, 4, 0, 3, 0, 0, 2 })).forEach(System.out::print);
		
	}

}
