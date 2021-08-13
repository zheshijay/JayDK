package algo.leetcode;


public class LongestPalindromic {

//	public String longestPalindrome(String s){
//		if(s == null || s.length() < 2){
//			return s;
//		}
//		
//		int maxLength = 0;
//		String res = "";
//		
//		//expand odd
//		for(int i=0; i<s.length(); i++){
//			String tmp = this.expand(s, i-1, i+1);
//			
//			if(tmp.length()>maxLength){
//				maxLength = tmp.length(); 
//				res = tmp;
//			}
//		}
//		
//		//expand even
//		for(int i=0; i<s.length(); i++){
//			String tmp = this.expand(s, i, i+1);
//			if(tmp.length()>maxLength){
//				maxLength = tmp.length(); 
//				res = tmp;
//			}
//		}
//		return res;
//	}
//
//	private String expand(String s, int left, int right){
//		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
//			left--;
//			right++;
//		}
//		
//		System.out.println("return s.substring(left+1, right): " + s.substring(left+1, right));
//		return s.substring(left+1, right);
//	}
	
	public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i-1, i+1);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }
	
	
	public static void main(String[] args) {
		LongestPalindromic test = new LongestPalindromic();
		
//		String str = "acabbac";
		String str = "ccc";
		String palindome = test.longestPalindrome(str);
		System.out.println(palindome);
		
		

	}

}
