package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0050myPow {
	static double quickMul(double x, long N) {
		double ans = 1.0;
		// 贡献的初始值为 x
		double contribute = x;
		// 在对 N 进行二进制拆分的同时计算答案(根据递归计算的结果，如果 nn 为偶数，那么 x^n = y^2x 如果 nn 为奇数，那么 x^n = y^2
		// * xx
		while (N > 0) {
			System.out.println("N:" + N);

			if (N % 2 == 1) {
				System.out.println("odd N:" + N);
				ans *= contribute;
				
			}
			contribute *= contribute;
			N /= 2;

		}
		return ans;
	}

	public double myPow(double x, int n) {
		long N = n;
		return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	}

	public static void main(String[] args) {
		System.out.println(LC0050myPow.quickMul(3.1D, 9));
	}

}
