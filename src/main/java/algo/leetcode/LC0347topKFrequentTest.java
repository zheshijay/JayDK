package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0347topKFrequentTest {

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
//	public int[] topKFrequent(int[] nums, int k) {
//		Map<Integer, Integer> numMap = new HashMap<>();
//		for (int num : nums) {
//			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
//		}
//
//		System.out.println("numMap:" + numMap);
//		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
//
//		// Add to queue
//		for (Integer num : numMap.keySet()) {
//			int count = numMap.get(num);
//			if (pq.size() == k) {
//				if (pq.peek()[1] < count) {
//					pq.poll();
//					pq.offer(new int[] { num, count });
//				}
//			} else {
//				pq.offer(new int[] { num, count });
//			}
//		}
//
//		// get k elements from queue
//		int[] res = new int[k];
//		for (int i = 0; i < k; i++) {
//			res[i] = pq.poll()[0];
//		}
//		return res;
//	}
	
//	public int[] topKFrequent(int[] nums, int k) {
//		
//		// get nums count
//		Map<Integer, Integer> numsMap = new HashMap<>();
//		for(int num: nums) {
//			numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
//		}
//
//		List<int[]> numsList = new ArrayList<>();
//		for(Map.Entry<Integer, Integer> entry: numsMap.entrySet()) {
//			numsList.add(new int[] {entry.getKey(), entry.getValue()});
//		}
//		 System.out.println("numsList: " + Arrays.deepToString(numsList.toArray()));
//		
//		int target = numsList.size() - k;
//		int left = 0, right = numsList.size() - 1;
//		 List<int[]> res = new ArrayList<int[]>();
//		// partition get (size-k)th elements
//		while(true) {
//			int pivot = partition(numsList, left, right);
//			if (pivot == target) {
//				res = numsList.subList(target, numsList.size());
//				break;
//			} else if (pivot < target) {
//				right = pivot + 1;
//			} else {
//				left = pivot - 1;
//			}
//		}
//		
//		 int[] ret = new int[k];
//	        int idx = 0;
//	        for(int[] num: res) {
//	        	ret[idx++] = num[0];
//	        }
//	        return ret;
//		
//	}
//
//	private int partition(List<int[]> numsList, int left, int right) {
//		int pivot = numsList.get(right)[1];
//		int index = left;
//		for(int i=left; i< right; i++) {
//			if (numsList.get(i)[1] < pivot) {
////				swap(numsList, i, index);
//				Collections.swap(numsList, i, index);
//				index++;
//			}
//		}
//		Collections.swap(numsList, right, index);
//		return index;
//	}
	
	// sol 2: Queue
	public int[] topKFrequent(int[] nums, int k) { 
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}

		System.out.println("numMap:" + numMap);
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

		// Add to queue
		for (Integer num : numMap.keySet()) {
			int count = numMap.get(num);
			System.out.println("pq:" + pq);
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
		LC0347topKFrequentTest test = new LC0347topKFrequentTest();
		int[] nums = new int[] { 1, 2, 2, 2, 3, 4, 5, 5 };
//		int[] nums = new int[] { 1,1,1,2,2,3 };
		int[] res = test.topKFrequent(nums, 2);
		System.out.println(Arrays.toString(res));
	}
}
