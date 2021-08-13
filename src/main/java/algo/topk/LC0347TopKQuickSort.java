package algo.topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0347TopKQuickSort {

	public int[] topKFrequent(int[] nums, int k) {
		
		// 初始化待排序的 num-count 数组，然后对count进行排序
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		List<int[]> values = new ArrayList<int[]>(); //对List里面的int[] 进行排序. [0]是数字，[1]是出现次数
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        
        int target = values.size() - k; // 第k个频繁的数字，就是对count排序以后第size-k大的数字

        int left = 0, right = values.size()-1;
        List<int[]> res = new ArrayList<int[]>();

        while (left <= right) {
        	int pivot = partition(values, left, right); // 排序以后返回pivot，第pivot个元素就是排序后的第pivot大的元素
        	if (pivot == target) {
        		 res = values.subList(target, values.size()); // 这里values已经排序到pivot这个点
        		 System.out.println("----> final res: " + Arrays.deepToString(res.toArray()));
        		break;
        	} else if(pivot < target){ // 如果比target小，就没有必要排序左边的了，left = pivot + 1
        		left = pivot + 1;
        	} else {
        		right = pivot - 1;
        	}
        }
        
        System.out.println("----> final: " + Arrays.deepToString(values.toArray()));
        
        int[] ret = new int[k];
        int idx = 0;
        for(int[] num: res) {
        	ret[idx++] = num[0];
        }
        return ret;
	}

	private int partition(List<int[]> values, int left, int right) {
		int pivot = values.get(right)[1];
		int index = left;
		for (int i = left; i < right; i++) {
			System.out.println("value:" + values.get(i)[1] + "|pivot:" + pivot);
			if(values.get(i)[1] < pivot) {
				System.out.println("--swag--");
				Collections.swap(values, i, index++);
			}
		}
		Collections.swap(values, right, index);
		return index;
	}

	public static void main(String[] args) {
		LC0347TopKQuickSort test = new LC0347TopKQuickSort();
		int[] nums = new int[] { 1, 2, 2, 2, 3, 4, 5, 5 };
//		int[] nums = new int[] { 1,1,1,2,2,3 };

		int[] res = test.topKFrequent(nums, 2);
		System.out.println(Arrays.toString(res));
	}
}
