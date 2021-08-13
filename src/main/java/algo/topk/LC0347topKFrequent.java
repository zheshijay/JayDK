package algo.topk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC0347topKFrequent {

	// 大堆，但是需要把所有元素都加入queue
//	public int[] topKFrequent(int[] nums, int k) {
//		Map<Integer, Integer> numMap = new HashMap<>();
//		for (int num : nums) {
//			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
//		}
//
//		System.out.println("numMap:" + numMap);
//
//		  PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[1]-x[1]);
//
//		// Add to queue
//		for (Integer num : numMap.keySet()) {
//			if (pq.size() == k) {
//				pq.poll();
//			}
//			pq.add(new int[] { num, numMap.get(num) });
//		}
//
//		// get k elements from queue
//		int[] res = new int[k];
//		for (int i = 0; i < k; i++) {
//			res[i] = pq.poll()[0];
//		}
//		return res;
//	}

	// 维护数量为K的最小堆
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}

		System.out.println("numMap:" + numMap);
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]); // 自定义排序，按照数组第二个元素排序

		// Add to queue
		for (Integer num : numMap.keySet()) {
			int count = numMap.get(num);
			if (pq.size() == k) {
				if (pq.peek()[1] < count) {
					pq.poll();
					pq.offer(new int[] { num, count });
				}
			} else {
				pq.offer(new int[] { num, count });
			}
		}

		// get k elements from queue
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll()[0];
		}
		return res;
	}

	public static void main(String[] args) {
		LC0347topKFrequent test = new LC0347topKFrequent();
		int[] nums = new int[] { 1, 2, 2, 2, 3, 4, 5, 5 };
		int[] res = test.topKFrequent(nums, 2);
		System.out.println(Arrays.toString(res));
	}
}
