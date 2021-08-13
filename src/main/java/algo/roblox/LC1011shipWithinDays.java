package algo.roblox;

import java.util.Arrays;

public class LC1011shipWithinDays {
	 public int shipWithinDays(int[] weights, int days) {
		 
		 int left = 0, right = Integer.MAX_VALUE;
		 while(left < right) {
			 int mid = left + (right - left) / 2;
			 if (canShip(weights, days, mid)) {
				 right = mid;
			 } else {
				 left = mid + 1;
			 }
		 }
		 
		 return left;
	 }
	 
	 
	 private boolean canShip(int[] weights, int days, int cap) {
		int avCap = cap;
		
		for(int i=0; i<weights.length; i++) {
			if (weights[i] > cap) {
				return false;
			}

			if (avCap < weights[i]) {
				// not enough space, call it a day, reset the avCap to Max cap
				days--;
				avCap = cap;
			}
			avCap -= weights[i];
		}
		 
		return days > 0;
	}


	public static void main(String[] args) {
		LC1011shipWithinDays test = new LC1011shipWithinDays();
		int[] weights = new int[] {3,2,2,4,1,4};
		 int days = 3;
		 
		 
		 int res = test.shipWithinDays(weights, days);
		 
		 System.out.println("res:" + res);
		 
	}
	
}


