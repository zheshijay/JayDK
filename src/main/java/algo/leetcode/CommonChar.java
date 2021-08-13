package algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CommonChar {/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<String>();
		arr.add("aghkafgklt");
		arr.add("dfghako");
		arr.add("qwemnaarkf");
		
		findCommon(arr);
	}
	
	public static void findCommon(List<String> arr){
		Set<Character> tmp1 = new TreeSet<Character>();
		Set<Character> tmp2 = new TreeSet<Character>();
		
		//Place all chars from first string in tmp1
		for(char c:arr.get(0).toCharArray())
			tmp1.add(c);
		
		System.out.println(tmp1.size()+" : "+tmp1);
		
		//Parse through all the strings.
		for(String s:arr){
			for(char c:s.toCharArray()){
				if(tmp1.contains(c))
					tmp2.add(c);
			}
			tmp1.clear();
			tmp1.addAll(tmp2);
			tmp2.clear();
		}
		System.out.println(tmp1.size()+" : "+tmp1);
	}
}
