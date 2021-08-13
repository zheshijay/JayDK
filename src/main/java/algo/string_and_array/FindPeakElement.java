package algo.string_and_array;

public class FindPeakElement {
	/*
	 * 
	 * 
	 * A peak element is an element that is greater than its neighbors.
	 * 
	 * 峰值元素是指其值大于左右相邻值的元素。
	 * 
	 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
	 * 
	 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
	 * 
	 * 你可以假设 nums[-1] = nums[n] = -∞。
	 * 
	 * 示例 1:
	 * 
	 * 输入: nums = [1,2,3,1] 输出: 2 解释: 3 是峰值元素，你的函数应该返回其索引 2。 示例 2:
	 * 
	 * 输入: nums = [1,2,1,3,5,6,4] 输出: 1 或 5 解释: 你的函数可以返回索引 1，其峰值元素为 2；   或者返回索引 5，
	 * 其峰值元素为 6。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-peak-element
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/**
	 * @param A: An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeakUseBS(int[] A) {
		int left = 1, right = A.length - 2;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (A[mid] < A[mid - 1]) {
				right = mid;
			} else if (A[mid] < A[mid + 1]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (A[left] < A[right]) {
			return right;
		} else {
			return left;
		}
	}

	/**
	 * @param A: An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeakUseNaive(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
				return nums[i];

		}
		return -1;
	}

	public int myFindPeakUseBS(int[] nums) {

		int low = 0, high = nums.length - 1, mid = (low + high) / 2;

		while (low + 1 < high) {
			System.out.println(" low : " + low + " high: " + high);

			if (nums[mid + 1] > nums[mid]) {
				low = mid;
			} else if (nums[mid - 1] > nums[mid]) {
				high = mid;
			} else {
				return nums[mid];
			}

			mid = (low + high) / 2;
		}

		if (nums[low] > nums[high])
			return nums[low];
		else
			return nums[high];

	}

	// [1, 2, 3, 4�? 5�? 4�? 6�? 7�? 6]
	// best solution
	public int myFindPeak(int[] nums) {

		int low = 0, high = nums.length - 1, mid = (low + high) / 2;

		while (low + 1 < high) {

			if (nums[mid + 1] > nums[mid]) {
				low = mid;
			} else if (nums[mid - 1] < nums[mid]) {
				high = mid;
			} else {
				return nums[mid];
			}
			mid = (low + high) / 2;
		}

		if (nums[low] > nums[high])
			return nums[low];
		else
			return nums[high];

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 6, 4, 2 };

		FindPeakElement test = new FindPeakElement();

		int res = test.myFindPeak(nums);

		System.out.println(res);

	}

}
