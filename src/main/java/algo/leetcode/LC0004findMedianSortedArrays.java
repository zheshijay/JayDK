package algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC0004findMedianSortedArrays {

	// 2pointer: Move (a.length + b.length)/2 steps
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int len = m + n;
		int left = -1, right = -1;
		int aStart = 0, bStart = 0;
		for (int i = 0; i <= len / 2; i++) {
			left = right;
			if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
				right = A[aStart++];
			} else {
				right = B[bStart++];
			}
		}
		if ((len & 1) == 0)
			return (left + right) / 2.0;
		else
			return right;
	}

	// Binary Search
	public double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int totalLeft = (m + n) / 2;
		int left=0, right=m;
		while (left < right) {
			int i = (left + right + 1) / 2;
			int j = totalLeft - i;
			
			if (A[i-1] > B[j]) {
				right = i-1;
			} else {
				left = i;
			}
		}
		
		int i = left;
		int j = totalLeft - i;
		
		int aLeft = A[i-1];
		int aRight = A[i];
		int bLeft =  B[j-1];
		int bRight = B[j];

		if ((m+n)%2 == 1) {
			return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
		} else {
			return Math.max(aLeft, bLeft);
		}

	}

	public static void main(String[] args) {
//		int[] nums1 = new int[] {1,3};
//		int[] nums2 = new int[] {2};

		int[] nums1 = new int[] { 2, 100 };
		int[] nums2 = new int[] { 1 };

		LC0004findMedianSortedArrays test = new LC0004findMedianSortedArrays();
		double res = test.findMedianSortedArrays(nums1, nums2);
		System.out.println(res);

	}

}
