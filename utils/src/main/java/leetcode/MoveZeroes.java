package leetcode;


public class MoveZeroes {
	public void moveZeroes(int[] nums) {

		int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				swap(i++, j++, nums);
			} 
			else j++;
		}
	}

	public void swap(int i, int j, int[] nums) {
		System.out.println("swap " + i + " and " + j);
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void myMoveZeroToEnd(int[] nums){
		int pointer1 = 0;
		int pointer2 = 0;
		
		while(pointer2 < nums.length){
			if(nums[pointer2] != 0){
				swap(pointer1++, pointer2++, nums);
			}else{
				pointer2++;	
			}

		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeroes mz = new MoveZeroes();
		int [] nums = {1,0,2,0,3,4};
		mz.myMoveZeroToEnd(nums);

		for(int eachInt: nums){
			System.out.print(eachInt);
		}

	}

}
