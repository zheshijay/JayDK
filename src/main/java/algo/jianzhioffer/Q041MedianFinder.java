package algo.jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 */

public class Q041MedianFinder {
	 Queue<Integer> A, B;
	    public Q041MedianFinder() {
	        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
	        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
	    }
	    public void addNum(int num) {
	        if(A.size() != B.size()) {
	            A.add(num);
	            B.add(A.poll());
	        } else {
	            B.add(num);
	            A.add(B.poll());
	        }
	    }
	    public double findMedian() {
	        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
	    }
}