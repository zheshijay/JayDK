package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	/*
	 * 
	 * a + b + c = 0
	 * 
	 * my solution: 
	 * (1) Use buffer: hashmap     this question can be convert to 2 sum question find 2 elements which equals -c
	 * 
	 * 
	 */
	public List<List<Integer>> myFourSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for(int k=0; k < nums.length-1; k++){
			
			System.out.println("K: " + k);
			
			int targetVal = -nums[k];
			
			for(int i=k+1; i < nums.length; i++){

				int curNum = nums[i];

				//avoid duplicate
				if(i>0 && curNum == nums[i-1]) continue;

				int target = targetVal-curNum;


				int leftP = i, rightP = nums.length-1;

				while(leftP < rightP){

					if( (target > nums[leftP] + nums[rightP])) 
						leftP++; 
					else if( target < nums[leftP] + nums[rightP] ) 
						rightP--;
					else{
						//found it
						List<Integer> indice = new ArrayList<Integer>();
						indice.add(nums[k]);
						indice.add(nums[i]);
						indice.add(nums[leftP]);
						indice.add(nums[rightP]);
						res.add(indice);

						leftP++;
						rightP--;

						//avoid duplicate
						while(leftP < rightP && nums[leftP] == nums[leftP-1]) leftP++;
						while(leftP < rightP && nums[rightP] == nums[rightP+1]) rightP--;

						// -3, -3, -2, -1, 0, 1, 2, 2, 3, 3
					}
				}

			}
		}
		return res;
	}

	public static void main(String args[]){
		FourSum fourSum = new FourSum();
		List<List<Integer>> res = fourSum.myFourSum(new int[]{-2, -2, -1, 0, 1, 2, 2, 2, 3 });

		System.out.println(res);

	}


}
