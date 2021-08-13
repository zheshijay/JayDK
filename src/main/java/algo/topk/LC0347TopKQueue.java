package algo.topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC0347TopKQueue {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		List<int[]> values = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			values.add(new int[] { entry.getKey(), entry.getValue() });
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]); // 小堆，从小到大排序，peek拿到的是最小的，用于和新的值比较
		for (int[] v : values) {
			if (q.size() == k) {
				if (q.peek()[1] < v[1]) {
					q.poll();
					q.offer(v);
				}
			} else {
				q.add(v);
			}
		}

		int[] res = new int[k];
		int idx = 0;
		while (idx < k) {
			res[idx++] = q.poll()[0];
		}
		return res;
	}

	public static void main(String[] args) {
		LC0347TopKQueue test = new LC0347TopKQueue();
		int[] nums = new int[] { 1, 2, 2, 2, 3, 4, 5, 5 };
//		int[] nums = new int[] { 1,1,1,2,2,3 };

		int[] res = test.topKFrequent(nums, 2);
		System.out.println(Arrays.toString(res));
	}
}
