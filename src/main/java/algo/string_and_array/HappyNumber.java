package algo.string_and_array;

import java.util.HashSet;

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

//		System.out.println(test.isHappy(11));
		
		int a = 123;
		
		System.out.println(a%10);
		System.out.println(a/10);
		
	}
}
