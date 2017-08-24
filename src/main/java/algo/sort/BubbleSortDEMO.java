package algo.sort;

import java.util.Arrays;

public class BubbleSortDEMO {
	
	public void bubbleSort(int[] nums){
		
		int temp=0;
		for(int i=0; i<nums.length;i++){
			for(int j=1;j<nums.length-i;j++){
				if(nums[j-1] > nums[j]){  //swap bubble
					
					System.out.println("swap " + nums[i] + " and " + nums[j]);
					
					temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j]= temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		BubbleSortDEMO test = new BubbleSortDEMO();
		
		int[] nums = new int[]{1,5,3,7,2,9};
		
		test.bubbleSort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		
	}

}
