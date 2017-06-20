package qa;

import java.util.HashMap;
import java.util.Map;

public class MyTwoSum2 {
	public static int[] twoSum(int[] nums, int target){
		int[] index = new int[2];
		
		Map<Integer, Integer> sumMap = new HashMap();
		for(int i=0; i<nums.length; i++){
			int temp = target - nums[i];
			
			if(!sumMap.containsKey(temp)) sumMap.put(nums[i], i);
			else{
				index[0] = i;
				index[1] =  sumMap.get(temp);
			}
		}
		
		return index;
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		
		int[] index = MyTwoSum2.twoSum(nums, 7);
		
		
		for(int each: index){
			System.out.println(each);
		}

	}

}
