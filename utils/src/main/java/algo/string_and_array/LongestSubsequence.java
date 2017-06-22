package algo.string_and_array;

public class LongestSubsequence {

	boolean isPali(String str){
		int i=0, j = str.length()-1;

		while(i < j){
			if(str.charAt(i++) != str.charAt(j--) ) return false;

		}
		return true;
	}

	
	//------------- Solution one
	
/*
 * 
 * 
check all the palindrome use index i as center 
 * 
 */
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
		
		if (s.length() == 1) {
			return s;
		}

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = getPalindromeUseMidIndex(s, i, i);
			System.out.println(" tmp�� is: " +tmp);
			
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	// Given a center index
	// Find longest palindrome
	public String getPalindromeUseMidIndex(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
				
		System.out.println("s is: |" + s + "|-----> returnning : " + s.substring(begin + 1, end));
		
		return s.substring(begin + 1, end);
	}

	public static void main(String args[]){
		String str = "abcbbdbbdced";

		LongestSubsequence test = new LongestSubsequence();
		System.out.println("result: " + test.longestPalindrome2(str));
	}

	
	//------------- Solution two
	public String longestPalindrome2(String s) {
		if (s.isEmpty()) {
			return null;
		}
		
		if (s.length() == 1) {
			return s;
		}

		int longest = 1;
		String longestStr = "";
		
		for (int i = 0; i < s.length(); i++) {
			for( int j=i; j<s.length(); j++){
				String subStr = s.substring(i, j);
				
				if(this.isPali(subStr)) {
					int length = subStr.length();
					if(length > longest) {longestStr = subStr; longest = length;}
				}
			}
		}
		return longestStr;
	}

}
