package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0202isHappyNum {
	/*
	 * Solution 1: Use hash
	 */
	private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
	/*
	 * Solution 2: 2 pointer2，快慢指针-龟兔赛跑 (https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/)
	 */
	 public int getNext(int n) {
	        int totalSum = 0;
	        while (n > 0) {
	            int d = n % 10;
	            n = n / 10;
	            totalSum += d * d;
	        }
	        return totalSum;
	    }

	    public boolean isHappy(int n) {
	        int slowRunner = n;
	        int fastRunner = getNext(n);
	        while (fastRunner != 1 && slowRunner != fastRunner) {
	            slowRunner = getNext(slowRunner);
	            fastRunner = getNext(getNext(fastRunner));
	        }
	        return fastRunner == 1;
	    }
	

	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		printMax(arr, arr.length, k);
	}
}
