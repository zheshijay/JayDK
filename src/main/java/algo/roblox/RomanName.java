package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanName {

	
	
	public int romanToInt(String s) {
		int sum = 0;
		int pre = getValue(s.charAt(0));
		for(int i=1; i< s.length(); i++) {
			
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
	
	public void sortRomaNames(String[] kings) {
		List<String[]> list = new ArrayList<>();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < kings.length; i++) {
			int spaceIndex = kings[i].lastIndexOf(' ');
			int num = romanToInt(kings[i].substring(spaceIndex + 1));
			String king = kings[i].substring(0, spaceIndex);
			list.add(new String[] { Integer.toString(i), Integer.toString(num), king });
		}

		// first sort according to name
		// then according to value
		Collections.sort(list, (a, b) -> {
			return a[2].equals(b[2]) ? Integer.valueOf(a[1]) - Integer.valueOf(b[1]) : a[2].compareTo(b[2]);
		});
//		for (String[] arr : list) {
//			res.add(kings[Integer.valueOf(arr[0])]);
//		}
//
//		for (String s : res) {
//			System.out.println(s);
//		}
		System.out.println("list:" + Arrays.deepToString(list.toArray()));


	}
	
	public void sortRomaNames2(String[] kings) {
		List<String[]> list = new ArrayList<>();
	
		for (int i = 0; i < kings.length; i++) {
			String[] nameNum = kings[i].split(" ");
			
//			int spaceIndex = kings[i].lastIndexOf(' ');
			int num = romanToInt(nameNum[1]);
			String name = nameNum[0];
			
//			String name = kings[i].substring(0, spaceIndex);
			list.add(new String[] { name, Integer.toString(num) });
		}

		// first sort according to name
		// then according to value
		Collections.sort(list, (a, b) -> {
			return a[0].equals(b[0]) ? Integer.valueOf(a[1]) - Integer.valueOf(b[1]) : a[0].compareTo(b[0]);
			});
		
		System.out.println("list:" + Arrays.deepToString(list.toArray()));

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

	public static void main(String[] args) {
		RomanName test = new RomanName();
		String[] kings = { "David X", "Mary XIII", "Mary XV", "Mary XX", "Steven XVI", "Steven XL" };
		test.sortRomaNames(kings);
		
		test.sortRomaNames2(kings);

	}
}
