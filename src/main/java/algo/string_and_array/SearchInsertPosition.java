package algo.string_and_array;

public class SearchInsertPosition {

	
	//use binary search
	public int searchInsert(int[] A, int target) {
		int low = 0, high = A.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(A[mid] == target) return mid;
			else if(A[mid] > target) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

	public static void main(String[] args){
		PlusOne test = new PlusOne();

		int[] nums = new int[]{9,1,9};

		int[] res = test.plusOne(nums);

//		ArrayUtil.printArray(res);
	}

}
