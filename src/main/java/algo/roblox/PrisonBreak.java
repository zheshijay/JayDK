package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algo.leetcode.LC1465MaxArea;

public class PrisonBreak {
	public int prisonBreak(int h, int w, List<Integer> hCuts, List<Integer> vCuts) {
		
		int mod = 1000000007;
		
		Collections.sort(hCuts);
		Collections.sort(vCuts);
		
		int maxH = Math.max(hCuts.get(0), h - hCuts.get(hCuts.size()-1));
		int maxV = Math.max(vCuts.get(0), w - vCuts.get(vCuts.size()-1)); 
		
		
		for(int i=1; i< hCuts.size(); i++) {
			maxH = Math.max(maxH, hCuts.get(i) - hCuts.get(i-1));
		}
		
		for(int i=1; i< vCuts.size(); i++) {
			maxV = Math.max(maxV, vCuts.get(i) - vCuts.get(i-1));
		}

		 return (int) ((maxH * maxV) % mod);
		
	}
	
	public static void main(String[] args) {

		List<Integer> hCuts = new ArrayList<>();
		List<Integer> vCuts = new ArrayList<>();
		
		hCuts.addAll(Arrays.asList(3,1));
		vCuts.addAll(Arrays.asList(1));
		
		
		int h = 5, w = 4;

		
		PrisonBreak test = new PrisonBreak();
		int res = test.prisonBreak(h, w, hCuts, vCuts);
		System.out.println("res:" + res);
		
	}
	
}


