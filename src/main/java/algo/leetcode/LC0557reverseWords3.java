package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"


作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/c8su7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LC0557reverseWords3 {
	public String reverseWords(String s) {
		char[] chArray = s.toCharArray();
		    int nextWordStart = 0;
		    while (nextWordStart < chArray.length) {
		        // 找到每个单词的首尾
		        int start = nextWordStart;
		        int end = start;
		        while (end < chArray.length && chArray[end] != ' ') {
		            end++;
		        }
		        end--;

		        int currentWordEnd = end;
		        // 翻转单词
		        while (start < end) {
		            char temp = chArray[start];
		            chArray[start] = chArray[end];
		            chArray[end] = temp;
		            start++;
		            end--;
		        }

		        nextWordStart = currentWordEnd + 2;
		    }

		    return new String(chArray);
		    }
}
