package algo.string_and_array;

public class MergeSortedArray {

	 public int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		 int p1=0, p2=0, p3=0;
		 int len1 = nums1.length, len2 = nums2.length;
		 
		 int[] res = new int[m+n];
		 
		 
		 /**
		  * 
		  *   p1 ->  1 3 5 7  
		  *   p2 ->  2 4
		  *   
		  *   p3 ->  [ 1, 2, ... ]
		  * 
		  */
		 
		 while(p1 < len1 && p2 < len2){
			 
			 System.out.print("nums1[p1]: " + nums1[p1] + " - " + "nums2[p2]: " + nums1[p2]);

			 System.out.println();
			 if(nums1[p1] < nums2[p2]){
				 System.out.println("----------------------> adding " +  nums1[p1] + " from num1");
				 res[p3] = nums1[p1];          // add a value to new array
				 p3++;                         //move index to next
				 p1++;
			 }else{
				 System.out.println("----------------------> adding " +  nums2[p2] + " from num2");
				 res[p3] = nums2[p2];          // add a value to new array
				 p3++;                         //move index to next
				 p2++;
			 }
		 }
		 
		 System.out.println("===> p1:" + p1 + " -  p2: " + p2 );
		 
		 if(p1 < len1){
			 System.out.println(" adding rest of p1 ");
			 
			 while(p1 < len1){
				 res[p3] = nums1[p1];
				 p1++;
				 p3++;
			 }
			 
		 }else{
			 System.out.println(" adding rest of p2 ");
			 while(p2 < len2){
				 res[p3] = nums2[p2];
				 p2++;
				 p3++;
			 }
		 }
		 
		 return res;

	 }
	
		public static void main(String[] args){
			MergeSortedArray test = new MergeSortedArray();
			
//			int[] nums1 = new int[]{1,3,5};
//			int[] nums2 = new int[]{2,4,7};
			
			int[] nums1 = new int[]{0};
			int[] nums2 = new int[]{1};
			
			int[] res = test.mergeSortedArray(nums1, 1, nums2, 1);
			
			System.out.println(res);
			
			for(int num: res){
				System.out.print(num + " ");
			}
			
		}
	
	
}
