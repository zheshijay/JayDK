package algo.string_and_array;


/**
 * 
Input  : {"geeksforgeeks", "geeks", "geek", "geezer"}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"
 */
public class LongestCommonPrefix {

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



	public String myLongestPrefix(String[] strs){
		String prefix= strs[0];
		for(int i=1; i<strs.length; i++){ 
			while(strs[i].indexOf(prefix)!=0)	
				prefix=prefix.substring( 0, prefix.length()-1 );
			System.out.println(" prefix now is :" + prefix);

		}
		return prefix;

	}


	public static void main(String args[]){
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] strs = new String[]{"geeksforgeeks", "geeks", "geek", "geezer"};
		System.out.println(test.myLongestPrefix(strs));
	}
}
