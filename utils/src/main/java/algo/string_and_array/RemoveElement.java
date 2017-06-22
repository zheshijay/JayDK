package algo.string_and_array;

public class RemoveElement {

	public int removeElement(int nums[], int k) {
		int begin=0;

		for(int i=0;i<nums.length;i++){

			if(nums[i]!=k) nums[begin++]=nums[i];

		}

		return begin;
	}

	public static void main(String[] args){
		RemoveElement test = new RemoveElement();

		int[] nums = new int[]{4,2,3,4,5,6};

		int res = test.removeElement(nums, 4);

		System.out.println(res);
	}
}
