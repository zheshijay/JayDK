package algo.leetcode;

import java.util.HashSet;

public class LC0287findDuplicateInArray {
	/*
	 * binary search
	 */
	
	 public int findDuplicate(int[] nums) {
	        int n = nums.length;
	        int l = 1, r = n - 1, ans = -1;
	        while (l <= r) {
	            int mid = (l + r)/ 2;
	            int cnt = 0;
	            for (int i = 0; i < n; ++i) {
	                if (nums[i] <= mid) {
	                    cnt++;
	                }
	            }
	            if (cnt <= mid) {
	                l = mid + 1;
	            } else {
	                r = mid - 1;
	                ans = mid;
	            }
	        }
	        return ans;
	    }

	 /*
	  * Fast slow pointers
	  */
	  public int findDuplicate2(int[] nums) {
	        int slow = 0, fast = 0;
	        do {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        } while (slow != fast);
	        slow = 0;
	        
	        while (slow != fast) {
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        return slow;
	    }

	  /*
	   * Hash
	   */
	  public int findDuplicate3(int[] nums) {
		    HashSet<Integer> set = new HashSet<>();
		    for (int i = 0; i < nums.length; i++) {
		        if (set.contains(nums[i])) {
		            return nums[i];
		        }
		        set.add(nums[i]);
		    }
		    return -1;
		}
	  
	  
	  public static void main(String[] args) {
		  LC0287findDuplicateInArray test = new LC0287findDuplicateInArray();
		  int[] nums = new int[] {1,3,4,2,2};
		 System.out.println(test.findDuplicate2(nums));
		  
		  
	}
}
