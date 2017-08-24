package algo.string_and_array;

public class MinimumSizeSUbArray {
	/**
	 * @param nums: an array of integers
	 * @param s: an integer
	 * @return: an integer representing the minimum size of subarray
	 */
	public int minimumSize(int[] nums, int s) {
		// write your code here
		int j = 0, i = 0;
		int sum =0;
		int ans = Integer.MAX_VALUE;
		for(i = 0; i < nums.length; i++) {
			while(j < nums.length && sum < s) {
				sum += nums[j];
				j ++;
			}

			if(sum >=s) {
				ans = Math.min(ans, j - i);
			}

			sum -= nums[i];
		}
		if(ans == Integer.MAX_VALUE)
			ans = 0;
		return ans;
	}




	public int myMinimumSize(int[] nums, int s) {

		if(nums ==null || nums.length == 0 ) return 0;

		int minLen = Integer.MAX_VALUE;
		int sum=0;
		for(int i=0; i <nums.length; i++){
			sum=0;
			for( int j=i; j< nums.length; j++){

				sum+=nums[j];

				if(sum >= s ){
					minLen = Math.min(minLen, j - i);
				}
			}
		}

		if(minLen == Integer.MAX_VALUE ) return 0;
		return minLen + 1;
	}


	public int MyminSubArrayLen(int s, int[] nums) {
		if(nums.length == 0) return 0;
		int left = 0, right = 0, sum = nums[0], minLen = nums.length + 1;
		while(right <= nums.length && left <= right){

			if(sum < s){

				// 当右边界等于长度时，我们要多等一轮，等待左边界左移，这时候不能加
				if(right < nums.length){
					sum += nums[right];
				}
				right++;
			} else {
				// 当和大于等于目标时，�?查长度并左移边界

				System.out.println(" found left: " + left + " right: " + right);

				minLen = Math.min(minLen, right - left);
				sum -= nums[left];
				left++;
			}


		}

		System.out.println("--> minLen is: " + minLen);
		return minLen <= nums.length ? minLen : 0;
	}

	public static void main(String[] args) {
		ContiguousArraySum test = new ContiguousArraySum();
		int[] nums = new int[]{2,3,1,2,4,3};
		System.out.println(test.MyminSubArrayLen(7, nums));

	}
}
