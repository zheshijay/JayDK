package algo.binary_search;

/*
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
	
	
	public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

	
	public static void main(String[] args){
		FindPeakElement test = new FindPeakElement();
		int[] nums = new int[]{1,2,3,4,5,6,5,7};
		System.out.println(test.findPeakElement(nums));
	}
}
