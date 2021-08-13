package algo.dp;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

	/*
	 * 
	 * 1 2(2*1)  6(3*2*1)   24(4*3*2*1)
	 */

	// 1. Regular Factorial
	public Long factorial(int n){
		if( n ==1 ) return 1L;
		return n * factorial(n-1);
	} 
	
	
	// 2. DP Factorial use Map
	public Long runDPfactorial(int n){
		Map<Integer, Long> map = new HashMap<>();
		map.put(1, 1L);
		map.put(2, 2L);
		return DPfactorial(map, n);
	} 
	
	
	public Long DPfactorial(Map<Integer, Long> map , int n){

		if(map.containsKey(n)) return map.get(n);
		else{
			Long nFac = n * DPfactorial(map, n-1);
			map.put(n, nFac);
		}
		
		return map.get(n);
	} 

	// 2. DP Factorial use Array
	public Long DPFactorial2(int n) {
		long[] dp = new long[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		int index = 3;
		while (index < n + 1) {
			dp[index] = index * dp[index-1];
//			System.out.println("dp-" + index + ":" + dp[index]);
			index++;
		}
		return dp[n];
	}
	
	
	
	public static void main(String[] args){
		Factorial test = new Factorial();

//		System.out.println("DP fibnacci:");
//		System.out.println(test.runFibnacciUseDP(50));

		System.out.println("Regular factorial:" + test.factorial(5));

		System.out.println("DP factorial use map:" + test.runDPfactorial(5));

		System.out.println("DP factorial use array:" + test.DPFactorial2(5));

	}

}
