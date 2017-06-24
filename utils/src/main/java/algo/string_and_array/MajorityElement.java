package algo.string_and_array;


/**
 * 
 * 
Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:

       I/P : 3 3 4 2 4 4 2 4 4
       O/P : 4 

       I/P : 3 3 4 2 4 4 2 4
       O/P : NONE
 * 
 * @author ZShi
 *
 */
public class MajorityElement {
	 public int majorityElement(int[] num) {

	        int major=num[0], count = 1;
	        for(int i=1; i<num.length;i++){
	            if(count==0){
	                count++;
	                major=num[i];
	            }else if(major==num[i]){
	                count++;
	            }else count--;
	            
	        }
	        
	        System.out.println("count: " + count);
	        
	        return major;
	    }
	 
	 public static void main(String[] args) {
		 MajorityElement test = new MajorityElement();
		 System.out.println(test.majorityElement(new int[]{1,1,2,2,2,1,1,1}));
//		 System.out.println(test.majorityElement(new int[]{1,2,3}));
		 
		 
	 }
	 
	 
}
