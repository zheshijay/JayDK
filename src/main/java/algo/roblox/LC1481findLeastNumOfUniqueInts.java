package algo.roblox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1481findLeastNumOfUniqueInts {
	
	public int findLeastNumOfUniqueInts(int[] nums, int k) {
		Map<Integer, Integer> ncMap = new HashMap<>();
		for(int num: nums) {
			ncMap.put(num, ncMap.getOrDefault(num, 0) + 1);
		}
		
		// convert ncMap to array for sorting
		List<int[]> freq = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry: ncMap.entrySet()) {
			freq.add(new int[] {entry.getKey(), entry.getValue()});
		}
		
		Collections.sort(freq, (x, y)->{return x[1] - y[1];});
		int numOfUniqueNums = freq.size();
		for(int i = 0; i < freq.size(); i++) {
			int occr = freq.get(i)[1];
			
			if (k >= occr) {
				numOfUniqueNums--;
				 k -= occr;
			} else {
				break;
			}
		}
		return numOfUniqueNums;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {5,5,4};
		int k = 1;
		
		LC1481findLeastNumOfUniqueInts test = new LC1481findLeastNumOfUniqueInts();
		int res = test.findLeastNumOfUniqueInts(nums, k);
		System.out.println("res:" + res);
	}
	
}
