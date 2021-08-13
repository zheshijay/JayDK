package algo.string_and_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection{
	/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
	 */

	public int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		Set<Integer> intersection = new HashSet<>();

		int i=0;
		while(i<nums1.length){
			set.add(nums1[i]);
			i++;
		}

		int j=0;
		while(j<nums2.length){
			if(set.contains(nums2[j])) intersection.add(nums2[j]);
			j++;
		}


		//convert to int array
		int[] res = new int[intersection.size()];
		int k = 0;
		for (Integer num : intersection) {
			res[k++] = num;
		}
		return res;
//
//		return intersection.toArray(new Integer[intersection.size()]);
	}

	// 2 pointers solution
	public int[] intersection2(int[] nums1, int[] nums2) {
		return null;
	}
	


	public static void main(String args[]){
		ArrayIntersection test = new ArrayIntersection();
		int[] nums1 = new int[]{1, 2, 2, 1};
		int[] nums2 = new int[]{2, 2};

		System.out.println(Arrays.toString(test.intersection(nums1, nums2)));
	}

}
