package algo.string_and_array.twopointers;

import java.util.Arrays;

public class TwoSumCloset {

	/**
	 * @param nums an integer array
	 * @param target an integer
	 * @return the difference between the sum and the target
	 */
	public int twoSumCloset1(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return -1;
		}

		if (nums.length == 2) {
			return target - nums[0] - nums[1];
		}
		Arrays.sort(nums);
		int pl = 0;
		int pr = nums.length - 1;

		int minDiff = Integer.MAX_VALUE;
		while (pl < pr) {
			int sum = nums[pl] + nums[pr];
			int diff = Math.abs(sum - target);
			if (diff == 0) {
				return 0;
			}
			if (diff < minDiff ) {
				minDiff = diff;
			}
			if (sum > target) {
				pr--;
			} else {
				pl++;
			}
		}
		return minDiff;
	}

	public int twoSumCloest2(int[] a, int k){
		Arrays.sort(a);
		int minDiff = Integer.MAX_VALUE;
		
		//2 pointer
		int p1=0, p2=a.length-1;
		
		while(p1 < p2){
			int sum = a[p1] + a[p2];
			
			System.out.println( " p1:" + a[p1] +  " p2:" + a[p2] + " sum:" + sum + " minDiff:" + minDiff);
			
			System.out.println("Math.abs(sum - k):" + Math.abs(sum - k));
			
			minDiff = Math.min(Math.abs(sum - k), minDiff);
			System.out.println("minDiff: " + minDiff);
			
			if( k > sum) { p1++; }
			else if( k< sum) { p2--; }
			else return 0;
		}
		return minDiff;
	}

	public static void main(String args[]){
		TwoSumCloset test = new TwoSumCloset();

		System.out.println(test.twoSumCloest2(new int[]{-7, -2, 12, 15}, 4));
	}
}
