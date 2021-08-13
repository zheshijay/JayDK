package algo.leetcode;


public class FindRange {

	public static int[] findRange(int[] a, int num) { 
		if(a==null){ 
			System.out.println("Please provide the valid array to find the range index!"); 
		} 
		int firstIndex = -1; 
		int lastIndex = -1; 
		int[] rangeArray = new int[2]; 
		boolean flag = true; 
		for (int i = 0; i < a.length; i++) { 
			if (a[i] == num && flag) { 
				firstIndex = i; 
				lastIndex = i; 
				flag = false; 
			} else if (a[i] == num) { 
				lastIndex = i; 
			} 
		} 
		rangeArray[0] = firstIndex; 
		rangeArray[1] = lastIndex; 
		return rangeArray; 
	} 

	public static void main(String[] args) { 
		int result[] = new int[2]; 
		result = findRange(new int[]{0, 2, 3, 3, 3, 10, 10}, 3); 
		for (int i = 0; i < result.length; i++) { 
			System.out.print(result[i] + " "); 
		} 
	} 

}
