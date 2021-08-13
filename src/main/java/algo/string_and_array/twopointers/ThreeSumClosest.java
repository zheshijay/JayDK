package algo.string_and_array.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

	/*
	 * 
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

	 */
	public int threeSumClosest(int[] nums, int k) {
		Arrays.sort(nums);
		int res = -1;

		int closestVal = Integer.MAX_VALUE;

		for( int i=0; i< nums.length; i++){
			int target = k-nums[i];

			System.out.println("--------------> target is:" + target + " res: " + res);

			int leftP=i+1, rightP=nums.length-1;
			while(leftP < rightP){

				System.out.println("left:" + nums[leftP] + " rightP:" + nums[rightP]);

				int sum = nums[i] + nums[leftP] + nums[rightP];
				int diff = Math.abs(sum-k);

				//check diff
				if(diff < closestVal){
					closestVal = diff;
					res = sum;
					System.out.println("closet values: " + nums[leftP] + "-" + nums[rightP] + "-" + nums[i]);
				}

				if(target > nums[leftP] + nums[rightP]) {
					leftP++;
				}
				else if(target < nums[leftP] + nums[rightP]){
					rightP--;
				}else{
					//found 3 element equals to k
					return k;
				}

			}
		}

		return res;
	}

	public int myThreeClosest(int[] a, int k){
		Arrays.sort(a);
		
		int closestSum=-1;
		int minDiff = Integer.MAX_VALUE;
		
		for( int i=0; i<a.length; i++ ){
			//select target and move 2 pointer
			int target = k - a[i];
			
			int p1=i+1, p2=a.length-1;
			
			while( p1 < p2 ){
				System.out.println("|target:" + target);
				int sum = a[p1] + a[p2];
				int diff = Math.abs(a[i] + a[p1] + a[p2] -k);
				System.out.println("p1:" + a[p1] + " p2:" + a[p2] + " diff:" + diff);
				//check diff
				if(diff < minDiff){
					minDiff = diff;
					closestSum = a[i] + a[p1] + a[p2];
					System.out.println("closet values: " + closestSum);
				}
				
				if(target>sum){p1++;}
				else if(target<sum){p2--;}
				else return a[i] + a[p1] + a[p2];			    
			}

		}
		return closestSum;
	}



	public static void main(String args[]){
		ThreeSumClosest threeSumClosest = new ThreeSumClosest();
//		int res = threeSumClosest.threeSumClosest(new int[]{1,2,3,4,5}, 100);
		int res = threeSumClosest.myThreeClosest(new int[]{1,2,3,4,5}, 100);
		System.out.println(res);

	}
}
