package algo.string_and_array;

import java.util.Arrays;

/*
 * 
 * Can be solved use 2 pointers
 * 
 * like str.indexOf
 *
 * step1:
 * --------
 * --
 * 
 * step2:
 * --------
 *   --
 *  
 *  step3:
 * -------- 
 *     --
 */   
public class StrStr {

	
		// 暴力
	public int strStr(String haystack, String needle) {
	    int L = needle.length(), n = haystack.length();

	    for (int start = 0; start < n - L + 1; ++start) {
	      if (haystack.substring(start, start + L).equals(needle)) {
	        return start;
	      }
	    }
	    return -1;
	  }

	// 暴力 2
	public static int strStr2(String srouce, String target) {
		if (target == null || srouce == null)
			return -1;
		if (target.length() > srouce.length())
			return -1;

		int i=0, j=0;
		for( i=0; i< srouce.length(); i++){
 
			//check the k substring from index i, compare with target
			for(j=0; j< target.length(); j++){
				
				System.out.println(" compare " + (srouce.charAt(i+j)) +  " and " + (target.charAt(j)) );
				if(srouce.charAt(i+j) != target.charAt(j) ){
					break;
				}
			}
			if(j == target.length()) return i;	
		}
		return -1;
	}

	// 暴力 3
	 public int strStr3(String haystack, String needle) {
		    int L = needle.length(), n = haystack.length();
		    if (L == 0) return 0;

		    int pn = 0;
		    while (pn < n - L + 1) {
		      // find the position of the first needle character
		      // in the haystack string
		      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

		      // compute the max match string
		      int currLen = 0, pL = 0;
		      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
		        ++pn;
		        ++pL;
		        ++currLen;
		      }

		      // if the whole needle string is found,
		      // return its start position
		      if (currLen == L) return pn - L;

		      // otherwise, backtrack
		      pn = pn - currLen + 1;
		      System.out.println("back track to pn:" + pn);
		    }
		    return -1;
		  }

	 // KMP
	 public int strStrKmp(String s, String p) {
		 	System.out.println("s:" + s + "|p:" + p);
	        int sLen = s.length(), pLen = p.length();
	        if (pLen == 0) {
	            return 0;
	        }

	        // 构造前缀表
	        int[] pi = new int[pLen];
	        for (int i = 1, j = 0; i < pLen; i++) {
	            while (j > 0 && p.charAt(i) != p.charAt(j)) {
	                j = pi[j - 1];
	            }
	            if (p.charAt(i) == p.charAt(j)) {
	                j++;
	            }
	            pi[i] = j;
	        }

	        System.out.println("pi:" + Arrays.toString(pi));
	        
	        for (int i = 0, j = 0; i < sLen; i++) {
	        	// 如果不匹配，移动到前缀表里面的下标
	            while (j > 0 && s.charAt(i) != p.charAt(j)) {
	                j = pi[j - 1];
	            }
	            // 如果匹配，继续移动下标 (i 和 j 一起向后继续比较)
	            if (s.charAt(i) == p.charAt(j)) {
	                j++;
	            }
	            
	            // 如果找到一个全匹配，就返回起始下标
	            if (j == pLen) {
	                return i - pLen + 1;
	            }
	        }
	        return -1;
	    }
	 
	 

	public static void main(String args[]){

		StrStr test = new StrStr();

//		System.out.println(test.strStr3("abcde", "cde"));
		System.out.println(test.strStrKmp("aaaaab", "aab"));

	}
}
