package algo.string_and_array;

/*
 * 
 * 
 * 
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Analysis

The following cases should be considered for this problem:

1. null or empty string
2. white spaces
3. +/- sign
4. calculate real value
5. handle min & max
 */
public class StringtoInteger {
	public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        
        if (!Character.isDigit(str.charAt(0))
            && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        
        long ans = 0L;
       
        boolean neg = str.charAt(0) == '-';
       
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        
        return neg ? (int) -ans : (int) ans;
    }
	
	  public static void main(String[] args) {
		  
		  StringtoInteger test = new StringtoInteger();
		  
		  
		String strA = "-2345";
		int intA = test.myAtoi(strA);
		 
		System.out.println(intA);
		  
//		double a = 1;
//		char b = '2';
//		System.out.println("b:" + b);
//		System.out.println("b-0:" + (b - '0'));
//		System.out.println("a+b:" + (a+(b-'0')));
//		
		  
	}
}
