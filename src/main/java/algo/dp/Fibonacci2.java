package algo.dp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci2 {
	

	
	// Function to find the fibonacci Series
		int fib(int n) {
			int[] dp = new int[n+1];
			dp[0] = 0;
			dp[1] = 1;
			for(int i=2; i<n+1; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			
			return dp[n];
			 
		}

	public static void main(String[] args) {
		Fibonacci2 test = new Fibonacci2();

		System.out.println("DP fibnacci:");
		System.out.println(test.fib(45));

//		System.out.println("Regular fibnacci:");
//		System.out.println(test.getFibonacci(45));
	}

}
