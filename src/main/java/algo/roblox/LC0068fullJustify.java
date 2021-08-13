package algo.roblox;

import java.util.ArrayList;
import java.util.List;

public class LC0068fullJustify {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int len = words.length;
		// index of words
		int left = 0;
		
		while (left < len) {
			int curLineTotalChars = words[left].length();
			int right = left + 1;

			// build one line
			while (right < len) {
				// cur total chars + next wrod's lenth + 1 space
				// exit if total number of char exceeds maxWidth
				if (curLineTotalChars + words[right].length() + 1 > maxWidth) break;

				// update curLineTotalChars
				curLineTotalChars += 1 + words[right].length();
				right++;
			}
			
			
			int gaps = right - left - 1;
			System.out.println("right:" + right);

		
			StringBuilder sb = new StringBuilder();

			
			// right == len: 最后一个单词
			// gaps == 0: 这一行只有一个单词
			// last line or just one word
			if (right == len || gaps == 0) {
				for (int i = left; i < right; i++) {
					sb.append(words[i]);
					sb.append(' ');
				}

				// remove last space
				sb.deleteCharAt(sb.length() - 1);
				
				// add spaces
				while (sb.length() < maxWidth) {
					sb.append(' ');
				}

			} else {
				
				// average spaces for each gap
				int spaces = (maxWidth - curLineTotalChars) / gaps;

				// rest of the spaces
				int rest = (maxWidth - curLineTotalChars) % gaps;
				
				// 因为不是最后一行，所以最后一个肯定没有空格，可以直接加上 words[right - 1]，所以这里用 i < right -1
				for (int i = left; i < right - 1; i++) {
					sb.append(words[i]);
					sb.append(' ');

					for (int j = 0; j < spaces + (i - left < rest ? 1 : 0); j++) {
						sb.append(' ');
					}
					
				}
				// 加上最后一个单词
				sb.append(words[right - 1]);

				
			}

			res.add(sb.toString());
			left = right;
		}

		return res;
	}
	
	public static void main(String[] args) {
		String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		
		LC0068fullJustify test = new LC0068fullJustify();
		List<String> res = test.fullJustify(words, maxWidth);
		System.out.println("res:" + res);
	}

}
