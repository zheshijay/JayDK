package algo.string_and_array;

import java.util.HashMap;


/*
 * 
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

public class PalindromeLongest2 {


	public static void main(String args[]){
//		String str = "banana";
		
		String str = "aba";

//		String str = "abcba";
		PalindromeLongest2 test = new PalindromeLongest2();
		System.out.println("result: " + test.longestPalindrome(str));
	}

	public int longestPalindrome(String s) {
        int[] character = new int[58];
        int result = 0;
        for(char c : s.toCharArray())
        {
            character[c-'A']++;
        }

        for(int i = 0; i < 58; i++)
        {
            if(character[i] % 2 == 0)
                result += character[i];
            else
                result += character[i]-1;
        }

        return result >= s.length() ? result : result + 1;
    }
	
	  public int longestPalindrome2(String s) {
	        HashMap<Character,Integer> map = new HashMap<>();
	        int result = 0;
	        for(char c : s.toCharArray())
	        {
	            map.put(c,map.getOrDefault(c,0)+1);
	        }

	        for(Character key : map.keySet())
	        {
	            int count = map.get(key);       
	            if(count % 2 == 0)
	                result += map.get(key);
	            else
	                result += map.get(key) - 1;
	        }

	        return result < s.length() ? result+1 : result;
	    }

}
