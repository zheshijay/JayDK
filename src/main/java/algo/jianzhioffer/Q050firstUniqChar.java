package algo.jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;

/*
输入两个链表，找出它们的第一个公共节点。
 */

public class Q050firstUniqChar {
	 public char firstUniqChar(String s) {
	        Map<Character, Boolean> dic = new LinkedHashMap<>();
	        char[] sc = s.toCharArray();
	        for(char c : sc)
	            dic.put(c, !dic.containsKey(c));
	        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
	           if(d.getValue()) return d.getKey();
	        }
	        return ' ';
	    }

	 /*
	  * ASC2 Solution
	  */
	 public char firstUniqChar2(String s) {
	        if(s == "") return ' ';
	        int[] count  = new int[26];
	        for(int i = 0; i < s.length(); i++){
	            count[s.charAt(i) - 'a']++;
	        }
	        for(int i = 0; i < s.length(); i++){
	            if(count[s.charAt(i) - 'a'] == 1){
	               return  s.charAt(i);
	            }
	        }
	        return ' ';
	    }
	 
	 public char firstUniqChar3(String s) {
	        if(s == "") return ' ';
	        
	        int[] count  = new int[26];

	        for(int i = 0; i < s.length(); i++){
	            count[s.charAt(i) - 'a']++;
	        }
	        for(int i = 0; i < s.length(); i++){
	            if(count[s.charAt(i) - 'a'] == 1){
	               return  s.charAt(i);
	            }
	        }
	        return ' ';
	    }


}