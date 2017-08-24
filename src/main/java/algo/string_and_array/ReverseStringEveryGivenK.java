package algo.string_and_array;

import java.util.Arrays;

/*
 * 
 * 
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:

    The string consists of lower English letters only.
    Length of the given string and k will in the range [1, 10000]

 * 
 */
public class ReverseStringEveryGivenK {


	/*
	 * Reverse every K diff
	 * 
Input:  [a, b, c, d, e, f, g]
Output: [b, a, d, c, f, e, g]
	 * 
	 * 
	 */
	public String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		int start = 0;
		while(start < len) {

			System.out.println(" start is:  " + start );
			int j = Math.min(start + k - 1, len - 1);

			System.out.println(" swap " + start + " and " + j);
			swap1(arr, start, j);
			start += 2 * k;
		}
		return String.valueOf(arr);
	}


	public String reverseStr1(String s, int k) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		int startIndex = 0;
		int endIndex = startIndex + k -1;


		while(endIndex < len) {

			System.out.println(" start is:  " + startIndex );
			//			int j = Math.min(start + k - 1, len - 1);

			System.out.println(" swap- start " + startIndex + " end " + (endIndex) );

			swap2(arr, startIndex, endIndex);
			startIndex += 2 * k;
			endIndex = startIndex + k -1;
		}
		return String.valueOf(arr);
	}


	private void swap1(char[] arr, int l, int r) {
		while (l < r) {
			char temp = arr[l];
			arr[l++] = arr[r];
			arr[r--] = temp;
		}
	}


	//---------------


	/*
	 * Reverse every K group
	 * 
Input:  [a, b, c, d, e, f, g]
Output: [b, a, d, c, f, e, g]
	 * 
	 * 
	 */
	public String reverseStringEveryK(String str, int k){

		char[] chars = str.toCharArray();

		int len = str.length();

		int startIndex = 0;
		int endIndex = startIndex + k -1;

		while(endIndex < len){
			System.out.println(" swap- start " + startIndex + " end " + (endIndex) );

			swap2(chars, startIndex, endIndex);

			System.out.println(" after swap: " + Arrays.toString(chars));
			System.out.println("----------> next startIndex : " + startIndex);
			
			startIndex = startIndex + k;
			endIndex = startIndex + k -1;
		}

		return Arrays.toString(chars);
	}

	public void swap2(char[] chars, int startIndex, int endIndex){

		while(startIndex < endIndex){
			char tmp = chars[startIndex];
			chars[startIndex] = chars[endIndex];
			chars[endIndex] = tmp;
			startIndex++;
			endIndex--;
		}
	}

	/*
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
	 * 
	 */


	public static void main(String args[]){
		ReverseStringEveryGivenK test = new ReverseStringEveryGivenK();

		String str = "abcdefg";
		String reversed = test.reverseStringEveryK(str ,2);

		System.out.println("reversed: "+ reversed);


	}
}
