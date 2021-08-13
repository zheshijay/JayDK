package algo.string_and_array;


/**
 * 
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number.
 The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 * 
 * 
 * 
 * @author ZShi
 *
 */
public class FindThirdMaxNum {

	public static int findThirdMaxNum(int[] nums){
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;

		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;

			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;   //If it does not exist, return the maximum number.

	}








	//	Input: [1, 3, 2, 4, 5]

	public int myFindThirdMax(int[] nums){

		Integer max1 = null, max2 = null, max3=null;


		for( int i=0; i< nums.length; i++){
			if(max1==null || nums[i]>max1 ){
				max3=max2;
				max2=max1;
				max1=nums[i];
			}else if(max1==null || nums[i]>nums[2]){
				max3=max2;
				max2=nums[i];
			}else if(max3==null || nums[i] >nums[3]){
				max3=nums[i];
			}

		}

		return max3!=null?max3:max1;
	}
	
	
	

	
	public static int findThirdMax(int[] nums) {
		
		Integer m1=null, m2=null, m3=null;

		for(int n: nums) {
			
			if(m1 == null || n >= m1) {
				if (m1 != null && n == m1) continue;
				m3=m2;
				m2=m1;
				m1=n;
			}else if(m2 == null || n >= m2) {
				if (m2 != null && n == m2) continue;
				m3=m2;
				m2=n;
			}else if(m3 == null || n >= m3){
				if (m3 != null && n == m3) continue;
				m3=n;
			}
		}
		
		return m3!=null?m3:m1;
		
	}
	
	
	
	
	
	
	
	
	
	



	public static void main(String args[]){
//		int[] nums = new int[] {1,2,3,4,5};
		int[] nums = new int[] {1,1,2};
		System.out.println("res:" + FindThirdMaxNum.findThirdMax(nums));
	}
}
