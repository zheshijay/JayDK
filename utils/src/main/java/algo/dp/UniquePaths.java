package algo.dp;

import java.util.Arrays;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		Integer[][] map = new Integer[m][n];
		for(int i = 0; i<m;i++){
			map[i][0] = 1;
		}
		for(int j= 0;j<n;j++){
			map[0][j]=1;
		}
		for(int i = 1;i<m;i++){
			for(int j = 1;j<n;j++){
				map[i][j] = map[i-1][j]+map[i][j-1];
			}
		}
		return map[m-1][n-1];
	}



	//	1 1 1 1 1 1 1
	//	1 0 0 0 0 0 0
	//	1 0 0 0 0 0 0

	public int uniquePaths2(int m, int n) {
		//init dp
		int[][] dp = new int[m][n];      
		
		for( int i=0; i<n; i++){
			dp[0][i] =1;	   
		}

		for( int j=0; j<m; j++){
			dp[j][0] =1;	   
		}

		for(int i=1; i<m; i++){
			for( int j =1; j<n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];	  //top + left
				System.out.println(" dp: " + Arrays.deepToString(dp));
			}
		}    
		return dp[m-1][n-1];
	}

	public static void main(String[] args){
		UniquePaths test = new UniquePaths();
		int paths = test.uniquePaths2(3, 7);
		
		System.out.println(paths);
		
	}

}
