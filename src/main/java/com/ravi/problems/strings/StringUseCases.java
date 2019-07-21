package com.ravi.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringUseCases {

	/**
	 * Input --> "liffe" and "eifel" Output --> false
	 * 
	 * Input --> "selection" and "elections" Output --> true
	 * 
	 * @param input
	 * @return
	 */
	public boolean isInputPerfectAnagram(String input1, String input2) {

		/*
		 * Sort both inputs and check if sorted strings are equal 
		 */
		if (input1.length() == input2.length()) {
			char[] input1Characters = input1.toCharArray();
			char[] input2Characters = input2.toCharArray();
			Arrays.sort(input1Characters);
			Arrays.sort(input2Characters);
			return Arrays.equals(input1Characters, input2Characters);
		} else {
			return false;
		}

	}

	/**
	 * Input:- "D1E5E6E7D4E3E9D5E1D2E2D1E4" // Department and employees in it
	 * Output:- List<Map<String, String>> // Ex:- E5 -> D1, E6 -> D1, E7 -> D1, E3
	 * -> D4, E9 -> D4, E1 -> D5, E2 -> D2, E4 -> D1
	 * 
	 */
	public Map<String, String> employeeDepartmentGroupingTest(String depEmpMapping) {
		Map<String, String> empDepMapping = new TreeMap<>();
		for (int i = 0; i < depEmpMapping.length() - 2; i++) {
			if (depEmpMapping.charAt(i) == 'D') {
				String department = depEmpMapping.substring(i, i + 2);
				int j = i + 2;
				while (j < depEmpMapping.length() && depEmpMapping.charAt(j) != 'D') {
					empDepMapping.put(depEmpMapping.substring(j, j + 2), department);
					j = j + 2;
				}
				i = j - 1;
			}
		}
		return empDepMapping;
	}

	/**
	 * Input:- "D1E5E6E7D4E3E9D5E1D2E2D1E4" // Department and employees in it
	 * Output:- List<Map<String, String>> // Ex:- E5 -> D1, E6 -> D1, E7 -> D1, E3
	 * -> D4, E9 -> D4, E1 -> D5, E2 -> D2, E4 -> D1
	 * 
	 */
	public Map<String, String> employeeDepartmentGroupingTestNoAssumptions(String depEmpMapping) {
		Map<String, String> empDepMapping = new TreeMap<>();
		for (int i = 0; i < depEmpMapping.length() - 2; i++) {
			if (depEmpMapping.charAt(i) == 'D') {
				int currentDepEndIndex = (depEmpMapping.indexOf("E", i + 1) > 0) ? (depEmpMapping.indexOf("E", i + 1))
						: depEmpMapping.length();
				String department = depEmpMapping.substring(i, depEmpMapping.indexOf("E", currentDepEndIndex));
				int j = depEmpMapping.indexOf("E", currentDepEndIndex);
				while (j < depEmpMapping.length() && depEmpMapping.charAt(j) != 'D') {
					int currentEmpEndIndex = (depEmpMapping.indexOf("D", j + 1) < depEmpMapping.indexOf("E", j + 1))
							? (depEmpMapping.indexOf("D", j + 1))
							: depEmpMapping.indexOf("E", j + 1);
					currentEmpEndIndex = (currentEmpEndIndex < 0) ? depEmpMapping.length() : currentEmpEndIndex;
					empDepMapping.put(depEmpMapping.substring(j, currentEmpEndIndex), department);
					j = currentEmpEndIndex;
				}
				i = j - 1;
			}
		}
		return empDepMapping;
	}

	/**
	 * Input:- "D1E5E6E7D4E3E9D5E1D2E2D1E4" // Department and employees in it
	 * Output:- List<Map<String, String>> // Ex:- E5 -> D1, E6 -> D1, E7 -> D1, E3
	 * -> D4, E9 -> D4, E1 -> D5, E2 -> D2, E4 -> D1
	 * 
	 */
	public Map<String, String> employeeDepartmentGroupingTestWithDelimiter(String depEmpMapping) {
		Map<String, String> empDepMapping = new HashMap<>();

		return empDepMapping;
	}

	// "D1:E5,E6,E7|D4:E3,E9|D5:E1|D2:E2"
	List<String> parseDepartmentAndEmployees(String input) {
		String[] inputTokens = input.split("\\|");
		Map<String, List<String>> employeeDepartmentMapping = new TreeMap<>();

		for (int i = 0; i < inputTokens.length; i++) {
			String[] data = inputTokens[i].split(":");
			for (String employee : data[1].split(",")) {
				if (employeeDepartmentMapping.containsKey(employee)) {
					employeeDepartmentMapping.get(employee).add(data[0]);
				} else {
					List<String> departments = new ArrayList<>();
					departments.add(data[0]);
					employeeDepartmentMapping.put(employee, departments);
				}

			}
		}

		System.out.println("Here is the map of empDepMapping: " + employeeDepartmentMapping);

		List<String> empDepartments = new ArrayList<>();

		employeeDepartmentMapping.entrySet().stream().forEach((entry) -> {
			StringBuilder empDepMapping = new StringBuilder();
			List<String> depList = entry.getValue();
			empDepMapping.append(entry.getKey()).append(":").append(depList);
			empDepartments.add(empDepMapping.toString());
		});

		return empDepartments;
	}

	public void concatStringTest(String testString) {
		testString = testString + "Concatenated";
		System.out.println("Value of testString here in this method scope: " + testString);
	}

	public static void main(String[] args) {

		StringUseCases testRun = new StringUseCases();

		System.out.println(testRun.employeeDepartmentGroupingTest("D1E5E6E7D4E3E9D5E1D2E2"));

		System.out.println(testRun.employeeDepartmentGroupingTestNoAssumptions("D1E5E6E7D4E3E9D5E1D2E2"));

		System.out.println(testRun.parseDepartmentAndEmployees("D1:E5,E6,E7|D4:E3,E9|D5:E1|D2:E2"));

		System.out.println(
				"Is input perfect anagram: section and notice " + testRun.isInputPerfectAnagram("section", "notices"));

		System.out.println(
				"Is input perfect anagram: lifee and efife " + testRun.isInputPerfectAnagram("lifee", "efife"));

	}

}
