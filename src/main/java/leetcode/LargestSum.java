package leetcode;


public class LargestSum {
	static int LargestSum(int[] numbers)
	{
		int newsum=numbers[0];
		int max=numbers[0];
		for(int i=1;i<numbers.length;i++){
			newsum=Math.max(newsum+numbers[i],numbers[i]);
			max= Math.max(max, newsum);
		}
		return max;
	}

	static int LargestSum2(int[] nums)
	{
		int max_ending_here=0;
		int max_so_far = 0;

		for(int num: nums){
			System.out.println("---------------");
			System.out.print("max_ending_here is: " + max_ending_here);
			System.out.println(" max_so_far:" + max_so_far);
			max_ending_here = Math.max(0, max_ending_here + num);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,-9,1,2,3,4,9,9,-9,-9,-1000};
		int max = LargestSum.LargestSum2(nums);
		System.out.println(max);

	}

}
