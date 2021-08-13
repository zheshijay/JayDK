package algo.string_and_array;

import java.util.Arrays;

public class MergeSortedArray {

	public int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		int p1 = 0, p2 = 0, p3 = 0;
		int len1 = nums1.length, len2 = nums2.length;

		int[] res = new int[m + n];

		/**
		 * 
		 * p1 -> 1 3 5 7 p2 -> 2 4
		 * 
		 * p3 -> [ 1, 2, ... ]
		 * 
		 */

		while (p1 < len1 && p2 < len2) {

			System.out.print("nums1[p1]: " + nums1[p1] + " - " + "nums2[p2]: " + nums1[p2]);

			System.out.println();
			if (nums1[p1] < nums2[p2]) {
				System.out.println("----------------------> adding " + nums1[p1] + " from num1");
				res[p3] = nums1[p1]; // add a value to new array
				p3++; // move index to next
				p1++;
			} else {
				System.out.println("----------------------> adding " + nums2[p2] + " from num2");
				res[p3] = nums2[p2]; // add a value to new array
				p3++; // move index to next
				p2++;
			}
		}

		System.out.println("===> p1:" + p1 + " -  p2: " + p2);

		if (p1 < len1) {
			System.out.println(" adding rest of p1 ");

			while (p1 < len1) {
				res[p3] = nums1[p1];
				p1++;
				p3++;
			}

		} else {
			System.out.println(" adding rest of p2 ");
			while (p2 < len2) {
				res[p3] = nums2[p2];
				p2++;
				p3++;
			}
		}

		return res;

	}
	
	
	

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		// Make a copy of nums1.
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);

		// Two get pointers for nums1_copy and nums2.
		int p1 = 0;
		int p2 = 0;

		// Set pointer for nums1
		int p = 0;

		// Compare elements from nums1_copy and nums2
		// and add the smallest one into nums1.
		while ((p1 < m) && (p2 < n))
			nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

		// if there are still elements to add
		if (p1 < m)
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		if (p2 < n)
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
	}
	
	 public static void merge3(int[] nums1, int m, int[] nums2, int n) {
		    // two get pointers for nums1 and nums2
		    int p1 = m - 1;
		    int p2 = n - 1;
		    // set pointer for nums1
		    int p = m + n - 1;

		    // while there are still elements to compare
		    while ((p1 >= 0) && (p2 >= 0))
		      // compare two elements from nums1 and nums2 
		      // and add the largest one in nums1 
		      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

		    // add missing elements from nums2
		    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
		  }


	public static void main(String[] args) {
//			MergeSortedArray test = new MergeSortedArray();
//			
////			int[] nums1 = new int[]{1,3,5};
////			int[] nums2 = new int[]{2,4,7};
//			
//			int[] nums1 = new int[]{0};
//			int[] nums2 = new int[]{1};
//			
//			int[] res = test.mergeSortedArray(nums1, 1, nums2, 1);
//			
//			System.out.println(res);
//			
//			for(int num: res){
//				System.out.print(num + " ");
//			}

		int[] nums1 = new int[] { 1, 3, 5 };
		int[] nums2 = new int[] { 2, 4, 7 };
		
		System.arraycopy(nums2, 0, nums1, 0, nums2.length);
		System.out.println(Arrays.toString(nums2));
	}

}
