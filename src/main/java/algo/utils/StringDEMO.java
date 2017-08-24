package algo.utils;

import java.util.ArrayList;
import java.util.List;

public class StringDEMO {
	
	public void indexOfDEMO(){
		String source = "abcdcdefg";
		String target = "cde";
		
		System.out.println(source.indexOf(target));
		
	}
	
	public void subStringDEMO(){
		String source = "aba";
	
		
		System.out.println(source.substring(1,3));
		
	}
	
	
	public void test(){
		 List<List<Integer>> res = new ArrayList<>();
		 
		 List<Integer> tmp1 = new ArrayList<>();
		 tmp1.add(1);
		 
		 List<Integer> tmp2 = new ArrayList<>();
		 tmp2.add(2); 
		 
//		 res.add(new ArrayList<Integer>(tmp));
		 res.add(tmp1);
		 res.add(tmp2);
		 
		 
		 System.out.println(res);	 
	}
	
	public static void main(String[] args){
		StringDEMO test = new StringDEMO();
		test.subStringDEMO();
	}
}
