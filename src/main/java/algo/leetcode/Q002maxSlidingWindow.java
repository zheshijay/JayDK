package algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q002maxSlidingWindow {
	/*
	 * Solution 1: 暴力
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) 
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
	
	/*
	 * Solution 2: Use MaxHeap ( Priority Queue )
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		 int n = nums.length;
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
	            public int compare(int[] pair1, int[] pair2) {
	                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
	            }
	        });
	        for (int i = 0; i < k; ++i) {
	            pq.offer(new int[]{nums[i], i});
	        }
	        int[] ans = new int[n - k + 1];
	        ans[0] = pq.peek()[0];
	        for (int i = k; i < n; ++i) {
	            pq.offer(new int[]{nums[i], i});
	            while (pq.peek()[1] <= i - k) {
	                pq.poll();
	            }
	            ans[i - k + 1] = pq.peek()[0];
	        }
	        return ans;
	}

	/*
	 * Solution 2: 双向队列
	 */
	public int[] maxSlidingWindow3(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();   
            } 
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

	
	// Driver code
	public static void main(String args[]) {
		Q002maxSlidingWindow test = new Q002maxSlidingWindow();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		int[] res = test.maxSlidingWindow2(arr, k);
		
		System.out.println(Arrays.toString(res));
		
	}
}
