package algo.jianzhioffer;

import java.util.Arrays;

/*
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

示例 1:

输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

 */

public class Q046translateNum {
	public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q; 
            q = r; 
//            r = 0;
//            r += q;
            r = q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
	
	public int translateNum2(int num) {
		String s = String.valueOf(num);
		int len = s.length();
		if (len < 2) {
			return 2;
		}
		
		char[] charArray = s.toCharArray();
		int[] dp = new int[len];
		dp[0] = 1;
		for(int i=1; i<len;i++) {
			dp[i] = dp[i-1];
			int currentNum = 10 * (charArray[i-1] - '0') + (charArray[i]-'0');
			if (currentNum > 9 && currentNum < 26) {
				if (i-2 < 0) {
					dp[i]++;
				} else {
					dp[i] +=dp[i-1];
				}
			}
		}
		return dp[len-1];
		
	}
	
	public int translateNum3(int num) {
		String s = String.valueOf(num);
		int len = s.length();
		if (len < 2) {
			return len;
		}
		
		char[] charArray = s.toCharArray();
		int[] dp = new int[len+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=1; i<len;i++) {
			dp[i+1] = dp[i];
			int currentNum = 10 * (charArray[i-1] - '0') + (charArray[i]-'0');
			if (currentNum > 9 && currentNum < 26) {
				dp[i+1] = dp[i] + dp[i-1];
				System.out.println("dp" + i + " is: " + dp[i]);
			}
		}
		
		System.out.println("dp:" + Arrays.toString(dp));
		return dp[len];
	}
	
	
	/*
	 * 
	 * 滚动数组 DP
	 * 
	 */
//	 public int translateNum(int num) {
//	        String s = String.valueOf(num);
//	        int a = 1, b = 1;
//	        for(int i = 2; i <= s.length(); i++) {
//	            String tmp = s.substring(i - 2, i);
//	            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
//	            b = a;
//	            a = c;
//	        }
//	        return a;
//	    }

	 
	 public static void main(String[] args) {
		 Q046translateNum test = new Q046translateNum();
		 
		 int res = test.translateNum3(12258);
		 System.out.println(res);
		 
		 
	}
}