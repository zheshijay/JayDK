package algo.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q010Fib {

	/*
	 * Resurtion
	 */
	public int fib(int n) {
		if (n - 1 <= 1) return 1;
		return fib(n-1) + fib(n-2);
	}
	
	/*
	 * 
	 */
	public int fib2(int n) {
		int[] fib = new int[n];
		fib[1] = 1;
		fib[2] = 1;
		
		int i = 3;
		while (i < n) {
			
		}
		
		if (n - 1 <= 1) return 1;
		return fib(n-1) + fib(n-2);
	}

	public static void main(String[] args) {

		Q010Fib test = new Q010Fib();
		int i= 1;
		System.out.println(test.fib(5));
//		while (i < 9) {
//			System.out.println(test.fib(i++));
//		}
		

	}

}