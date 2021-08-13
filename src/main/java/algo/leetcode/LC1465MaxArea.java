package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC1465MaxArea {
	
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		 long horizonMax = 0, verticalMax = 0;
		    int mod = 1000000007;
		    Arrays.sort(horizontalCuts);
		    Arrays.sort(verticalCuts);
		    
		    // 补充验证边界切割位置
		    horizonMax = Math.max(horizonMax, horizontalCuts[0] - 0);
		    horizonMax = Math.max(horizonMax, h - horizontalCuts[horizontalCuts.length - 1]);
		    
		    // 补充验证边界切割位置
		    verticalMax = Math.max(verticalMax, verticalCuts[0] - 0);
		    verticalMax = Math.max(verticalMax, w - verticalCuts[verticalCuts.length - 1]);
		        
		    for (int i = 1; i < horizontalCuts.length; i++) {
		        horizonMax = Math.max(horizonMax, horizontalCuts[i] - horizontalCuts[i - 1]);
		    }
		   
		        
		    for (int i = 1; i < verticalCuts.length; i++) {
		        verticalMax = Math.max(verticalMax, verticalCuts[i] - verticalCuts[i - 1]);
		    }
		  
		        
		    return (int) ((horizonMax * verticalMax) % mod);
	}
	
	public int maxArea2(int h, int w, int[] hCuts, int[] vCuts) {
		int hMax = 0, vMax = 0;
		 int mod = 1000000007;
		Arrays.sort(hCuts);
		Arrays.sort(vCuts);
		
//		hMax = Math.max(hMax, hCuts[0]);
//		hMax = Math.max(hMax, h - hCuts[hCuts.length - 1]);
		hMax = Math.max(hCuts[0], h - hCuts[hCuts.length - 1]);
		
//		vMax = Math.max(vMax, vCuts[0]);
//		vMax = Math.max(vMax, v - vCuts[vCuts.length - 1]);
		vMax = Math.max(vCuts[0], w - vCuts[vCuts.length - 1]);
		
		for(int i = 1; i < hCuts.length; i++) {
			hMax = Math.max(hMax, hCuts[i] - hCuts[i-1]);
		}
		
		for(int i = 1; i < vCuts.length; i++) {
			vMax = Math.max(vMax, vCuts[i] - vCuts[i-1]);
		}
		
		 return (int) ((hMax * vMax) % (mod));
		
	}
	
	
	public static void main(String[] args) {
		int h = 5, w = 4;
		int[] horizontalCuts = new int[] {3,1};
		int[] verticalCuts = new int[] {1};
		
		LC1465MaxArea test = new LC1465MaxArea();
		int res = test.maxArea(h, w, horizontalCuts, verticalCuts);
		System.out.println("resLC146:" + res);
		
	}
}
