package algo.jianzhioffer;

/*
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

 

示例:

输入: a = 1, b = 1
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

public class Q065_2add {
	public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
        	
        	System.out.println("-- b:" + b);
        	
            int c = (a & b) << 1;  // c = 进位
            System.out.println("-- c:" + c);
            
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

	public static void main(String[] args) {

		Q065_2add test = new Q065_2add();
		
		int a = 1, b =2;

		
//		int res = test.add(a, b);

		System.out.println(a & b);
	}

}