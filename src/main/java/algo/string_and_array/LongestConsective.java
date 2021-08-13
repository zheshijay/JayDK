package algo.string_and_array;

import java.util.HashSet;

/*
 * 
 * 
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.

Your algorithm should run in O(n) complexity.


Solution:
 
 Use HashSet's uniqueness, so we can easily know, for number a if a[i-1] and a[i+1] is in the array, if found then check a[i+2] and a[i-2], 
 remove visited values from set, until the set is null ( visited all values)
 




 */
public class LongestConsective {public int longestConsecutive(int[] nums) {
	  int longest = Integer.MIN_VALUE;
	  
	  
	  HashSet<Integer> set = new HashSet<Integer>();
	  int p=0;
	  
	  while(p<nums.length){
	    set.add(nums[p++]);
	  }
	  
	  for(int i=0; i<nums.length; i++){
	      
	     int up=nums[i] + 1, down = nums[i]-1;
	    
	     while(set.contains(up)){
	          up++;
	     }
	    
	     while(set.contains(down)){
	          down--;
	     }
	    
	    System.out.println("num: " + nums[i]  + " up: " + up + " - down: " + down);
	    longest = Math.max(longest, up-down-1);
	  
	  }
	  
	  return longest;

	}
	  
	  
	  
	  public static void main(String[] args) {
		  LongestConsective test = new LongestConsective();
	    int[] nums = new int[]{100, 4, 200, 1, 3, 2};
	    // String[] strs = new String[]{"apple", "ape", "april"};
	    System.out.println("result is: " + test.longestConsecutive(nums));

	  }
	  }
