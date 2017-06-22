package algo.string_and_array;

/*
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 */
public class MedianofTwoSortedArrays {
	public int findMidOfTwoSortedArray(int[] nums1, int[] nums2){
		int l1=nums1.length, l2=nums2.length;
		int p1=0, p2=0;

		int targetIndex = ( l1 + l2 ) / 2;  
		int indexCounter = 0;

		System.out.println("targetIndex: "+targetIndex);

		while(p1 < l1 && p2<l2){
			System.out.println("indexCounter: "+ indexCounter);
			System.out.println("p1:" + p1 + " - p2:" + p2);
			System.out.println("nums1[p1]:" + nums1[p1] + " -  nums2[p2]:" + nums2[p2]);

			if(nums1[p1] < nums2[p2]){ 
				p1++; 
				if(indexCounter == targetIndex) return nums1[p1]; 
				indexCounter++; 
			}else{ 
				p2++; 
				if(indexCounter == targetIndex) return nums2[p2]; 
				indexCounter++; }
		}

		while(p1<l1){ 

			if(indexCounter == targetIndex) return nums1[p1]; 
			p1++; 
			indexCounter++; 
		}

		while(p2<l2){ 
			System.out.println("rest of p2 - indexCounter: "+ indexCounter ); 
			if(indexCounter == targetIndex) return nums2[p2]; 
			p2++; 
			indexCounter++; 
			}

		return -1;

	}

	public static void main(String args[]){
		MedianofTwoSortedArrays test = new MedianofTwoSortedArrays();

		int[] nums1 = new int[]{1,2,3};
		int[] nums2 = new int[]{0,9};

		int mid = test.findMidOfTwoSortedArray(nums1, nums2);
		System.out.println("mid: " + mid);

	}




}
