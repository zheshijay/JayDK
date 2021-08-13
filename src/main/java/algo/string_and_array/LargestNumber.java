package algo.string_and_array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		
		for(int i=0; i<nums.length; i++){
			arr[i]=String.valueOf(nums[i]);
		}

		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String a, String b){
				return (b+a).compareTo(a+b);
			}
		});
		System.out.println(Arrays.toString(arr));
		
		StringBuilder sb = new StringBuilder();
		for(String s: arr){
			sb.append(s);
		}

		//remote leading zero
//		while(sb.charAt(0)=='0'&&sb.length()>1)
//			sb.deleteCharAt(0);

		return sb.toString();
	}

	/*
	 * 
输入：nums = [3,30,34,5,9]
输出："9534330"
	 */
	public static void main(String[] args){
		LargestNumber test = new LargestNumber();
		
//		int[] a = new int[]{3, 30, 34, 5, 9};
		int[] a = new int[]{30, 5, 3, 34, 9};
		
		System.out.println(test.largestNumber(a));
		
	}
	
	
}
