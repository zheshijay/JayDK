package algo.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	/**
	 * @param numbers : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of zero.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numbers == null || numbers.length < 3) {
			return res;
		}
		Arrays.sort(numbers);

		for (int i = 0; i < numbers.length - 2; i++) {
			if (i > 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			int left = i+1;
//			int left = 0;
			int right = numbers.length - 1;
			
			
			System.out.println("left:" + left + " - right:" + right);

			while (left < right) {
				
				int sum = numbers[i] + numbers[left] + numbers[right];
				
				
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(numbers[i]);
					tmp.add(numbers[left]);
					tmp.add(numbers[right]);
					res.add(tmp);
					left++;
					right--;
					
					//skip duplicate values
					while (left < right && numbers[left] == numbers[left - 1]) { 
						left++;
					}
					while (left < right && numbers[right] == numbers[right + 1]) {
						right--;
					}
					
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}

			}
		}
		return res;
	}
	
	
	public static void main(String args[]){
		ThreeSum test = new ThreeSum();
//		ArrayList<ArrayList<Integer>> res = test.threeSum(new int[]{1,2,3,4,5,6,7,-2,-1});
//		ArrayList<ArrayList<Integer>> res = test.threeSum(new int[]{1,2,3,4,5,6,7,-2,-1});
		ArrayList<ArrayList<Integer>> res = test.threeSum(new int[]{-2,-1,1,2,3});
		System.out.println(res);
		
	} 
}
