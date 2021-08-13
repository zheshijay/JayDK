package algo.jianzhioffer;

public class Q005ReplaceSpace {
	/*
	 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为 "We Are Happy". 则经过替换之后的字符串为
	 * "We%20Are%20Happy"。
	 */

	public String replaceSpace(String str) {
		return str.replace(" ", "%20");
	}

	public String replaceSpace2(String str) {

		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(str);

		int oldLength = strBuffer.length();
		

		for (int i = 0; i < str.length(); i++) {
			if (strBuffer.charAt(i) == ' ') {
				strBuffer.append("  ");
			}
		}
		int newLength = strBuffer.length();

		int p1 = oldLength - 1;
		int p2 = newLength - 1;
		
		while (p1 != p2) {
			System.out.println("p1:" + p1 + " - " + "p2:" + p2);
			
			if (strBuffer.charAt(p1) == ' ') {
				p1--;
				strBuffer.setCharAt(p2--, '0');
				strBuffer.setCharAt(p2--, '2');
				strBuffer.setCharAt(p2--, '%');
			
			} else {
				strBuffer.setCharAt(p2--, strBuffer.charAt(p1--));
			}
		}
		
		return strBuffer.toString();
	}

	public static void main(String[] args) {
		Q005ReplaceSpace test = new Q005ReplaceSpace();
		System.out.println(test.replaceSpace2("We Are Happy"));
//		System.out.println(test.replaceSpace2("a a b"));
	}
}
