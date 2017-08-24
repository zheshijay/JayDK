package corejava.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringSort {
	
	public void sort1(){
		String num_1 = "1";
		String num_2 = "2";
		String num_3 = "3";
		
		String str_a = "a";
		String str_b = "b";
		String str_c = "c";
		
		String cap_a = "A";
		String cap_b = "B";
		String cap_c = "C";
		
		List<String> rows = new ArrayList<String>();
		rows.add(num_1);
		rows.add(num_2);
		rows.add(num_3);
		
		rows.add(str_a);
		rows.add(str_b);
		rows.add(str_c);
		
		rows.add(cap_a);
		rows.add(cap_b);
		rows.add(cap_c);
		
		Collections.sort(rows);
		
		
		System.out.println("After sort:" + rows);
		
		
	}
	
	public void sort2(){
		

		String row_default = "1801|0|18721|ms1_Default_19.imp|d52a673da0fd6a5dd1fd686378ddf86a|||||||Default";
		String row_default2 = "1802|0|18722|ms1_Default_29.imp|d52a673da0fd6a5dd1fd686378ddf86a|||||||Default";
		
		String row_11 = "1801|1|18723|ms1_Zip_11.imp|81f028223c0c690d58aae6f07958bfb9||||||AND|Zip~include~v:11111";
		String row_21 = "1802|1|18724|ms1_Zip_21.imp|81f028223c0c690d58aae6f07958bfb9||||||AND|Zip~include~v:11111";
		
		
		String row_12 = "1801|2|18725|ms1_Zip_12.imp|ee227956c6646e19c74d8ac59d190cc0||||||AND|Zip~include~v:22222";
		String row_22 = "1802|2|18726|ms1_Zip_22.imp|ee227956c6646e19c74d8ac59d190cc0||||||AND|Zip~include~v:22222";
		
		
		String row_13 = "1801|3|18727|ms1_Zip_13.imp|07c2e7f45cea2e4a818bb1458af79f84||||||AND|Zip~include~v:33333";
		String row_23 = "1802|3|18728|ms1_Zip_23.imp|07c2e7f45cea2e4a818bb1458af79f84||||||AND|Zip~include~v:33333";
		
		List<String> rows = new ArrayList<String>();
		rows.add(row_default);
		rows.add(row_default2);
		
		rows.add(row_11);
		rows.add(row_21);
		
		rows.add(row_12);
		rows.add(row_13);
		
		
		rows.add(row_22);
		rows.add(row_23);
	

		Collections.sort(rows);
		System.out.println("Before sort:");
		for (String eachRow: rows) {
			System.out.println("eachRow 1: " + eachRow);
		}
		
		System.out.println("--------------------------");
		
		 Collections.sort(rows, new Comparator<String>()
				    {
				        @Override
				        public int compare(String target1, String target2)
				        {
				        	String msg1[] = target1.split("\\|");
				        	String msg2[] = target2.split("\\|");

				            Integer msgArea1_value = Integer.parseInt(msg1[0]);
				            Integer msgArea2_value = Integer.parseInt(msg2[0]);
				        	
				            Integer priority1_value = Integer.parseInt(msg1[1]);
				            Integer priority2_value = Integer.parseInt(msg2[1]);
				            
				            if(msgArea1_value.equals(msgArea2_value)){
				            	 
				            	 if((priority1_value==0) && (priority2_value!=0)) return 1;
				            	 if((priority2_value==0) && (priority1_value!=0)) return -1;
				            	 
				            	return priority1_value.compareTo(priority2_value);
				            }

				            return msgArea1_value.compareTo(msgArea2_value);
				        }
				    });
		
			System.out.println("After sort:");
		for (String eachRow: rows) {
			System.out.println("eachRow: " + eachRow);
		}

	}
	
	public static void main(String [] args){
		StringSort test = new StringSort();
		test.sort1();

		
	}
}
