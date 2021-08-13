package algo.string_and_array;

import java.util.Arrays;

public class InsertValToArray {

	public void swap( ){

	}


	public static int[] addPos(int[] a, int pos, int num) {
		int[] result = new int[a.length];

		for(int i = 0; i < pos; i++)
			result[i] = a[i];


		result[pos] = num;


		for(int i = pos + 1; i < a.length; i++)
			result[i] = a[i - 1];
		return result;
	}


	 public int searchInsert(int[] nums, int target) {
	       if (target > nums[nums.length-1]) {
	           return nums.length;
	       }
	       
	       for (int i =0; i< nums.length; i++) {
	           if (target <= nums[i]) {
	               return i;
	           }
	       }
	       return -1;
	    }

	public int[] insert(int[] nums, int target){
		//new array
		int[] res = new int[nums.length +1];

		int pos = -1;
		//copy original array to new array
		for(int i=0; i< nums.length;i++){
			System.out.println("nums[i] is: " + nums[i]);
			res[i] = nums[i];
		}

		//find index
		for(int i=0; i< res.length;i++){
			System.out.println("res[i] is: " + res[i]);
			if(res[i] > target){
				pos = i;
				break;
			}
		}
		
		System.out.println("pos is: " + pos);

		//move element from last
		for( int j=res.length-1; j > pos; j--){
			System.out.println(" j is: " + j);
			res[j] = res[j-1];
		}
		
		//insert val
		res[pos] = target;

		return res;
	}
	
	  public int searchInsert2(int[] nums, int target) {
	        int n = nums.length;
	        int left = 0, right = n - 1, ans = n;
	        while (left <= right) {
	            int mid = ((right - left) >> 1) + left;
	            if (target <= nums[mid]) {
	                ans = mid;
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	        return ans;
	    }


	public static void main(String[] args) {


		InsertValToArray test = new InsertValToArray();

		int[] nums = new int[]{1,3,5,7,9};

		int[] nums2 = test.insert(nums, 8);
		System.out.println("-------> "+Arrays.toString(nums2));

	}
}
