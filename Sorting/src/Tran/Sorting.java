package Tran;

public class Sorting {

	/**
	 * A method used to swap two selected elements within an array. <br>
	 * In this case, swap the source and the destination elements.
	 * 
	 * @param src Source element index.
	 * @param dst Destination element index.
	 * @param unsorted The array in which the swapping occurs.
	 */
	private static int[] swapElements(int src, int dst, int[] unsorted) {
		int temporary = unsorted[src];
		unsorted[src] = unsorted[dst];
		unsorted[dst] = temporary;
		return unsorted;
	}

	/**
	 * Selection Sort is a sorting algorithm which searches for the smallest
	 * element; called the minimum, and then swaps it with the current element
	 * until all elements have been sorted. This works because a new sorted
	 * element is created approaching from the left.
	 * 
	 * The time complexity of the selection sort is defined by Big O notation
	 * multiplied by the number of elements, n, squared.
	 * 
	 * @param unsorted The unsorted array.
	 * @return The sorted array.
	 */
	public int[] selectionSort(int[] unsorted) {

		int counter = 0;
		int minIndex = counter;
		while (counter < unsorted.length - 1) {
			for (int i = counter; i < unsorted.length; i++) {
				if (unsorted[minIndex] >= unsorted[i])
					minIndex = i;
			}
			swapElements(counter, minIndex, unsorted);
			for (int i = 0; i < unsorted.length; i++)
				System.out.print(unsorted[i] + " ");
			System.out.println(" ");
			counter++;
			minIndex = counter;
		}
		return unsorted;
	}

	/**
	 * Insertion sort is a sorting algorithm which starts by forming two halves
	 * of an unsorted array: a sorted portion and an unsorted portion. The
	 * sorted portion always starts at very first element on the left hand side,
	 * and elements following the first are respectively placed to each other in
	 * the sorted portion. The sorted portion must always be sorted at all times
	 * and this continues until the entire array is sorted.
	 * 
	 * The time complexity of the insertion sort is defined by Big O notation
	 * multiplied by the number of elements, n, squared.
	 * 
	 * @param unsorted The unsorted array.
	 * @return The sorted array.
	 */
	public int[] insertionSort(int[] unsorted) {

		int temp, j = 0;
		for (int i = 1; i < unsorted.length; i++) {
			temp = unsorted[i];
			for (j = i - 1; j >= 0 && unsorted[j] > temp; j--)
				unsorted[j + 1] = unsorted[j];
			unsorted[j + 1] = temp;
			for (int a = 0; a < unsorted.length; a++)
				System.out.print(unsorted[a] + " ");
			System.out.println(" ");
		}
		return unsorted;
	}

	/**
	 * This sorting method implements Smart Bubble Sort.
	 * 
	 * Bubble Sort is a sorting algorithm that recieves its name from its nature
	 * to bubble the highest element to the top through each pass of the
	 * unsorted array. It does so by swapping two items at a time if they are
	 * out of order. This creates a sorted portion of the array starting from
	 * the right hand side working downwards to the first element, the minimum.
	 * 
	 * The time complexity of the bubble sort is defined by Big O notation
	 * multiplied by the number of elements, n, squared.
	 * 
	 * @param unsorted The unsorted array.
	 * @return The sorted array.
	 */
	public int[] bubbleSort(int[] unsorted) {
		boolean isSwitched = true;
		int counter = unsorted.length - 1;
		while (isSwitched) {
			isSwitched = false;
			for (int i = 0; i < counter; i++)
				if (unsorted[i] > unsorted[i + 1]) {
					swapElements(i, i + 1, unsorted);
					isSwitched = true;
				}
			counter--;
			for (int a = 0; a < unsorted.length; a++)
				System.out.print(unsorted[a] + " ");
			System.out.println(" ");
		}
		return unsorted;
	}

	/**
	 * Merge sort is a sorting algorithm that uses recursion to divide the array
	 * into smaller arrays with a size of one. Then using a seperate recursive
	 * method, work backwards from the arrays of size one to merge them back
	 * together on both the left hand and the right hand sides until the entire
	 * array is sorted.
	 * 
	 * The time complexity of the merge sort is defined by Big O notation
	 * multiplied by the number of elements, n, multiplied by the logarithm of
	 * the number of elements, n. Note that merge sort is faster than the
	 * previous three sorting algorithms.
	 * 
	 * @param unsorted The unsorted array.
	 * @return The sorted array.
	 */
	public int[] mergeSort(int[] unsorted) {
		splitArray(unsorted, 0, unsorted.length - 1);
		return unsorted;
	}

	/**
	 * Split the array.
	 * 
	 * @param unsorted The unsorted array.
	 * @param startIndex The start of the array.
	 * @param endIndex The end of the array.
	 */
	public void splitArray(int[] unsorted, int startIndex, int endIndex) {

		if (startIndex < endIndex) {
			int midIndex = (endIndex + startIndex) / 2;
			// Split the array here into two parts: One that goes from the start
			// to the middle, and one that goes from the middle + 1 to the end.
			splitArray(unsorted, startIndex, midIndex);
			splitArray(unsorted, midIndex + 1, endIndex);
			mergeArray(unsorted, startIndex, midIndex, endIndex);
		}

	}

	/**
	 * Merge/stitch the array back together.
	 * 
	 * @param unsorted The unsorted array.
	 * @param startIndex The start of the array.
	 * @param midIndex The end of the array.
	 * @param endIndex The middle of the array.
	 */
	public void mergeArray(int[] unsorted, int startIndex, int midIndex, int endIndex) {
		int[] temp = unsorted.clone();
		int leftIndex = startIndex;
		int rightIndex = midIndex + 1;
		int i = startIndex;

		while (leftIndex <= midIndex && rightIndex <= endIndex) {
			if (temp[leftIndex] < temp[rightIndex]) {
				unsorted[i] = temp[leftIndex];
				leftIndex++;
			} else {
				unsorted[i] = temp[rightIndex];
				rightIndex++;
			}
			i++;
		}
		while (leftIndex <= midIndex) {
			unsorted[i] = temp[leftIndex];
			leftIndex++;
			i++;
		}
	}

	/**
	 * Quick Sort is a sorting algorithm that randomly selects an element in the
	 * array called the 'pivot'. Using the pivot, it creates two new seperate
	 * portions within the array that are greater than and less than the pivot,
	 * and then considers the pivot sorted. A new pivot is selected and the two
	 * unsorted sides are recursively sorted using this method until arrays of
	 * size one are reached.
	 * 
	 * In a best case scenario, the time complexity of the quick sort is defined
	 * by Big O notation multiplied by the number of elements, n, multiplied by
	 * the logarithm of the number of elements, n. However, in a worst case
	 * scenario, the time complexity of the quick sort is defined by Big O
	 * notation multiplied by the number of elements, n, squared. So depending
	 * on the number of elements, quick sort will comparatively become better or
	 * worse.
	 * 
	 * @param unsorted The unsorted array.
	 * @return The sorted array.
	 */
	public int[] quickSort(int[] unsorted) {
		qSort(unsorted, 0, unsorted.length - 1);
		return unsorted;
	}

	/**
	 * Runs through one pass of the quick sort algorithm, finding elements that
	 * are higher and lower than the pivot, and swapping them.
	 * 
	 * @param unsorted The unsorted array.
	 * @param leftIndex The left index.
	 * @param rightIndex The right index.
	 */
	public void qSort(int[] unsorted, int startIndex, int endIndex) {

		int pivot = (startIndex + endIndex) / 2;
		int leftSide = startIndex;
		int rightSide = endIndex;
		int pivotArray = unsorted[pivot];

		while (leftSide <= rightSide) {
			while (unsorted[leftSide] < pivotArray)
				leftSide++;
			while (unsorted[rightSide] > pivotArray)
				rightSide--;
			if (leftSide <= rightSide) {
				swapElements(leftSide, rightSide, unsorted);
				leftSide++;
				rightSide--;
			}
		}
		if (startIndex < rightSide)
			qSort(unsorted, startIndex, rightSide);
		if (leftSide < endIndex)
			qSort(unsorted, leftSide, endIndex);
	}
}
