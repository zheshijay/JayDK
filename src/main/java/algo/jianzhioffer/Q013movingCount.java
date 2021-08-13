package algo.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：

用返回一个整数列表来代替打印
n 为正整数

 */

public class Q013movingCount {
	
	/*
	 * DFS
	 */
	int m, n, k;
    boolean[][] visited;
    public int movingCount1(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    /*
	 * BFS
	 */
	public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                
                //边界条件
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || getSum(tx) + getSum(ty) > k) {
                    continue;
                }
                
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }
	
	/*
	 * DFS
	 */
	public int movingCountDfs(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Stack<int[]> stack = new Stack<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        stack.push(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                
                //边界条件
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || getSum(tx) + getSum(ty) > k) {
                    continue;
                }
                
                stack.push(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

	private int getSum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

	public static void main(String[] args) {
		Q013movingCount test = new Q013movingCount();
		System.out.println(test.movingCountDfs(2,3,1));
	}

}