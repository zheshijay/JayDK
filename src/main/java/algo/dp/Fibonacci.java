package algo.dp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	

	// Function to print N Fibonacci Number
	static void Fibonacci(int N) {
		int num1 = 0, num2 = 1;

		int counter = 0;

		// Iterate till counter is N
		while (counter < N) {

			// Print the number
			System.out.print(num1 + " ");

			// Swap
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter = counter + 1;
		}
	}

	// Function to print the fibonacci series
	static int fib(int n) {
		// Base Case
		if (n <= 1)
			return n;

		// Recursive call
		return fib(n - 1) + fib(n - 2);
	}

	
	// Function to find the fibonacci Series
		static int fibDp(int n) {
			if (n<1) return 0;
			
			 int[] dp = new int[n+1];
		        dp[0] = 0;
		        dp[1] = 1;

		        for (int i = 2; i <= n; i++) {
		            dp[i] = dp[i-1] + dp[i-2];
		        }
		        
		        return dp[n];
		}

	public static void main(String[] args) {
		Fibonacci test = new Fibonacci();

		System.out.println("DP fibnacci:");
		System.out.println(test.fibDp(45));

//		System.out.println("Regular fibnacci:");
//		System.out.println(test.getFibonacci(45));
	}

}
