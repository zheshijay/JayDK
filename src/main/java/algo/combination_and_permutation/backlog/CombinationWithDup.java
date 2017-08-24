package algo.combination_and_permutation.backlog;

import java.util.Arrays;

/**
 * 
 *  * a={1,2,3}   when n=2, all combination is 11,12,13,22,23,33. 
 * 
 * @author ZShi
 *
 */
public class CombinationWithDup {   

	public void combine(int[] a, int n) {  

		if(null == a || a.length == 0 || n <= 0 || n > a.length)  
			return;  

		Arrays.sort(a);  
		int[] b = new int[n];//辅助空间，保存待输出组合数  
		getCombination(a, n , 0, b, 0);  
	}  

	private void getCombination(int[] a, int n, int begin, int[] b, int index) {  

		if(n == 0){//如果够n个数了，输出b数组  
			for(int i = 0; i < index; i++){  
				System.out.print(b[i] + " ");  
			}  
			System.out.println();  
			return;  
		}  

		for(int i = 0; i < a.length; i++){  

			if(index == 0 || a[i] >= b[index-1]){  
				b[index] = a[i];  
				getCombination(a, n-1, i+1, b, index+1);  
			}  
		}  

	}  

	public static void main(String[] args){  

		CombinationWithDup robot = new CombinationWithDup();  

//		int[] a = {1,2,3,4};  
//		int n = 3;  
		
		int[] a = {1,2,3};  
		int n = 2;  
		robot.combine(a,n);  

	}  
}
