package algo.topk;

import java.util.PriorityQueue;

public class LC0215findKthLargest_S2_Use_Heap {
	public int findKthLargest(int[] nums, int k) {
		final PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int val : nums) {
			queue.add(val);
			if (queue.size() > k)
				queue.poll();
		}
		return queue.peek();
	}

	// Driver code
	public static void main(String args[]) {
		LC0215findKthLargest_S2_Use_Heap test = new LC0215findKthLargest_S2_Use_Heap();

//		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		int[] nums = new int[] { 4, 5, 1, 2, 3 };

		int res = test.findKthLargest(nums, 2);
		System.out.println("res:" + res);
	}
}
