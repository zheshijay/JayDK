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
	        int len = s.length();
	        if (len < 2) {
	            return s;
	        }
	        int maxLen = 1;
	        String res = s.substring(0, 1);
	        // 中心位置枚举到 len - 2 即可
	        for (int i = 0; i < len - 1; i++) {
	            String oddStr = centerSpread(s, i, i);
	            String evenStr = centerSpread(s, i, i + 1);
	            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
	            if (maxLenStr.length() > maxLen) {
	                maxLen = maxLenStr.length();
	                res = maxLenStr;
	            }
	        }
	        return res;
	    }

	    private String centerSpread(String s, int left, int right) {
	        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
	        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
	        int len = s.length();
	        int i = left;
	        int j = right;
	        while (i >= 0 && j < len) {
	            if (s.charAt(i) == s.charAt(j)) {
	                i--;
	                j++;
	            } else {
	                break;
	            }
	        }
	        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
	        return s.substring(i + 1, j);
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
