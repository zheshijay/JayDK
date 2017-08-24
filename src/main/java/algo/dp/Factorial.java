package algo.dp;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

	/*
	 * 
	 * Regular factorial
	 */

	//1 2(2*1)  6(3*2*1)   24(4*3*2*1)  
	public Long factorial(int n){
		if( n ==1 ) return 1L;
		return n * factorial(n-1);
	} 
	
	
	
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

	public static void main(String[] args){
		Factorial test = new Factorial();

//		System.out.println("DP fibnacci:");
//		System.out.println(test.runFibnacciUseDP(50));

		System.out.println("Regular factorial:");
		System.out.println(test.factorial(99));
		
		System.out.println("DP factorial:");
		System.out.println(test.runDPfactorial(99));
	}

}
