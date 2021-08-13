package algo.roblox;

public class LC0443compressText {


	public int compress(char[] chars) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < chars.length) {
			int count = 1;
			while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
				i++;
				count++;
			}
			if (count == 1) {
				sb.append(chars[i]);
			} else if (count > 1) {
				sb.append(chars[i]);
				sb.append(count);
			}
			i++;
		}
		
		System.out.println("sb:" + sb.toString());
		char[] help = sb.toString().toCharArray();
		for (int j = 0; j < help.length; j++) {
			chars[j] = help[j];
		}
		return help.length;
	}


	public static void main(String[] args) {
		LC0443compressText test = new LC0443compressText();

		char[] chars = new char[] { 'a', 'a', 'b', 'b', 'b' };
//		char[] chars = new char[] { 'a', 'b', 'b', 'b' };
		int res = test.compress(chars);
		System.out.println("res:" + res);

	}
}
