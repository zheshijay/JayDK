package algo.combination_and_permutation.backlog;

import java.util.Arrays;

public class PermutationDEMO {
	
	
	/*
	 * Step 1: Scan first ascending order pair from back side, save index to i
	 * Step 2: Scan first element greater than a[i] from back side, save index to j
	 * Step 3: Swap values between a[i] and a[j], so that we get the next number in ascending order
	 * Step 4: Reverse the rest of the values from i+1 to the end, so that we get the minimum number in current group (same prefix  E.g. 1243, 1234 prefix is 12XX )
	 * Step5:  exist scan when (i==0 && a[1] > a-[0]), it means already reaches the biggest number
	 * 
	 */
	
	public void runNoRecursionOfPermutation(int[] a){  

		Arrays.sort(a);//对数组排序
		
		while(true){  	
			System.out.println("------------------> print:" + Arrays.toString(a));
			
			int i;
			int j;

			for(i = a.length-2; i >= 0; i--){  
				System.out.println(" * i is:" + i);
				if(a[i] < a[i+1])//s1: scan from back side to front, find the index which has condition (a[i] < a[i+1])
					break;  
				else if(i == 0) //exist when reaches the biggest number in ascending order
				{
					System.out.println(" exist ");
					return;  
				}
					
			}  
			
			System.out.println("|s1: Find i:" + i);
			
			for(j = a.length-1; j > i; j--){  
				if(a[j] > a[i])//s2: scan from back side to front, used to find the first digit which is greater than a[i]
					break;  
			}  
			System.out.println("|s2: Find j:" + j);
			System.out.println("|s3: swap index " + i + " - " + j);
			swap(a, i, j); //s3: swap i and j
			
			System.out.println("|s4: after swap" + Arrays.toString(a));
			System.out.println("|s5: reverse index " + (i+1) + " - " +  (a.length-1));
			reverse(a, i+1, a.length-1);//s4: reverse elements to make in in ascending order ( minimum value for this group )
			
			System.out.println("|s6: after reverse" + Arrays.toString(a));
			
		}  
	}  
	public void swap(int[] a, int i, int j) {  
		int temp = a[i];  
		a[i] = a[j];  
		a[j] = temp;  
	}  
	public void reverse(int[] a, int i, int j){  
		while(i < j) {
			System.out.println("  |s5.1 reverse value " + a[i] + " - " +  a[j]);
			swap(a, i++, j--);  
		}	
	}  

	public static void main(String[] args) {  

		PermutationDEMO robot = new PermutationDEMO();  
		int[] a = {1,2,3,4};  
		robot.runNoRecursionOfPermutation(a);  

	}
}
