package algo.string_and_array;

/*
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 */
public class MedianofTwoSortedArrays {
	public double findMidOfTwoSortedArray(int[] nums1, int[] nums2) {
		 int a[]=new int[nums1.length+nums2.length];
		 int lindex=0,rindex=0;
		 int index=0;
		 while (lindex<nums1.length&&rindex<nums2.length) {
			if(nums1[lindex]<nums2[rindex])
			{
				a[index++]=nums1[lindex++];
			}
			else {
				a[index++]=nums2[rindex++];
			}
		}
		 while (lindex<nums1.length) {
				a[index++]=nums1[lindex++];
		}
		 while (rindex<nums2.length) {
				a[index++]=nums2[rindex++];
		}
		 if(a.length%2==0)
			 return (double)(a[a.length/2-1]+a[a.length/2])/2;
		 else {
			return a[a.length/2];
		}

	}

	public static void main(String args[]) {
		MedianofTwoSortedArrays test = new MedianofTwoSortedArrays();

		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 3, 4 };

		double mid = test.findMidOfTwoSortedArray(nums1, nums2);
		System.out.println("mid: " + mid);

	}

}
