package algo.dp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	//Regular
	public Long getFibonacci(int n){
		if(n < 3) return 1L;  //base case
		return getFibonacci(n-2) + getFibonacci(n-1);  //recursion
	}


	public Long runFibnacciUseDP(int n){
		Map<Integer, Long> map = new HashMap<>();
		map.put(1, 1L);
		map.put(2, 1L);
		
		return DPfibonacci(map, n);

	}
	
	public Long DPfibonacci(Map<Integer, Long> map, int n){
		if(n < 3) return 1L;

		if(map.containsKey(n)) return map.get(n);
		else{
			Long fibN = DPfibonacci(map, n-1) + DPfibonacci(map, n-2);
			map.put(n, fibN);
		}

		return map.get(n);
	}


	public static void main(String[] args){
		Fibonacci test = new Fibonacci();
		
		System.out.println("DP fibnacci:");
		System.out.println(test.runFibnacciUseDP(50));
		
		System.out.println("Regular fibnacci:");
		System.out.println(test.getFibonacci(50));
	}


}
