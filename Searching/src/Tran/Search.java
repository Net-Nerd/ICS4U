package Tran;

/**
 * Search class.
 * @author Net_Nerd
 */
public class Search {

	/**
	 * Empty constructor.
	 */
	public void Searcher() {

	}

	public int linearSearch(int[] x, int target) {

		int index = -1;
		for (int i = 0; i < x.length; i++)
			if (x[i] == target)
				index = i;
		return index;
	}

	public int linearSearch(double[] x, double target) {

		int index = -1;
		for (int i = 0; i < x.length; i++)
			if (x[i] == target)
				index = i;
		return index;
	}

	public int linearSearch(String[] x, String target) {

		int index = -1;
		for (int i = 0; i < x.length; i++)
			if (x[i].equals(target))
				index = i;
		return index;
	}

	public int binarySearch(int[] x, int target) {

		int startIndex = 0;
		int endIndex = x.length - 1;
		int midIndex = (startIndex + endIndex) / 2;

		while (startIndex <= endIndex) {
			if (target == x[midIndex])
				return midIndex;
			else if (target > x[midIndex])
				startIndex = midIndex + 1;
			else if (target < x[midIndex])
				endIndex = midIndex - 1;
			midIndex = (startIndex + endIndex) / 2;
		}

		if (midIndex == 0 || midIndex == x.length - 1)
			return -1;
		else
			return midIndex;
	}

	public int binarySearch(double[] x, double target) {

		int startIndex = 0;
		int endIndex = x.length - 1;
		int midIndex = (startIndex + endIndex) / 2;

		while (startIndex <= endIndex) {
			if (target == x[midIndex])
				return midIndex;
			else if (target > x[midIndex])
				startIndex = midIndex + 1;
			else if (target < x[midIndex])
				endIndex = midIndex - 1;
			midIndex = (startIndex + endIndex) / 2;
		}
		if (midIndex == 0 || midIndex == x.length - 1)
			return -1;
		else
			return midIndex;
	}

	public int binarySearch(String[] x, String target) {

		int startIndex = 0;
		int endIndex = x.length - 1;
		int midIndex = (startIndex + endIndex) / 2;

		while (startIndex <= endIndex) {
			if (target.equals(x[midIndex]))
				return midIndex;
			else if (target.compareTo(x[midIndex]) > 0)
				startIndex = midIndex + 1;
			else if (target.compareTo(x[midIndex]) < 0)
				endIndex = midIndex - 1;
			midIndex = (startIndex + endIndex) / 2;
		}
		if (midIndex == 0 || midIndex == x.length - 1)
			return -1;
		else
			return midIndex;
	}
}
