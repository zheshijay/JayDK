package algo.leetcode;

public class LC0007reverse {

	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			
			// 越界判断 start
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			// 越界判断 end
			
			res = res * 10 + pop;
			
			System.out.println("res:" + res + "|pop:" + pop);
		}
		return res;
	}

	public static void main(String[] args) {
		LC0007reverse test = new LC0007reverse();
		
		
		int res = test.reverse(123);
		System.out.println("res:" + res);
		
	}
}
