package algo.leetcode;

public class LC0005longestPalindrome {

	public String longestPalindrome(String s) {
		int len = s.length();
        if (len < 2) {
            return s;
        }
        
		String res = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// even
			String evenPali = bfs(i, i + 1, s);
			// odd
			String oddPali = bfs(i - 1, i + 1, s);

			String curLongest = evenPali.length() > oddPali.length() ? evenPali : oddPali;
			if (res.length() < curLongest.length()) {
				res = curLongest;
			}
		}
		return res;
	}

	private String bfs(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		System.out.println("left:" + (left + 1) + "|right:" + (right)); // left-- and right++ already executed in the while loop
		String res = s.substring(left + 1, right);
		return res;
	}

	public String longestPalindromeTemp(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}
		
		
		String maxLenStr = s.substring(0, 1);
		for(int i=0; i<s.length(); i++) {
			String oddPal = bfs(s, i-1, i+1);
			String evenPal = bfs(s, i, i+1);
			
			String curMaxStr = oddPal.length() > evenPal.length() ? oddPal:evenPal; 
			if (curMaxStr.length() > maxLenStr.length()) {
				maxLenStr = curMaxStr;
			}
			
		}
		
		
		return maxLenStr;
	}
	
	private String bfs(String s, int start, int end) {
		int len = s.length();
		
		while(start >=0 && end < len) {
			if(s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
			} else {
				break;
			}
		}
		
		return s.substring(start + 1, end);
	}

	
	
	
	
	

	// Driver code
	public static void main(String args[]) {
		LC0005longestPalindrome test = new LC0005longestPalindrome();

		String str = "babad";

		String longestPali = test.longestPalindromeTemp(str);

		System.out.println(longestPali);
	}
}
