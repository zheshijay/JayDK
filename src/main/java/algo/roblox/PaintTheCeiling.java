package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintTheCeiling {

	/**
	 * @param s0: the number s[0]
	 * @param n:  the number n
	 * @param k:  the number k
	 * @param b:  the number b
	 * @param m:  the number m
	 * @param a:  area
	 * @return: the way can paint the ceiling
	 */
	public long painttheCeiling(int s0, int n, int k, int b, int m, long a) {

		// 先算出来n的S集合
		long[] A = new long[n];
		A[0] = s0;
		for (int i = 1; i < n; i++) {
			A[i] = (k * A[i - 1] + b) % m + 1 + A[i - 1];
		}
		
		System.out.println("A:" + Arrays.toString(A));
		
		//由于S集合是递增，可以用对撞双指针求方案数即可
		long res = 0;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            if (A[l] * A[r] <= a) {
              res += 2L * (r - l) + 1;
//            res +=1;
                l++;
            } else {
                r--;
            }
        }
        
        return res;

	}
	
	public static void main(String[] args) {
		int s0 = 2,  n=3,  k=3, b=3, m=2, a=15;
		PaintTheCeiling test = new PaintTheCeiling();
		long res = test.painttheCeiling(s0, n, k, b, m, a);
		System.out.println(res);
		
	}

}
