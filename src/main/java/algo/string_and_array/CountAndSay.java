package algo.string_and_array;

/*
 * 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

	public String countAndSay(int n) {
 * 
 */
public class CountAndSay {

	public String countAndSay2(int n) {
		System.out.println("runs...");
		
		String ans = "1"; // 记录答案,因为不用频繁增删，所以还是用string效率高
		for (int i = 2; i <= n; i++) { // 因为答案记录了一次答案，所以只要在循环n-1次就行
			StringBuilder t = new StringBuilder(); // 用StringBuilder是因为频繁增删效率高
			int cnt = 0; // 记录该数出现了多少次
			for (int j = 0; j < ans.length(); j++) { // 遍历答案字符串
				cnt++;
				if (j == ans.length() - 1 || ans.charAt(j) != ans.charAt(j + 1)) { // 如果是最后一个字符或者当前字符和后一个字符不相等
					t.append(cnt); // 记录该字符出现次数
					t.append(ans.charAt(j)); // 再加入该字符
					cnt = 0;
				}
			}
			ans = t.toString();
		}
		return ans;
	}
	

	public static void main(String args[]) {
		CountAndSay test = new CountAndSay();

		String res = test.countAndSay(111);
		System.out.println(res);

	}

}
