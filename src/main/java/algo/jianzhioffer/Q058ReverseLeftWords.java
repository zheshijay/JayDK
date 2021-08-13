package algo.jianzhioffer;

/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 

示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

 */

public class Q058ReverseLeftWords {
//	public String reverseLeftWords(String s, int n) {
//		StringBuffer buffer = new StringBuffer();
//		
//		for()
//		
//		
//		return null;
//	}
	public String reverseLeftWords(String s, int n) {
		n = n % s.length();
        return s.substring(n, s.length()) + s.substring(0, n);
    }

	 public String reverseLeftWords2(String s, int n) {
		 	n = n % s.length();
	        StringBuilder res = new StringBuilder();
	        for(int i = n; i < s.length(); i++)
	            res.append(s.charAt(i));
	        for(int i = 0; i < n; i++)
	            res.append(s.charAt(i));
	        return res.toString();
	    }

	 public String reverseLeftWords3(String s, int n) {
	        String res = "";
	        for(int i = n; i < s.length(); i++)
	            res += s.charAt(i);
	        for(int i = 0; i < n; i++)
	            res += s.charAt(i);
	        return res;
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 public static String reverseLeftWords5(String s, int n) {
		 n = n % s.length();
		 StringBuffer str = new StringBuffer();
		 for(int i=n; i < s.length(); i++) {
			 str.append(s.charAt(i));
		 }
		 for(int i=0; i < n; i++) {
			 str.append(s.charAt(i));
		 }
		 return str.toString();
	 }
	
	public static void main(String[] args) {
		String s = "abcdefg";
		Q058ReverseLeftWords test = new Q058ReverseLeftWords();
		
		
		System.out.println(test.reverseLeftWords5(s, 2));
	}

}