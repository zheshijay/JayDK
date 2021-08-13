package algo.string_and_array;

/**
 * 
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class SumString {
	public static String sumString(String num1, String num2){
		int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        
        System.out.println("ans is:" + ans);
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
	}

	public static void main(String args[]){
//		String s1 = "123";
//		String s2 = "957";
//		
//		System.out.println(SumString.sumString(s1, s2));
		System.out.println(0/10);
		
	}
	
	
	
}
