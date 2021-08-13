package algo.string_and_array;

public class RepeatedStringPattern {
/*
 * 

给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/repeated-substring-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 * 
 */
	 public boolean repeatedSubstringPattern(String s) {
	        int i = 0;
	        char startOfString = s.charAt(0);
	        i++;
	        char ch;
	        while(i < s.length()){
	            if((ch=s.charAt(i)) != startOfString){
	                //create a substring until the char at start of string is encountered 
	                i++;
	            }else{
	                if(s.split(s.substring(0,i)).length == 0){
	                    return true;
	                }else{
	                    //false alarm. continue matching.
	                    i++;
	                }
	            }
	        }
	        return false;
	    }

	 public boolean repeatedSubstringPattern3(String s) {
	        String str = s + s;
	        return str.substring(1, str.length() - 1).contains(s);
	}


	 public boolean myRepeatStrPattern(String str){
		 
		 if(str.length() == 2 && str.charAt(0) == str.charAt(1)) return true;
		 
		 String pattern = "";
		 char firstChar = str.charAt(0);
		 
		 System.out.println("firstChar is: " + firstChar);
		 
		 
		 
		 int i=1;
		 while(i < str.length()-1){
			 if(str.charAt(i) != firstChar) i++;
			 else{  System.out.println("-- found pattern is: " + str.substring(0, i)); pattern = str.substring(0, i); break;}
		 }
		 
		 System.out.println("pattern is: " + pattern);
		 if(str.split(pattern).length == 0) return true;
		 
		 return false;
	 }
	 


	public static void main(String args[]){
		RepeatedStringPattern test = new RepeatedStringPattern();

		String str = "ababab";
		boolean res = test.myRepeatStrPattern(str);

		System.out.println("res: "+ res);


	}
}
