package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0013romanToInt {
	public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
	public int romanToInt2(String s) {
		int sum = 0;
		int pre = getValue(s.charAt(0));
		for(int i=1; i< s.length(); i++) {
			System.out.println(sum);
			int cur = getValue(s.charAt(i));
			if (pre < cur) {
				sum -= pre;
			} else {
				sum +=pre;
			}
			pre = cur;
		}
		
		sum += pre;
		return sum;
		
	}
	
	private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


	// Driver code
	public static void main(String args[]) {
		LC0013romanToInt test = new LC0013romanToInt();
		String s = "IV";
//		int res = test.romanToInt(s);
//		System.out.println(res);
		
		int res2 = test.romanToInt2(s);
		System.out.println(res2);
	}
}
