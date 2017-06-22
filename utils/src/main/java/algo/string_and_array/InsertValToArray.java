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


	public static int [] insertArray (int inputArray[], int index, int value){
		for(int i=0; i< inputArray.length-1; i++) {

			if (i == index){

				for (int j = inputArray.length-1; j >= index; j-- ){
					inputArray[j]= inputArray[j-1];
				}

				inputArray[index]=value;
			}

		}
		return inputArray;
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

	public static void main(String[] args) {


		InsertValToArray test = new InsertValToArray();

		int[] nums = new int[]{1,3,5,7,9};

		int[] nums2 = test.insert(nums, 8);
		System.out.println("-------> "+Arrays.toString(nums2));

	}
}
