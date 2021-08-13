package algo.other;

import java.util.ArrayList;
import java.util.List;

public class CompressAndDecomparessString {
	String getCompressedString(String s) {
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		char c = chars[0];
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (c == chars[i]) {
				count++;
			} else {
				sb.append(c).append(count);
				c = chars[i];
				count = 1;
			}
		}
		
		sb.append(c).append(count);

		return sb.toString();
	}

	public static void main(String[] args) {
		CompressAndDecomparessString test = new CompressAndDecomparessString();
//		String s = "AAABBCCCE";
		String s = "AAABBCC";
		System.out.println(test.getCompressedString(s));
	}
}
