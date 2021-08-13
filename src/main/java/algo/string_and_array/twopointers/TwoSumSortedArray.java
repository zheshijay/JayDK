package algo.string_and_array.twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSortedArray {

	//use buffer
	public static int[] twoSum(int[] nums, int target) {
	    if(nums==null || nums.length<2)
	        return new int[]{0,0};
	 
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    
	    for(int i=0; i<nums.length; i++){
	        if(map.containsKey(nums[i])){
//	            return new int[]{map.get(nums[i]), i}; this is index, but the requirement is return index count from 1
	        	return new int[]{map.get(nums[i]) + 1, i + 1};
	        	
	        }else{
	            map.put(target-nums[i], i);
	        }
	    }
	 
	    return new int[]{0,0};
	}
	//without buffer
	public int[] twoSum2(int[] num, int target) {
	    int[] indice = new int[2];
	    if (num == null || num.length < 2) return indice;
	    
	    int left = 0, right = num.length - 1;
	    
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}

	
	public static void printArray(int[] nums){
		for(int num:nums){
			System.out.print(num + " ");
			
		}
		
	}


	public static void main(String args[]){
		int[] nums = new int[]{1, 2, 3, 4, 5};
		
		int[] indice = new int[2]; 
		
		indice = TwoSumSortedArray.twoSum(nums, 5);
		
		TwoSumSortedArray.printArray(indice);
	

	}
}
