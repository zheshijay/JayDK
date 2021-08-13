package algo.binary_search;

/*
 * 
 * 
 * 
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 */
public class FindMinimuminRotatedSortedArray {
 
	// start: 9:35 ~ 9:50

	//solution:  find the first element smaller than nums[nums.length-1]

	public int findMin(int[] nums){
		int start=0, end=nums.length-1;

		int target = nums[end];

		while(start+1 < end){
			int mid = (start+end)/2;

			if(target > nums[mid]) end=mid;
			else start=mid;
		}

		System.out.println("start:" + start + " end:" + end);
		
		if(nums[start] <=target){
			return start;
		}else return end;


	}


	public static void main(String[] args){
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};

		FindMinimuminRotatedSortedArray test = new FindMinimuminRotatedSortedArray();

		System.out.println(test.findMin(a));


	}
}
