package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC0658findClosestElements {

	/*
	 * 2 pointers
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int size = arr.length;

		int left = 0;
		int right = size - 1;

		int removeNums = size - k;
		while (removeNums > 0) {
			if (x - arr[left] <= arr[right] - x) {
				right--;
			} else {
				left++;
			}
			removeNums--;
		}

		List<Integer> res = new ArrayList<>();
		for (int i = left; i < left + k; i++) {
			res.add(arr[i]);
		}
		return res;
	}

	/*
	 * binary search
	 */
	public List<Integer> findClosestElements2(int[] arr, int k, int x) {

		List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int n = ret.size();
		if (x <= ret.get(0)) {
			return ret.subList(0, k);
		} else if (ret.get(n - 1) <= x) {
			return ret.subList(n - k, n);
		} else {
			int index = Collections.binarySearch(ret, x);

			if (index < 0) {
				index = -index - 1;
			}
			int low = Math.max(0, index - k - 1);
			int high = Math.min(ret.size() - 1, index + k - 1);
			while (high - low > k - 1) {
				if ((x - ret.get(low)) <= (ret.get(high) - x)) {
					high--;
				} else {
					low++;
				}
			}
			return ret.subList(low, high + 1);
		}
	}

	public static void main(String[] args) {
		LC0658findClosestElements test = new LC0658findClosestElements();

		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		List<Integer> res = test.findClosestElements(nums, 4, 3);
		System.out.println(res);

	}

}
