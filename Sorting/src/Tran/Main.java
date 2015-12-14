package Tran;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Sorting sortObject = new Sorting();
		Scanner myInput = new Scanner(System.in);
		String[] flavorText = { "\n1. Selection Sort", "2. Insertion Sort", "3. Smart Bubble Sort", "4. Merge Sort",
				"5. Quick Sort\n" };
		for (int i = 0; i < flavorText.length; i++)
			System.out.println(flavorText[i]);

		while (true) {
			int[] unsorted = { 5, 12, 10, 6, 8, 1 };
			System.out.print("Please enter a option for a sorting algorithm: ");
			int userInput = myInput.nextInt();
			switch (userInput) {
			case 1:
				sortObject.selectionSort(unsorted);
				break;
			case 2:
				sortObject.insertionSort(unsorted);
				break;
			case 3:
				sortObject.bubbleSort(unsorted);
				break;
			case 4:
				sortObject.mergeSort(unsorted);
				for (int a = 0; a < unsorted.length; a++)
					System.out.print(unsorted[a] + " ");
				System.out.println(" ");
				break;
			case 5:
				sortObject.quickSort(unsorted);
				for (int a = 0; a < unsorted.length; a++)
					System.out.print(unsorted[a] + " ");
				System.out.println(" ");
				break;
			default:
				break;
			}
		}
	}
}
