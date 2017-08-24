package algo.string_and_array;

public class MaxSubArrayContiguous {

	/*
Find the contiguous sub-array within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	 * 
	 * 
	 * 
	 */
	public static int maxSubArray(int[] A) {
	    int maxVal=A[0], curVale=A[0];
	    for (int i=1;i<A.length;++i){
	    	curVale= Math.max(curVale+A[i],A[i]);
	    	maxVal=Math.max(maxVal, curVale);	
	    }
	    return maxVal;
	}

	
		public static void main(String[] args){
			MaxSubArrayContiguous test = new MaxSubArrayContiguous();
			
			int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
	
			int res = test.maxSubArray(nums);
			
			System.out.println(res);
			

			
		}
	
	
}
