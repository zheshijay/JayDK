package algo.string_and_array;

/**
 * 
 * Input : {"geeksforgeeks", "geeks", "geek", "geezer"} Output : "gee"
 * 
 * Input : {"apple", "ape", "april"} Output : "ap"
 */
public class LongestCommonPrefix {

	/*
	 * Solu 1
	 */
	public String findLongestPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

	
	/*
	 * Solu 2
	 */
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

	public static void main(String args[]) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] strs = new String[] { "geeksforgeeks", "geeks", "geek", "geezer" };
		System.out.println(test.longestCommonPrefix(strs));
	}
}
