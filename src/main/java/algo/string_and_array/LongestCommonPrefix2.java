package algo.string_and_array;


/**
 * 
Input  : {"geeksforgeeks", "geeks", "geek", "geezer"}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"
 */
public class LongestCommonPrefix2 {

	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)    return "";
		
		String pre = strs[0];
		
		System.out.println(" init pre is 111 :" + pre);
		int i = 1;
		while(i < strs.length){
			while(strs[i].indexOf(pre) != 0){
				pre = pre.substring(0,pre.length()-1);
				System.out.println(" pre now is :" + pre);
			}
			i++;
		}
		return pre;
	}
	
	public static void main(String args[]){
		LongestCommonPrefix2 test = new LongestCommonPrefix2();
		String[] strs = new String[]{"good",  "goodboy"};
		System.out.println(test.longestCommonPrefix(strs));
	}
}
