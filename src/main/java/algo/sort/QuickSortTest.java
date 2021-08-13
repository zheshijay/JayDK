package algo.sort;

import java.util.Arrays;

public class QuickSortTest {
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
	
	private void quickSort(int[] nums) {
		int length = nums.length;
		sort(nums, 0, length-1);
	}
	
	private int partition(int[] nums, int left, int right) {
		// 取最后一个当做pivot （可以随意取任何一个数字）
		int pivot = nums[right];
		// 从当前区间的第一个开始比较
		int index = left;

		for(int i = left; i< right; i++) {
			if(nums[i] < pivot) {
				swap(nums, i, index++);
			}
		}

		// pivot放到排好序的区间的 下一个位置
		swap(nums, index, right);
		
		// 返回pivot的下标
		return index;
	}
	
	

	private void sort(int[] nums, int left, int right) {
		if (left < right) {
			int pivot = partition(nums, left, right);
			sort(nums, left, pivot-1);
			sort(nums, pivot+1, right);
		}
	}
	
	
	// Driver program
	public static void main(String args[]) {
		QuickSortTest test = new QuickSortTest();
		
		int[] nums = { 10, 7, 8, 9, 1, 5 };
		test.quickSort(nums);
		System.out.println(Arrays.toString(nums));
		
	}
}