package algo.string_and_array;

public class RemoveDupSortedArray {
	public int removeDuplicates(int[] A) {
	    if (A.length==0) return 0;
	    int j=0;
	    for (int i=0; i<A.length; i++)
	        if (A[i]!=A[j]) A[++j]=A[i];
	    return ++j;
	}
	
	
	
	
	public int myRemoveDupLidateArray(int[] nums){
		  if (nums.length==0) return 0;
		
		int p = 0;

		for(int i=0; i< nums.length; i++){
			System.out.println(" compare i " + i + " and " + p);
			
			
			if(nums[p] != nums[i]){
				System.out.println(" adding " + nums[i]);
				 p++;
				 nums[p] = nums[i];
				 
			}
		}
		
		return p + 1;
	}
	
	public static void main(String[] args){
		RemoveDupSortedArray test = new RemoveDupSortedArray();

		int[] nums = new int[]{1,2,3,4,5,5};

		int res = test.myRemoveDupLidateArray(nums);

		System.out.println(res);
	}
}
