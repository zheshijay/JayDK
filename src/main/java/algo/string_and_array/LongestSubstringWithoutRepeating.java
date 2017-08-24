package algo.string_and_array;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

	
	
	
	
	/*
	 * 
	 * 
LeetCode �C Longest Substring Without Repeating Characters (Java)
 
Given a string, find the length of the longest substring without repeating characters. 

For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 

For "bbbbb" the longest substring is "b", with the length of 1.
	 * 
	 */
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		
		
		HashSet<Character> set = new HashSet();
		char[] chars = s.toCharArray();
		
		int longest=0;
		
		int count=0;
		
//		String longestStr="";
		
		for(int i=0; i<chars.length; i++){
			
			char c = chars[i];
			
			System.out.println(" checking c " + c);
			
			if(!set.contains(c)){
				
				System.out.println("--> add " + c + " to set");
				
				set.add(c);
				count++;
//				longestStr += c;
			}else{
				System.out.println(" clear set");
				count=0;
				set.clear();
			}
			longest = Math.max(count, longest);
		}



		return longest;
	}


	public static void main(String args[]){
		LongestSubstringWithoutRepeating test = new LongestSubstringWithoutRepeating();
		System.out.println(test.lengthOfLongestSubstring("abcdefg"));
	}
}
