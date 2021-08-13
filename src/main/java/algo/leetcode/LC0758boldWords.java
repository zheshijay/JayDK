package algo.leetcode;

public class LC0758boldWords {

	public String boldWords(String[] words, String S) {
		boolean[] isBold = new boolean[S.length()];
		
		
		// 用indexOf我们可以找到word在S中出现的所有地方, 标记哪些区域需要加粗
		for (String word : words) {
			int n = S.indexOf(word, 0);
			while (n != -1) {
				for (int i = n; i < n + word.length(); i++)
					isBold[i] = true;
				n = S.indexOf(word, n + 1);
			}
		}

		// 加粗
		StringBuilder sb = new StringBuilder();
		if (isBold[0])
			sb.append("<b>");
		for (int i = 0; i < isBold.length; i++) {
			sb.append(S.charAt(i));
			if (i == isBold.length - 1) {
				if (isBold[i])
					sb.append("</b>");
				break;
			}
			if (isBold[i] && !isBold[i + 1])
				sb.append("</b>");
			if (!isBold[i] && isBold[i + 1])
				sb.append("<b>");
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		String[] words = new String[] {"ab", "bc"};
		String S = "aabcd";
		
		LC0758boldWords test = new LC0758boldWords();
		String res = test.boldWords(words, S);
		System.out.println("res:" + res);
	}
}
