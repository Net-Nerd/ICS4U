package Tran;

import java.util.Scanner;

public class Main {

	/**
	 * Main class which implements an object from the search class.
	 * 
	 * @param args Main arguments.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int[] intList = { 1, 3, 5, 7, 10, 21, 27, 28 };
		double[] doubleList = { 2.8, 4.0, 5.1, 6.2, 9.0 };
		String[] stringList = { "cat", "dogs", "lemon", "monkey", "zebra" };

		Search searchObject = new Search();
		Scanner myInput = new Scanner(System.in);

		while (true) {
			System.out.print("Please enter a target: ");
			boolean intFlag = false;
			String userInput = myInput.nextLine();
			for (int i = 0; i < userInput.length(); i++)
				if(Character.isDigit(userInput.charAt(i)))
					intFlag = true;	
			if (userInput.contains(".")) {
				System.out.println(searchObject.linearSearch(doubleList, Double.parseDouble(userInput)));
				System.out.println(searchObject.binarySearch(doubleList, Double.parseDouble(userInput)));
			} else if (intFlag == true) {
				System.out.println(searchObject.linearSearch(intList, Integer.parseInt(userInput)));
				System.out.println(searchObject.binarySearch(intList, Integer.parseInt(userInput)));
			} else {
				System.out.println(searchObject.linearSearch(stringList, userInput));
				System.out.println(searchObject.binarySearch(stringList, userInput));
			}
		}
	}

}
