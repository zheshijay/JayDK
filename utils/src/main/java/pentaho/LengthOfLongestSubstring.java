package pentaho;

import java.util.HashMap;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if(s==null)
			return 0;
		char[] arr = s.toCharArray();
		int pre = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}

		return Math.max(pre, map.size());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
