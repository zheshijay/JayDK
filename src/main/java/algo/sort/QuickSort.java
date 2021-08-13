package algo.sort;

import java.util.Arrays;

public class QuickSort {

	
	private void sort(int[] a, int left, int right) {
		if(left < right) {
			int pivot = partition(a, left, right);
			sort(a, left, pivot-1);
			sort(a, pivot+1, right);
		}
	}

	
	private int partition(int[] a, int left, int right) {
		int pivot = a[right];
		int idx = left;
		for(int i=left; i<a.length; i++) {
			if (a[i] < pivot) {
				swap(a, i, idx);
				idx++;
			}
		}
		swap(a, right, idx);
		return idx;
	}


	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	// Driver program
	public static void main(String args[]) {
		int a[] = { 10, 7, 8, 9, 1, 5 };
		int n = a.length;

		QuickSort test = new QuickSort();
		test.sort(a, 0, n - 1);

		System.out.println("sorted array:" + Arrays.toString(a));
	}

	

}