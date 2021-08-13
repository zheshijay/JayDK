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

public class Q015hammingWeight {
	public int hammingWeight(int n) {
		  int res = 0;
	        while(n != 0) {
	            res += n & 1;
	            n >>>= 1;
	        }
	        return res;
	}

	public int hammingWeight2(int n) {
		String str = Integer.toBinaryString(n);
		
		System.out.println("bin str:" + str);
		
		int count = 0;
		int p = str.length()-1;
		while(p >= 0) {
			char c = str.charAt(p--);
			if (c == '1') {
				count++;
			}
		}
		
		return count;
		
	}
	
	public int hammingWeight3(int n) {
		int count = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				count++;
			}
				
				n>>>=1;
		}
		return count;
		
	}

	public static void main(String[] args) {
		Q015hammingWeight test = new Q015hammingWeight();
		int n = 9;
		int res = test.hammingWeight3(n);
//			
		System.out.println(res);

//	    	System.out.println((int) Math.pow(10, 3));
//	    	String str = "012";
//	    	System.out.println(Integer.parseInt(str));

//	    	String cStr = "c";
//	    	System.out.println(cStr.equals("c"));
	}

}