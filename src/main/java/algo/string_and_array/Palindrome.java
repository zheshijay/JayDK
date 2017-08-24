package algo.string_and_array;


public class Palindrome {
	/*
	 * Java method to check if number is palindrome or not
	 */
	public static boolean isPalindrome(int number) {
		if(number < 0) return false;

		int palindrome = number; // copied number into variable
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}

		// if original and reverse of number is equal means
		// number is palindrome in Java
		if (number == reverse) {
			return true;
		}
		return false;
	}


	boolean isPalindrome(String str) {    
		int n = str.length();
		for( int i = 0; i < n/2; i++ )
			if (str.charAt(i) != str.charAt(n-i-1)) return false;
		return true;    
	}

	public boolean istPalindromStr(String str){
		char[] word = str.toCharArray();
		int i1 = 0;
		int i2 = word.length - 1;
		while (i2 > i1) {
			if (word[i1] != word[i2]) {
				return false;
			}
			++i1;
			--i2;
		}
		return true;
	}


	public boolean myIsPalindrome(String str){
		char[] charArray = str.toCharArray();

		int i=0; 
		int j=charArray.length-1;

		while(i < j){
			System.out.println("charArray[i]: " + charArray[i]);
			System.out.println("charArray[j]: " + charArray[j]);
			
			if(charArray[i] != charArray[j]) return false;
			++i;
			--j;
		}
		return true;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome pa = new Palindrome();
		System.out.println(pa.myIsPalindrome("aba"));
	}

}
