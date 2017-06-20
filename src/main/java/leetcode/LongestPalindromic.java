package leetcode;


public class LongestPalindromic {

	public String longestPalindrome(String s){
		if(s == null || s.isEmpty()){
			return s;
		}
		
		int maxLength = 0;
		String res = "";
		
		//expand odd
		for(int i=0; i<s.length(); i++){
			String tmp = this.expand(s, i-1, i+1);
			
			if(tmp.length()>maxLength){
				maxLength = res.length(); 
				res = tmp;
			}
		}
		
		//expand even
		for(int i=0; i<s.length(); i++){
			String tmp = this.expand(s, i, i+1);
			if(tmp.length()>maxLength){
				maxLength = res.length(); 
				res = tmp;
			}
		}
		return res;
	}

	private String expand(String s, int left, int right){
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		
		System.out.println("return s.substring(left+1, right): " + s.substring(left+1, right));
		return s.substring(left+1, right);
	}
	
	
	public static void main(String[] args) {
		LongestPalindromic test = new LongestPalindromic();
		
		String str = "acabbac";
		String palindome = test.longestPalindrome(str);
		System.out.println(palindome);
		
		

	}

}
