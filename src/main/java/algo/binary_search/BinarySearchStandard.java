package algo.binary_search;

public class BinarySearchStandard {
	
	public boolean binarySearch(int[] a, int k){
		int start=0, end=a.length-1;
		
		while(start <= end){ 
			System.out.println("start:"+start + " end:" + end);
			int mid = (start+end)/2;
			if(k > a[mid]) start = mid + 1;
			else if(k < a[mid]) end = mid -1;
			else return true;
		}
		return false;
	}

	
	//-----------------------------------------	
	public int myBinarySearch(int[] nums, int k){
		
		if(nums == null || nums.length == 0) return -1;
		int start=0, end=nums.length-1;
		
		while(start+1 < end){
			int mid = (start+end)/2;
			
			if(k > nums[mid]) start = mid;
			else end = mid;
		}
		
		if(nums[start] == k) return start;
		else if(nums[end] == k) return end;
		
		return -1;
	}
	
	public boolean binarySearch2(int[] a, int k){
		int start=0, end=a.length-1;
		while(start+1 < end){
			System.out.println("start:"+start + " end:" + end);
			int mid = (start+end)/2;
			System.out.println("mid:" + mid);
			if(k > a[mid]) start = mid;
			else end = mid;
		}
		
		if(a[start] == k || a[end] == k) return true;
		return false;
	}
	
	
	public static void main(String[] args){
		int[] a = new int[]{0,1,2,3,4,5,6,7,8,9};
//		int[] a = new int[]{1,4,7,9,12,56,89,899};
		int k=9;
		
		BinarySearchStandard test = new BinarySearchStandard();
		
//		System.out.println(test.myFindVal(a, k));
		
		
	}
}
