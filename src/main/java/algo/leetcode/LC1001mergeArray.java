package algo.leetcode;

import java.util.Arrays;

public class LC1001mergeArray {

	// sol1: use extra space
	public void merge(int[] A, int m, int[] B, int n) {
		int[] merged = new int[m + n];
		int lastSorted = 0, aIdx = 0, bIdx = 0;
		int cur;
		while (aIdx < m || bIdx < n) {
			if (aIdx == m) {
				cur = B[bIdx++];
			} else if (bIdx == n) {
				cur = A[aIdx++];
			} else if (A[aIdx] > B[bIdx]){
				cur = B[bIdx++];
			} else {
				cur = A[aIdx++];
			}
			merged[lastSorted++] = cur;
		}
		
		 for (int i = 0; i != m + n; ++i) {
	            A[i] = merged[i];
	        }
	}
	
	// sol2: update bal from tail
		public void merge2(int[] A, int m, int[] B, int n) {
			int tail = m + n -1, aTail = m-1, bTail = n-1;
		
			int cur;
			while (aTail >=0 || bTail >=0) {
				if (aTail == -1) {
					cur = B[bTail--];
				} else if (bTail == -1) {
					cur = A[aTail--];
				} else if (A[aTail] > B[bTail]){
					cur = A[aTail--];
				} else {
					cur = B[bTail--];
				}
				A[tail--] = cur;
			}
			
		
		}

	public void loopTest() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 2)
					break;
				System.out.println("i:" + i + "|j:" + j);

			}
		}
	}

	private void move(int index, int[] A) {
		for (int i = A.length - 1; i > index; i--) {
			A[i] = A[i - 1];
		}
	}

	public static void main(String[] args) {
		LC1001mergeArray test = new LC1001mergeArray();

		int[] A = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] B = new int[] { 2, 5, 6 };
		test.merge2(A, 3, B, 3);
		
//		int[] A = new int[] { 1 };
//		int[] B = new int[] {  };
//		test.merge2(A, 1, B, 0);
		
//		test.loopTest();

		System.out.println(Arrays.toString(A));

	}
}
