package algo.leetcode;

public class ReverseNumber {
	public int reverse(int x) {
	
		
		

		if (x == 0) {
			return 0;
		}
		boolean isPositive = x >= 0;
		boolean hasLeadingZero = true;
		if (!isPositive) {
			x = x * -1;
		}

		int res = 0;
		while (x != 0) {
			int cur = x % 10;
			x = x / 10;
			
			if (Math.abs(res) >= Integer.MAX_VALUE) {
				return 0;
			}
			
			res = res * 10 + cur;
		}

		if (!isPositive) {
			res = res * -1;
		}

		return res;
	}

	public static void main(String[] args) {
		  ReverseNumber test = new ReverseNumber();
		int x = 1534236469;
		int res = test.reverse(x);
		System.out.println(res);
		
	}
}
