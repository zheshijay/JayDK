package algo.string_and_array;

import java.util.Arrays;

/**
 * 
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
How many different ways do you know to solve this problem?
 *
 */
public class RotateArray {


	/**
	 * 
	 * Solution 1 - Use Intermediate Array
	 * 
[1,2,3,4,5,6,7]

[5,6,7,1,2,3,4]
	 */

	//Solution 1 - Intermediate Array
	public  static int[] rotateArray(int[] nums, int k){

		if(k > nums.length) 
			k=k%nums.length;

		int[] copyOfNums = Arrays.copyOf(nums, nums.length);
		int[] res = new int[nums.length];
		RotateArray.printArray(copyOfNums);

		for( int i=0; i<nums.length; i++ ){
			res[(i + k) % nums.length] = copyOfNums[i];
		}

		RotateArray.printArray(res);
		return res;
	}

	public static void printArray(int[] nums){

		for(int num: nums){
			System.out.print(num + " ");
		}
		System.out.println();

	}

	/**
	 * 
	 * 
	 * 
Solution 2 - Bubble Rotate

Can we do this in O(1) space?

This solution is like a bubble sort.

	 */
	public static int[] rotate(int[] arr, int order) {
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		for (int i = 0; i < order; i++) {

			System.out.println( i+1 + " round " );

			for (int j = arr.length - 1; j > 0; j--) {
				
				System.out.println("swap " + arr[j] + " and " + arr[j - 1]);
				
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}

			RotateArray.printArray(arr);

		}
		return arr;
	}


	/**
	 * 
	 * 
	Solution 3 - Reversal

Can we do this in O(1) space and in O(n) time? The following solution does.

Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:

1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,5,6
3. Reverse second part: 4,3,2,1,6,5
4. Reverse the whole array: 5,6,1,2,3,4
	 * 
	 * @param args
	 */

	public static void rotate_reversal(int[] arr, int order) {	
		if (arr == null || arr.length==0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if(order > arr.length){
			order = order %arr.length;
		}

		//length of first part
		int a = arr.length - order; 

		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);

	}

	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;

		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
	
	
	
	
	
	
	
	
	
	 /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n) 
    {
        int i;
        for (i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }
 
    void leftRotatebyOne(int arr[], int n) 
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }
 
    /* utility function to print an array */
    void printArray(int arr[], int size) 
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
    
	

	public static void main(String args[]){
		RotateArray test = new RotateArray();

		int[] nums = new int[]{1,2,3,4,5,6,7};

		int[] rotated = test.rotate(nums, 3);

		//		test.printArray(rotated);


	}
}
