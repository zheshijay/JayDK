package algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Factorial2 {

	/*
	 * 
	 * 1 2(2*1)  6(3*2*1)   24(4*3*2*1)
	 */
	
	
	long factorial(int n) {
		long[] dp = new long[n+1];
		dp[0] = 1;
		for(int i=1; i<n+1;i++) {
			dp[i] = i * dp[i-1];
		}
		System.out.println("dp:" + Arrays.toString(dp));
		return dp[n];
	}
	
	public static void main(String[] args){
		Factorial2 test = new Factorial2();

//		System.out.println("DP fibnacci:");
//		System.out.println(test.runFibnacciUseDP(50));

		System.out.println("Regular factorial:" + test.factorial(5));

//		System.out.println("DP factorial use map:" + test.runDPfactorial(5));
//
//		System.out.println("DP factorial use array:" + test.DPFactorial2(5));

	}

}
