package algo.string_and_array;

public class RotatedSortedArray {


	public static boolean search(int[] nums, int key) {

		if(nums == null || nums.length<1) return false;
		if(nums.length==1){
			if(nums[0] == key) return true;
			else return false;
			
		}

		//find shift ( find the 1st element less the the first element of the array )
		int shiftIndex = 0;
		for(int i=0; i < nums.length-1; i++){
			if(nums[i] > nums[i+1]){
				shiftIndex = i;
				break;
			}
		}

		System.out.print("shiftIndex: " + shiftIndex + 1);

		// low ~ shiftIndex,   shiftIndex ~ ( nums.length - 1)
		int low1 = 0;
		int high1 = shiftIndex+1;
		int mid1 = ( low1 + high1)/2;
		while(low1<=high1){

			

			if(nums[mid1] == key) return true;

			if(nums[mid1] < key) 
				low1 = mid1 + 1;

			if(nums[mid1] > key) 
				high1 = mid1 - 1;

			mid1 = ( low1 + high1) /2;
		}

		
		
		
		
		
		int low2 = shiftIndex+1;
		int high2 = nums.length - 1;
		int mid2 = ( low2 + high2 )/2;
		
		System.out.println("\n search 2nd half, low " + low2 + " high: " + high2);
		
		while(low2 <= high2){
			if(nums[mid2] == key) return true;

			if(nums[mid2] < key) 
				low2 = mid2 + 1;
			if(nums[mid2] > key) 
				high2 = mid2 - 1;

			mid2 = ( low2 + high2) /2;
		}

		return false;

	}

	public static void main(String[] args) {

		int[] shiftedNums = {1,2};
		System.out.println(RotatedSortedArray.search(shiftedNums, 2));
	}
}
