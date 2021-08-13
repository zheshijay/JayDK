package algo.jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 */

public class Q040getTopK {
	public int[] getLeastNumbers(int[] arr, int k) {
		int[] vec = new int[k];
		Arrays.sort(arr);
		for (int i = 0; i < k; ++i) {
			vec[i] = arr[i];
		}
		return vec;
	}

	/*
	 * Heap
	 * 
	 */
	public int[] getLeastNumbers2(int[] arr, int k) {
		int[] vec = new int[k];
		if (k == 0) { // 排除 0 的情况
			return vec;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return num2 - num1;
			}
		});
		for (int i = 0; i < k; ++i) {
			queue.offer(arr[i]);
		}
		for (int i = k; i < arr.length; ++i) {
			if (queue.peek() > arr[i]) {
				queue.poll();
				queue.offer(arr[i]);
			}
		}
		for (int i = 0; i < k; ++i) {
			vec[i] = queue.poll();
		}
		return vec;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * quick sort, patition
	 */
	public int[] getTop3(int[] nums, int k) {
		
		if (k == 0 || nums.length == 0) {
			return new int[0];
		}
		
		return quickSearch(nums, 0, nums.length-1, k-1);
	}

	private int[] quickSearch(int[] nums, int start, int end, int k) {
		int pIndex = patition(nums, start, end, k);
		if (pIndex == k) {
			return Arrays.copyOf(nums, pIndex + 1);
		} else if (pIndex < k) {
			return quickSearch(nums, pIndex+1, end, k);
		} else {
			return quickSearch(nums, start, pIndex-1, k);
		}
	}

	private int patition(int[] nums, int start, int end, int k) {
		int pivot = nums[end];
		int pIndex = start;
		
		for (int i = start; i< end; i++) {
			if (nums[i] > pivot) {
				swap(nums, i, pIndex);
				pIndex++;
			}
		}
		swap(nums, end, pIndex);
		return pIndex;
	}

	private void swap(int[] nums, int x, int y) {
		int tmp = nums[y];
		nums[y] = nums[x];
		nums[x] = tmp;
	}

	/*
	 * Use priority queue
	 */
	public int[] getLeastNumbers4(int[] nums, int k) {
//		Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v1 - v2);
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		for (int i=0; i< nums.length; i++) {
			queue.add(nums[i]);
		}
		
		int[] res = new int[k];
		int j =0;
		while(j < k) {
			res[j] = queue.poll();
			j++;
		}
		return res;
	}
	
	public static void main(String[] args) {
//		Q040getTopK test = new Q040getTopK();
//		
//		int[] nums = new int[] {4,6,9,8,2,1};
//		int k =3;
//		
////		int[] leastNums = test.getLeastNumbers3(nums, k);
//		int[] leastNums = test.getLeastNumbers4(nums, k);
//		System.out.println(Arrays.toString(leastNums));
		System.out.println(1<<1);
		System.out.println(1<<2);
		System.out.println(1<<3);
		System.out.println(1<<4);
		
	}
	
	

}