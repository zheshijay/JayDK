package algo.string_and_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

/*
 * 
[LeetCode] K-diff Pairs in an Array �����в�ΪK������
 

Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:

Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
 

Example 2:

Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 

Example 3:

Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
 

Note:

The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].


Solution:
Use HashSet:
(1) Push all values to hashSet (remove duplicates)
(2) iterate all values again, check condition: set.containsKey( num + k )



 
 */
public class FindKDiffPairs {

	public int findPairs(int[] nums, int k) {
		int pairCount = 0;

		if(nums.length<2) return 0;
		
		if(k>=1){

			HashSet<Integer> hSet = new HashSet<Integer>();

			for(int i=0;i<nums.length;i++){
				int inputElement = nums[i];
				if(!hSet.contains(inputElement)){
					hSet.add(inputElement);
				}
			}
			
			System.out.println("hSet "+ hSet);

			Iterator<Integer> itSet = hSet.iterator();

			while (itSet.hasNext()) {

				Integer value = itSet.next();
				Integer subtractValue =  value+k;

				if(hSet.contains(subtractValue)){
					System.out.println("Pair Found:"+value+" & "+subtractValue);
					pairCount++;
				}
			}
		}

		System.out.println("Total Pairs:"+pairCount);     
		return pairCount;
	}

	
	
	
	
	 public int myFindPairs(int[] nums, int k) {
		    
		    int count = 0;
		    
		    //1.push all the values to hashset
		    HashSet<Integer> set = new HashSet<Integer>();
		    int i=0;
		    while(i<nums.length){
		      set.add(nums[i++]);
		    }
		    
		    //2. check k diff pair
		    Iterator<Integer> it = set.iterator();
		    
		    while(it.hasNext()){
		       int curNum = it.next();
		       if(set.contains(curNum + k)) {
		         count++;
		         System.out.println(curNum + " - " + ( curNum+k ));
		       }
		    }
		    
		    return count;
		  }

	public static void main(String args[]){
		FindKDiffPairs test = new FindKDiffPairs();


		int result = test.findPairs(new int[]{6,2,9,3,9,6,7,7,6,4}, 3);

		System.out.println(result);

	}
}
