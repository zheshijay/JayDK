package algo.combination_and_permutation.backlog;

import java.util.Arrays;

/**
 * 
 * a={1,2,3}   when n=2, all combination is 12,13,23. 
 * 
 * @author ZShi
 *
 */
public class CombinationWithoutDup {
	public void combine(int[] a, int n) {  
		System.out.println("calculate combination of : " + Arrays.toString(a));
		if(null == a || a.length == 0 || n <= 0 || n > a.length)  
			return;  

		int[] b = new int[n];//辅助空间，保存待输出组合数  
		getCombination(a, n , 0, b, 0);  
	}  

	private void getCombination(int[] a, int n, int begin, int[] b, int index) { 
		System.out.println("-------------------------------------");
		System.out.println("|s1: a is: " + Arrays.toString(a));
		System.out.println("|s2: b is: " + Arrays.toString(b));
		System.out.println("| n: " + n + " begin:" + begin + " index: " + index);
		

		if(n == 0){//如果够n个数了，输出b数组  
//			for(int i = 0; i < index; i++){  
//				System.out.print(b[i] + "-");  
//			}  
//			System.out.println(); 
			
			System.out.println(" exist ");
			return;  
		} 
		
		for(int i = begin; i < a.length; i++){  
			b[index] = a[i];  
			getCombination(a, n-1, i+1, b, index+1);  
		}  

	}  

	public static void main(String[] args){  

		CombinationWithoutDup robot = new CombinationWithoutDup();  

		int[] a = {1,2,3,4};  
		int n = 2;  
		robot.combine(a,n);  

	}  
}
