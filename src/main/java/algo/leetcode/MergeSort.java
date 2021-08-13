package algo.leetcode;


public class MergeSort {
	private int[] numbers;
	private int[] helper;
	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		divide(0, number-1);
	}

	private void divide(int low, int high) {
		System.out.println("low:"+low + "  " +"high:"+high);

		// // If there are more than one element
		if (low < high) {
			System.out.println("----- low < high");
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			divide(low, middle);
			// Sort the right side of the array
			divide(middle + 1, high);
			// Combine them both
			
			combine(low, middle, high);
		}
	}

	private void combine(int low, int middle, int high) {
		System.out.println("merge...");

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}


	public static void main(String a[]){

		int[] inputArr = {11,66,33,88,55,22,77,44,99};
		MergeSort mms = new MergeSort();

		System.out.println("before sort : ");
		for(int i:inputArr){
			System.out.print(i+" ");
		}

		//Sort
		mms.sort(inputArr);

		System.out.println();
		System.out.println("after sort : ");
		for(int i:inputArr){
			System.out.print(i+" ");
		}
	}
}
