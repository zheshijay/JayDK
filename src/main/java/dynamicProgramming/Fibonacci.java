package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	//Regular
	public int getFibonacci(int n){
		if(n < 3) return 1;  //base case
		return getFibonacci(n-2) + getFibonacci(n-1);  //recursion
	}
	
	//DP
	public long getFibonacciVal(int n){
		Map<Integer, Long> map = new HashMap<Integer, Long>();  //use a Map to hold the already computed results.
		
		//base case  initialize this map with the 2 base cases
		map.put(1, 1L);
		map.put(2, 1L);
		
		//recursion
		return getFibonacciDP(n, map);
	}
	
	public long getFibonacciDP(int n, Map<Integer, Long> map){
		
		if(map.containsKey(n)) return map.get(n);
		
		long val1 = map.put(n-1, getFibonacciDP(n-1, map));
		long val2 = map.put(n-2, getFibonacciDP(n-2, map));
		
		long newVal = val1 + val2;
		map.put(n, newVal);
		
		return newVal;
	}

	public static void main(String[] args){
		Fibonacci test = new Fibonacci();
		System.out.println(test.getFibonacciVal(40));
		System.out.println(test.getFibonacci(40));
	}
	
	
}
