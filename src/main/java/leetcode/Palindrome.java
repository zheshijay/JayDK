package leetcode;


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

	public static boolean checkPalindrome(String str) {
		for(int i=0;i<=str.length()/2;i++)
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
				return false;
		return true;
	}

	public static void printAllPalindrome(String str) {
		for(int i=0;i<=str.length();i++)
			for(int j=i;j<str.length();j++)
				if(checkPalindrome(str.substring(i,j+1)))
					System.out.println(str.substring(i,j+1));
	}


	public boolean myIsPalindome(String str){
		int len = str.length();
		for(int i=0; i<= (len-1)/2; i++){
			if(str.charAt(i) != str.charAt(len-1-i)) return false;
		}
		return true;
	}

	void myPrintAllPalindrome(String str){
		
		for(int i=0; i < str.length(); i++){
			for(int j=i; j< str.length(); j++){
				String eachStr = str.substring(i, j+1);
				
				boolean isPalidrome = myIsPalindome(eachStr);
				
				System.out.println(eachStr + " isPalidrome: " + isPalidrome);
				
				if(isPalidrome) System.out.println(eachStr);
			}
		}
		
		
	}






	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome test = new Palindrome();
		//		System.out.println(test.isPalindrome(121));
		test.myPrintAllPalindrome("abcdedc");


	}

}
