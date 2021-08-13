package algo.string_and_array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	/*
	 * 
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < nums.length; i++){
			if(i > k) {
				System.out.println("removing :" + nums[i-k-1]);
				set.remove(nums[i-k-1]);
			}
			
			
			if(!set.add(nums[i])) return true;
		}
		return false;
	}

/*
 * 给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

 

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n: nums) {
            if(set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }


	public static void main(String args[]){
		System.out.println(ContainsDuplicate.containsNearbyDuplicate(new int[]{0, 2, 2, 3, 4, 5},1));


	}
}
