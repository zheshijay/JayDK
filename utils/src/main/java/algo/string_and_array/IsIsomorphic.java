package algo.string_and_array;

import java.util.HashMap;
import java.util.Map;


/*
 * 
 * 
 * 
Input:  str1 = "aab", str2 = "xxy"
Output: True
'a' is mapped to 'x' and 'b' is mapped to 'y'.

Input:  str1 = "aab", str2 = "xyz"
Output: False
One occurrence of 'a' in str1 has 'x' in str2 and 
other occurrence of 'a' has 'y'.
 */

public class IsIsomorphic {
	public boolean isIsomorphic(String s, String t) {
		if(s == null || s.length() <= 1) return true;

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for(int i = 0 ; i< s.length(); i++){
			char a = s.charAt(i);
			char b = t.charAt(i);

			System.out.println(" | " + a + " - | " + b + " |  map: " + map);


			if(map.containsKey(a)){

				System.out.println("map.containsKey(a)");

				if(map.get(a).equals(b)){
					System.out.println("continue");
					continue;
				}else
					return false;

			}else{


				System.out.println("[ map.containsValue(b) ] " + map.containsValue(b));
				if(!map.containsValue(b)){
					System.out.println("---> add key:" + a + " and value: " + b);
					map.put(a,b);	
				}
				else return false;

			}
		}
		return true;
	}

	//	public boolean myIsomorphic(String str1, String str2) {
	//
	//		if(str1 == null || str2 == null || str1.length() != str2.length()) return false;
	//
	//		HashMap map = new HashMap();
	//
	//		for(int i=0; i< str1.length(); i++){
	//			char c1 = str1.charAt(i);
	//			char c2 = str2.charAt(i);
	//
	//			if(map.containsKey(c1)){
	//				if(!map.get(c1).equals(c2)) return false;
	//				else continue;  //same key and value, skip it
	//			}else{
	//				if(!map.containsValue(c2)){
	//					map.put(c1, c2);
	//				}else{
	//					return false;
	//				}
	//			}
	//		}
	//		return true;
	//	}

	
	public boolean myIsomorphic(String str1, String str2) {
		if(str1 == null || str2 == null || str1.length() != str2.length()) return false;

		Map<Character, Character> map = new HashMap();

		for(int i=0; i<str1.length(); i++ ){
			char c1 = str1.charAt(i), c2=str2.charAt(i);

			if(map.containsKey(c1) && map.get(c1) != c2){
				return false;
			}
			
			if(map.containsValue(c2) && !map.containsKey(c1)){
				return false;
			}
			
			if(!map.containsKey(c1) && !map.containsValue(c2)){
				map.put(c1, c2);
			}
		}
		
		return true;
	}

	public static void main(String args[]){
		IsIsomorphic test = new IsIsomorphic();

		String str1 = "121";
		String str2 = "454";

		System.out.println(test.myIsomorphic(str1, str2));
	}
}
