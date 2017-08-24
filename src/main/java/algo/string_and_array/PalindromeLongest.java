package algo.string_and_array;

import java.util.Arrays;

import algo.utils.PrintUtils;

public class PalindromeLongest {


	public static void main(String args[]){
//		String str = "banana";
		
		String str = "aba";

//		String str = "abcba";
		PalindromeLongest test = new PalindromeLongest();
		System.out.println("result: " + test.myLongestPalindromeDP(str));
	}

	//  b a n a n a
	//b
	//a
	//n
	//a
	//n
	//a

	public String myLongestPalindromeDP(String s) {

		//init dp
		int len=s.length();
		int beginAt=0, maxLen=1;
		boolean[][] dp = new boolean[len][len];

		//Trivial case: single letter palindromes
		for(int i=0; i< len; i++){
			dp[i][i] = true;
		}
		
		//Finding palindromes of two characters.
		for(int i=0; i< len-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				dp[i][i+1] = true;
				beginAt=i;
				maxLen=2;
			}
		}
		
		PrintUtils.printTwoDArray(dp);

		  //Finding palindromes of length 3 to n and saving the longest
		for(int curLen=3; curLen<=len; curLen++){
			for(int row=0; row <len-curLen+1; row++){
				
				int end = row+curLen-1;
				
				System.out.println("curLen: " + curLen + " row: " + row + " end:" + end);
				System.out.println("s.charAt(row): " + s.charAt(row) + " s.charAt(end): " + s.charAt(end) );
				System.out.println("dp[row+1][end-1]:" + dp[row+1][end-1]);
				
				if( ( s.charAt(row) == s.charAt(end) )  //1. The first and last characters should match 
						&& dp[row+1][end-1]  //2. Rest of the substring should be a palindrome
					){
					dp[row][end] = true;
					beginAt = row;
					maxLen = curLen;
				}
			}  
		}
		
		
		System.out.println("----------------------------------------------");
		PrintUtils.printTwoDArray(dp);
		
		System.out.println("for s: " + s + " beginAt:" + beginAt + " maxLen:" + maxLen + " substring:" + beginAt + " to " + (beginAt+maxLen));
		
		return s.substring(beginAt, beginAt+maxLen);
	}
	

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
			String tmp = helper(s, i, i);
			System.out.println(" tmp is: " +tmp);

			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	// Given a center index
	// Find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}

		System.out.println("s is: |" + s + "|-----> returnning : " + s.substring(begin + 1, end));

		return s.substring(begin + 1, end);
	}
	
	//Brute force
	boolean isPali(String str){
		int i=0, j = str.length()-1;

		while(i < j){
			if(str.charAt(i++) != str.charAt(j--) ) return false;

		}
		return true;
	}
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
