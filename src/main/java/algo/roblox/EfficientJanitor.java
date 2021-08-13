package algo.roblox;

import java.util.Arrays;

public class EfficientJanitor {
	/*
	 * 思路： 
	 * 首先对垃圾袋按照重量排序，如果最重的不可以和最轻的放在一起，那么就单独把重的放到一个袋子里
	 */
	 public int totalTrips(float[] weights) {
		 Arrays.sort(weights);
		 
		 int trips = 0;
		 int left = 0, right = weights.length - 1;
		 while (left <= right) {
			 trips += 1;
			 if (weights[left] + weights[right] <= 3L) {
				 left++;
				 right--;
			 } else {
				 right--;
			 }
		 }
		 return trips;
	 }
	 
	
	 public static void main(String[] args) {
		 EfficientJanitor test = new EfficientJanitor();
		 float[] weights = new float[] {1.99f, 1.01f, 2.5f, 1.5f, 1.01f};
		 int res = test.totalTrips(weights);
		
		 
		 System.out.println(res);
	}
}


