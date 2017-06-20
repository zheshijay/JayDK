package leetcode;


import java.util.ArrayList;
import java.util.List;

public class ListUnionAndIntersection {

	static List<Integer> unionLists(List<Integer>a, List<Integer>b){
		List<Integer> c = new ArrayList<Integer>();
		int i =0;
		int j =0;
		int lena = a.size();
		int lenb = b.size();
		while(i< lena && j< lenb) {
			if(a.get(i) <= b.get(j)){
				c.add(a.get(i));
				i++;
			}
			else {
				c.add(a.get(i));
				j++;
			}
		}
		// Now either a is done or b is done
		if(i == lena){
			for (int k=j; j< lenb; j++){
			// copy all b rows to c
				c.add(b.get(k));	
			}
		}
		if(j == lena){
			for (int k=i; j< lena; j++){
			// copy all a rows to c
				c.add(a.get(k));	
			}
		}
		return c;
	}


	static List<Integer> intersectList(List<Integer> a, List<Integer> b){
		List<Integer> c = new ArrayList<Integer>();
		int i =0;
		int j =0;
		int lena =a.size();
		int lenb =b.size();
		while (i < lena && j< lenb){
			//store common elements in c
			if(a.get(i) == b.get(j)){
				c.add(a.get(i));
				i++;
				j++;
			}
		}
		return c;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		List<Integer> res = unionLists(list1, list2);
		
		for(Integer each: res){
			System.out.print(each + " ");
		}
		
		
		

	}

}
