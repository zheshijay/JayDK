package leetcode;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    Map<Integer, Integer> storeMap = new HashMap<Integer, Integer>();
    public void store(int input) {
        //if the input value exists in the map
        if (storeMap.containsKey(input)) {
            storeMap.put(input, storeMap.get(input) + 1);
        } else {
            storeMap.put(input, 1);
        }
    }

    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    public boolean test(int val) {
        for (Integer currVal : storeMap.keySet()) {
            Integer otherNumber = val - currVal;
            //if the map contains the other number
            if (storeMap.containsKey(otherNumber)) {
                if (otherNumber.equals(currVal)) {
                    //If the number is the same as current, then check if another number exists
                    Integer count = storeMap.get(currVal);
                    //another same number exists
                    if (count > 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[] myTwoSum(int[] nums, int target) {
    	for(int i=0; i<nums.length; i++){
    		for(int j=i; j< nums.length; j++){
    			if(nums[i] + nums[j] == target){
    				return new int[]{i, j};
    			}
    		}
    	}
    	return null;
    }
    
    

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.store(1);
        twoSum.store(-2);
        twoSum.store(3);
        twoSum.store(6);
        twoSum.store(6);

        int[] nums = new int[]{2,7,11,15};
        int[] indices = twoSum.myTwoSum(nums, 18);
        
        for(int eachNum: indices){
            
            System.out.println("Test " + eachNum);
        }

//        System.out.println("Test " + twoSum.test(-1));
//        System.out.println("Test " + twoSum.test(9));
//        System.out.println("Test " + twoSum.test(12));
//        System.out.println("Test " + twoSum.test(10));
//        System.out.println("Test " + twoSum.test(5));
//        System.out.println("Test " + twoSum.test(0));
    }
}
