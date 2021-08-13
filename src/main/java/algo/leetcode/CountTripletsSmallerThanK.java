package algo.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 12
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)
 */
public class CountTripletsSmallerThanK {

	static int arr[] = new int[] { 5, 1, 3, 4, 7 };

	// Brute force
	int countTriplets(int n, int sum) {
		// Initialize result
		int ans = 0;

		// Fix the first element as A[i]
		for (int i = 0; i < n - 2; i++) {
			// Fix the second element as A[j]
			for (int j = i + 1; j < n - 1; j++) {
				// Now look for the third number
				for (int k = j + 1; k < n; k++)
					if (arr[i] + arr[j] + arr[k] < sum)
						ans++;
			}
		}

		return ans;
	}

	/*
	 * 2 pointers
	 */
	static int countTriplets2(int n, int sum) {
		// Sort input array
		Arrays.sort(arr);

		// Initialize result
		int ans = 0;

		// Every iteration of loop counts triplet with
		// first element as arr[i].
		for (int i = 0; i < n - 2; i++) {
			// Initialize other two elements as corner elements
			// of subarray arr[j+1..k]
			int j = i + 1, k = n - 1;

			// Use Meet in the Middle concept
			while (j < k) {
				// If sum of current triplet is more or equal,
				// move right corner to look for smaller values
				if (arr[i] + arr[j] + arr[k] >= sum)
					k--;

				// Else move left corner
				else {
					// This is important. For current i and j, there
					// can be total k-j third elements.
					ans += (k - j);
					j++;
				}
			}
		}
		return ans;
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		printMax(arr, arr.length, k);
	}
}
