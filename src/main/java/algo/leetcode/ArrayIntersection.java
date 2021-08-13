package algo.leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArrayIntersection {

	//Get unique union set
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<Integer>();

		for(int i=0;i<nums1.length;i++)
			set.add(nums1[i]); 
		
		System.out.println("set is: " + set);

		List<Integer> resultList = new ArrayList<Integer>();

		for (int i=0;i<nums2.length;i++)
			if(set.contains(nums2[i])){
				resultList.add(nums2[i]);
				
				set.remove(nums2[i]);
				
				System.out.println("set2: " + set);
			}

		
		int result[] = new int[resultList.size()];
		for(int i=0;i<resultList.size();i++)
			result[i]=resultList.get(i);

		return result;

	}


	//{1,2,3,4}
	//{3,4,5,6}

	//Get unique union set
	public int[] intersection2(int[] nums1, int[] nums2) {
		List<Integer> resultList = new ArrayList<Integer>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int index1 = 0;
		int index2 = 0;

		while((index1 < nums1.length) && (index2 < nums2.length)){
			System.out.println("compare " + index1 + " and " + index2);
			
			if(nums1[index1] == nums2[index2]){
				resultList.add(nums1[index1]);
				
				if((index1 < nums1.length))	index1++;
				if((index2 < nums2.length))	index2++;
			}else			
			if(nums1[index1] < nums2[index2]) index1++;
			else
			if(nums1[index1] > nums2[index2]) index2++;	
		}

		int[] result = new int[resultList.size()];
		for(int i=0; i<resultList.size(); i ++){
			result[i] = resultList.get(i);
		}

		return result;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayIntersection ai = new ArrayIntersection();
		
		int[] nums1 = {1,2,3,4,78};
		int[] nums2 = {3,3,4,5,6,89,78};
		
		int[] result = ai.intersection(nums1, nums2);
		
		for(int each: result){
			System.out.print(each + "-");
		}
		

	}

}
