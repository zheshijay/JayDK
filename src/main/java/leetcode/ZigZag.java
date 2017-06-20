package leetcode;


import java.util.ArrayList;
import java.util.List;

public class ZigZag {
	public String convert(String s, int numRows){
		
		
		if(s == null || s.length() <2 || numRows < 2){
			return s;
		}
		List<StringBuilder> list = new ArrayList();

		for(int i = 0; i< numRows; i++){
			list.add(new StringBuilder());
		}

		boolean isGoingDown = true;
		int index = 0;

		for(int i=0; i< s.length(); i ++){
			
			
			
			char c=s.charAt(i);
			
			
			System.out.println("adding " + c + " to index " + index);
			list.get(index).append(c);

			if(isGoingDown){
				System.out.println("goingDown ");
				if(index == numRows -1){
					System.out.println("index now is " + index );
					
					index = numRows -2;
					System.out.println("Change index to  " + index );
					
					isGoingDown = false;
				}else{
					index ++;
				}
			}else{
				if(index ==0 ){
					index =1;
					isGoingDown = true;
				}else{
					index--;
				}
			}
		}

		StringBuilder res = new StringBuilder();
		for(StringBuilder sb:list){
			res.append(sb.toString());
		}
		return res.toString();

	}


	public static void main(String[] args) {
		ZigZag zag = new ZigZag();
		
		String str = "123456789";
		String resultStr = zag.convert(str, 4);
		
		System.out.print(resultStr);

	}

}
