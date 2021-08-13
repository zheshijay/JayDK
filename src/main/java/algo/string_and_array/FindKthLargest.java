package algo.string_and_array;


import java.util.Arrays;

/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {
	 public int findKthLargest(int[] nums, int k) {
	        int len = nums.length;
	        int left = 0;
	        int right = len - 1;

	        // 转换一下，第 k 大元素的索引是 len - k
	        int target = len - k;

	        while (true) {
	            int index = partition(nums, left, right);
	            if (index == target) {
	                return nums[index];
	            } else if (index < target) {
	                left = index + 1;
	            } else {
	                right = index - 1;
	            }
	        }
	    }

	    /**
	     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
	     * 在遍历过程中保持循环不变量的语义
	     * 1、[left + 1, j] < nums[left]
	     * 2、(j, i] >= nums[left]
	     *
	     * @param nums
	     * @param left
	     * @param right
	     * @return
	     */
	    public int partition(int[] nums, int left, int right) {
	        int pivot = nums[left];
	        System.out.println("---> pivot is:" + pivot);
	        int j = left;
	        for (int i = left + 1; i <= right; i++) {
	            if (nums[i] < pivot) {
	                // 小于 pivot 的元素都被交换到前面
	                j++;
	                System.out.println("swap j:" + nums[j] + " and i:" + nums[i]);
	                swap(nums, j, i);
	                System.out.println("---> after swap is:" + Arrays.toString(nums));
	            }
	        }
	        
	        
	      
	        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
	        System.out.println("=== swap j:" + nums[j] + " and left:" + nums[left]);
	        swap(nums, j, left);
	        System.out.println("-=======> final is:" + Arrays.toString(nums));
	        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
	        return j;
	    }

	    private void swap(int[] nums, int index1, int index2) {
	        int temp = nums[index1];
	        nums[index1] = nums[index2];
	        nums[index2] = temp;
	    }

	public static void main(String args[])
	{
//		int a[] = {1,2,3,4,5,6,7,8,9,10};
		int a[] = {5,6,7,8,1,2,3,4,9,10};
//		int a[] = {3,2,1,5,6,4};

		FindKthLargest ob = new FindKthLargest();
		int index = ob.findKthLargest(a, 3);

		System.out.println("K th largest:" + index);
	}
}