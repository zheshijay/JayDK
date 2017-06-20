package qa;

public class MaximumPalindromeLength {

	public static int findMaximumPalindromeLength(int[] number){
		
		int[] noOfOccurences = new int[10];
		int palindromeLength = 0;
		
		
		for(int i=0;i<number.length;i++){
			int num = number[i];
			System.out.print(" " + num);
			noOfOccurences[num] += 1; 
		}
		
		System.out.println();
		for(int each: noOfOccurences){
			System.out.print(each + " ");
		}
		
		
		System.out.println();
		
		for(int i=0 ; i<10; i++){
		
			System.out.println("------");
			System.out.print("	noOfOccurences of "+i+" is "+noOfOccurences[i]);
			double division = (double)noOfOccurences[i]%2;
			System.out.print("	---> division value is "+division);
			if(division>0){
				palindromeLength += noOfOccurences[i]-1;
			}else{
				palindromeLength += noOfOccurences[i];
			}
			
			System.out.print("	palindromeLength now is: " + palindromeLength);
		}
		return palindromeLength+1;
	}
	
	
	
	// Solution 2
	public static String longestPalindrome(String s) {
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
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {2,5,2,7,2};
		System.out.println();
		int result = findMaximumPalindromeLength(nums);
		System.out.println();
		System.out.println(result);
//		System.out.println("MaximumPalindromeLength: "+longestPalindrome("absbsbsb"));

	}

}
