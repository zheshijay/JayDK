package algo.leetcode;


public class IsSubString {
	public static boolean isSubstring(String s1, String s2){
		
        // the index of s1
        int i = 0;
        // the index of s2
        int j = 0;
        // for（int i = 0; i<s1.length(); i++）
        //temp = i;
        // for(int j = 0; j<s2.length();j++)
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i ++;
                j ++;
            }else{
                // Backtracking
                i = i - j + 1;
                j = 0;
            }
        }
        return j == s2.length();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsSubString test = new IsSubString();

		System.out.println(test.isSubstring("abcdefg", "de"));
	
	}

}
