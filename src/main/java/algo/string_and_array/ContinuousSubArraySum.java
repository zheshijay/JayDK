package algo.string_and_array;

import java.util.HashMap;

public class ContinuousSubArraySum {
	public static boolean checkSubarraySum(int[] nums, int k) {

		for (int start = 0; start < nums.length - 1; start++) {
			for (int end = start + 1; end < nums.length; end++) {

				int sum = 0;
				for (int i = start; i <= end; i++) {
					sum += nums[i];
				}

				if (sum == k || (k != 0 && sum % k == 0))
					return true;
			}
		}
		return false;
	}

	public boolean checkSubarraySum2(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			sum[i] = sum[i - 1] + nums[i];

		for (int start = 0; start < nums.length - 1; start++) {
			for (int end = start + 1; end < nums.length; end++) {
				int summ = sum[end] - sum[start] + nums[start];
				if (summ == k || (k != 0 && summ % k == 0))
					return true;
			}
		}
		return false;
	}

	  public boolean checkSubarraySum3(int[] nums, int k) {
	        int sum = 0;
	        for(int i = 0; i < nums.length; i++){
	            sum = nums[i];
	            for(int j = i+1; j < nums.length; j++){
	                sum += nums[j];
	                if(k == 0){
	                    if(sum == 0) return true;
	                    continue;
	                }
	                if(sum % k == 0) return true;
	            }
	        }
	        return false;
	    }

	  
	/*
	 * 
	 * 设位置 j < i : 0 到 j 的前缀和 preSum1 = 某常数1 * k + 余数1 0 到 i 的前缀和 preSum2 = 某常数2 * k
	 * + 余数2 当找到 余数1 等于 余数2时， 则 j + 1 到 i 的连续和 = preSum2 - preSum1 = (某常数2 - 某常数1) *
	 * k， 必为 k 的倍数， 返回true
	 * 
	 */
	public boolean checkSubarraySum4(int[] nums, int k) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0)
				sum = sum % k;
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1)
					return true;
			} else
				map.put(sum, i);
		}
		return false;
	}
	
	public boolean checkSubarraySum5(int[] nums, int k) {
        int length = nums.length;
        if(length < 2){  // 保证最少两个连续的
            return false;
        } 
        if(k == 0){  // 除数是0的情况下必须子数组最少有连续两个0
            for(int i = 0; i < length - 1; i ++){
                if(nums[i] == 0 && nums[i + 1] == 0){
                    return true;
                }
            }
            return false;
        }
        // 对每个数字遍历，看它累加后面的每个和是否能整除k
        for(int i = 0; i < length; i ++){
            int subsum = 0;

            for(int j = i; j < length; j ++){
                subsum += nums[j];
                if(subsum % k == 0 && j != i){  // j != i保证了子数组和最少是两个元素的和
                    return true;
                }
            }
        }
        return false;
    }

	
	/*
	 * 
	 * 
	 * DP
	 */
	public static boolean checkSubarraySum6(int[] nums, int k) {
		int[] dp = new int[10010];
		if (nums.length < 2)
			return false;
		// k==0时单独考虑，其实和k!=0时只有做不做模运算的区别
//		if (k == 0) {
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = 0; j < nums.length - i; j++) {
//					dp[j] = (dp[j] + nums[j + i]);
//					if (i != 0 && dp[j] == 0)
//						return true;
//				}
//			}
//			return false;
//		}
		// 当i=k时，dp[j]表示以j为起始下标，nums中连续k+1个整数的和
		// 如当i=0时，相当于将nums拷贝到dp
		// i=1时，dp[0]相当于以0为起始下标，nums中2个整数的和，即nums[0]+nums[1]
		// 每次计算时都可以用原来的dp进行更新，而不用一个个去加
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i; j++) {
				dp[j] = (dp[j] + nums[j + i]) % k;
				
				System.out.println("dp["+j+"]:" + dp[j]);
				
				if (i != 0 && dp[j] == 0)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		System.out.println(ContinuousSubArraySum.checkSubarraySum6(nums, 6));

	}

}
