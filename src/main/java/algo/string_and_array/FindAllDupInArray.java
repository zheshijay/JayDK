package algo.string_and_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDupInArray {

	/*
Given an array of integers, 1 �? a[i] �? n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
	 */

	// use Set
	public List<Integer> findDuplicates(int[] nums) {

		Set<Integer> set = new HashSet<>();

		List<Integer> dup = new ArrayList<>();

		int i = 0;
		while(i<nums.length){
			if(set.contains(nums[i])) dup.add(nums[i]);
			else set.add(nums[i]);

			i++;
		}
		return dup;
	}

	// when find a number i, flip the number at position i-1 to negative. 
	// if the number at position i-1 is already negative, i is the number that occurs twice.
	public List<Integer> findDuplicatesWithSet(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < nums.length; ++i) {
			
			int index = Math.abs(nums[i])-1;
			
			System.out.println("index:" + index);
			
			if (nums[index] < 0)
				res.add(Math.abs(index+1));
			
			nums[index] = -nums[index];
		}
		return res;
	}

	public static void main(String[] args){
		FindAllDupInArray test = new FindAllDupInArray();

		int[] nums1 = new int[]{4,3,2,7,8,2,3,1};

		System.out.println(test.findDuplicatesWithSet(nums1));

	}
}
