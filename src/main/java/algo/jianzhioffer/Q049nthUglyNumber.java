package algo.jianzhioffer;

import java.util.PriorityQueue;
import java.util.Queue;

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

public class Q049nthUglyNumber {
	/*
	 * Solution 1
	 */
	private int[] uglyNumber = {2,3,5};
    public int nthUglyNumber(int n) {
        //创建小根堆，每次出堆的都是最小值
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        //记录出堆的个数，出堆的元素完全按照从小到大排序
        int count = 0;
        while (! queue.isEmpty()){
            long cut = queue.poll();

            //如果出堆的个数>=n,当前cut就是第n个丑数
            if(++count >= n){
                return (int) cut;
            }
            for(int num : uglyNumber){
                //排除重复的数字
                if(! queue.contains(num * cut)){
                    queue.add(num * cut);
                }
            }
        }
        return -1;
    }
    
    /*
	 * Solution 2
	 */
    public int nthUglyNumber2(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        int x2, x3, x5;

        // 找出第一个乘若干倍大于最新丑数的丑数
        for(int i = 2; i<=n; i++){
            for(x2 = 0; x2<i; x2++) if(dp[x2]*2 > dp[i-1]) break;
            
            for(x3 = 0; x3<i; x3++) if(dp[x3]*3 > dp[i-1]) break;
            
            for(x5 = 0; x5<i; x5++) if(dp[x5]*5 > dp[i-1]) break;
            
            dp[i] = Math.min( Math.min(dp[x2]*2, dp[x3]*3), dp[x5]*5 );
        }
        return dp[n];

    }

    public int nthUglyNumber3(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }


}