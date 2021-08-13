package algo.mianshibaodian;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q1618PatternMatching {
	 public boolean patternMatching(String pattern, String value) {
	        // 如果pattern不含任意字符，则返回为value是否为空
	        if (pattern == null || pattern.length() == 0) {
	            return value == null || value.length() == 0;
	        }

	        int cntA = 0, cntB = 0;
	        // 其实a和b是可以互相替换的，因此为了下面方便起见，将首次出现的字母当作a
	        char first = pattern.charAt(0);
	        for (int i = 0 ; i < pattern.length() ; i ++) {
	            if (pattern.charAt(i) == first) {
	                cntA ++;
	            } else {
	                cntB ++;
	            }
	        }

	        // 如果a和b有一个是只出现一次，那么一定可以正确表示（另一个表示为空串即可）
	        if (cntA != cntB && (cntA == 1 || cntB == 1)) {
	            return true;
	        }

	        int aPresentLength = 0, bPresentLength;
	        while (aPresentLength * cntA <= value.length()) {
	            // 除去所有a表示字符串后，剩余的字符串长度
	            int left = value.length() - aPresentLength * cntA;

	            // 如果cntB是0 或者 剩余的字符串是cntB的倍数，则才有可能组成value
	            if ((cntB == 0 && left == 0) || (cntB != 0 && left % cntB == 0)) {
	                // 计算b表示的字符串长度
	                bPresentLength = cntB == 0 ? 0 : left / cntB;

	                // 计算a表示的字符串
	                String aPresent = value.substring(0, aPresentLength), bPresent = "";

	                int index = 1;
	                // 找到b首次出现的位置，得到b代表的字符串
	                while (index < pattern.length() && pattern.charAt(index) == first) {
	                    ++ index;
	                }
	                // 避免越界
	                if (index < pattern.length()) {
	                    // 计算b表示的字符串
	                    int from = aPresentLength * index, to = from + bPresentLength;
	                    bPresent = value.substring(from, to);
	                }

	                // 如果此时a和b表示的字符串相等，则不符合题意
	                if (aPresent.equals(bPresent)) {
	                    ++ aPresentLength;
	                    continue;
	                }

	                StringBuilder sb = new StringBuilder();
	                for (int i = 0 ; i < pattern.length() ; i ++) {
	                    if (pattern.charAt(i) == first) {
	                        sb.append(aPresent);
	                    } else {
	                        sb.append(bPresent);
	                    }
	                }
	                if (sb.toString().equals(value)) {
	                    return true;
	                }
	            }
	            // 这里如果cntA为0的话，则在上面的if语句里已经计算过了，如果一味增加
	            // a的长度，那么会陷入死循环
	            if (cntA == 0) {
	                break;
	            }

	            aPresentLength ++;
	        }
	        return false;
	    }
	 
	 public static void main(String[] args) {
		String pattern = "abba";
		String value = "dogcatcatdog";
		Q1618PatternMatching test = new Q1618PatternMatching();
		System.out.println(test.patternMatching(pattern, value));
	}
}
