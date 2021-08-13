package algo.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：

用返回一个整数列表来代替打印
n 为正整数

 */

public class Q017printNumbers {
	
	/*
	 * Solution 1: print all numbers by exponent power
	 */
	 public int[] printNumbers1(int n) {
	        int end = (int)Math.pow(10, n) - 1;
	        int[] res = new int[end];
	        for(int i = 0; i < end; i++)
	            res[i] = i + 1;
	        return res;
	    }

	 public int[] permute(char[] nums, int n) {
	    	StringBuffer res = new StringBuffer(); // store the result
	    	boolean[] used = new boolean[nums.length]; // mark used elements
	    	StringBuffer path = new StringBuffer(); // each permutation
	    	dfs(nums, path, res, used, 0, n);
	    	
	    	int[] result = Arrays.stream(res.toString().split(",")).filter(c->Integer.parseInt(c) != 0).mapToInt(Integer::parseInt).toArray();
	    	return result;
	    }
	    
	    void dfs(char[] nums, StringBuffer path, StringBuffer res, boolean[] used, int depth, int n) {
	    	if (depth == n && path.toString() != "") {
	    		res.append(path.toString() + ',');
	    		return;
	    	}

	    	for (int i = 0; i < nums.length; i++) {
	    		path.append(nums[i]);
    			
    			System.out.println("depth:" + depth + "-- adding num:" + nums[i] + " -- path:" + path );
        		used[i] = true;
        		dfs(nums, path, res, used, depth + 1, n);

        		// backtrace
        		used[i] = false;
        		path.deleteCharAt(path.length()-1);
	    	}
	    }

	    public int[] printNumbers(int n) {
	    	char[] nums = new char[] {'0','1','2','3','4','5','6','7','8','9'};
	    	return permute(nums, n);
	    }
	    
	    public static void main(String[] args) {
	    	Q017printNumbers test = new Q017printNumbers();
			int n = 2;
			int[] res = test.printNumbers(n);
//			
			System.out.println(Arrays.toString(res));
	    	
//	    	System.out.println((int) Math.pow(10, 3));
//	    	String str = "012";
//	    	System.out.println(Integer.parseInt(str));
			
//	    	String cStr = "c";
//	    	System.out.println(cStr.equals("c"));
		}
	    
	
}