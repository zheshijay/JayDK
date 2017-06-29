package algo.string_and_array;

import java.util.HashSet;

/*
 * 
 * 
 * 
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which 
does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1
 */
public class HappyNumber {
	//-------------Solution
	private int getNextHappy(int n) {
		System.out.println("next happy: " + n);
		
		int sum = 0;
		while (n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

	public boolean isHappy(int n) {
		HashSet<Integer> hash = new HashSet<Integer>();
		
		while (n != 1) {
			
			System.out.println("hash: " + hash);
			
			if (hash.contains(n)) {
				return false;
			}
			hash.add(n);
			n = getNextHappy(n);
		}
		return true;
	}
	


	public static void main(String args[]){
		HappyNumber test = new HappyNumber();

		System.out.println(test.isHappy(11));
	}
}
