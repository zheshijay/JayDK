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
	public static String sumString(String s1, String s2){
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		

		int carry = 0;
		
		int l1 = s1.length()-1, l2 = s2.length()-1;
		
		
		StringBuilder sumStr = new StringBuilder();
		
		while( l1 >=0 || l2 >= 0 || carry == 1){

			System.out.println("=================> l1- " + l1 + " - " + "l2- " + l2);
			int int1 = ( l1>=0)? (c1[l1] - '0'):0;
			
			int int2 = ( l2>=0)? (c2[l2] - '0'):0;
			
			System.out.println("-----> int1- " + int1 + " - " + "int2- " + int2);
			
			int sum =  int1 + int2 + carry;
			
			carry = sum/10;
			int val = sum % 10;

			sumStr.insert(0, val);
			System.out.println("carry is: " + carry);
			System.out.println("sumStr is: " + sumStr);
			
			l1--; 
			l2--;
			
			
		}
		
		return sumStr.toString();
		
		
	}
	
	
	
	public static void main(String args[]){
		String s1 = "123";
		String s2 = "957";
		
		System.out.println(SumString.sumString(s1, s2));
		
	}
	
	
	
}
