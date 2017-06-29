package algo.string_and_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;


//sorted
public class RemoveDuplicate {

	public int[] removeDuplicateSorted(int[] A) {

		int length=A.length; 
		if(length==0 || length==1) return A;

		int index=1; 
		for(int j=1; j<length; j++) 
		{
			if(A[j]!=A[j-1])
			{
				A[index]=A[j]; 
				index++; 
			}
		}

		int[] newArray = new int[index];

		newArray = Arrays.copyOf(A, index);

		return newArray; 

	}

	//unsorted
	public int[] removeDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();

		int newLen = 0;

		for(int i=0; i<nums.length; i++){
			if(set.contains(nums[i])) {
				System.out.println("skip :" + nums[i]);
				continue;
			}
			else{
				System.out.println("add :" + nums[i]);
				newLen++;
				set.add(nums[i]);
			}
		}

		System.out.println("set :" + set);

		int[] newArray = new int[newLen];

		Iterator<Integer> it = set.iterator();
		int i=0;
		while(it.hasNext()){
			newArray[i++]=it.next();
		}

		return newArray;

	}


	public static int[] replicate(int[] array, int n) {
		int[] newArray = new int[array.length - array.length / n];
		int j = 0;
		for (int i = 0; i != array.length; i++) {
			if ((i + 1) % n != 0) {
				newArray[j++] = array[i];
			}
		}
		return newArray;
	}

	public static void main(String args[]){
		RemoveDuplicate test = new RemoveDuplicate();

		int[] nums = new int[]{1,2,4,4,4,6,7,8,9,10,11};
		int[] unique = test.removeDuplicateSorted(nums);

		for(int eachNum: unique){
			System.out.print(eachNum + "-");
		}


	}
}
