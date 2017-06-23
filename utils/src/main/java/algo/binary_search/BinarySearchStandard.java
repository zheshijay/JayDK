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
	
	public boolean binarySearch2(int[] a, int k){
		int start=0, end=a.length-1;
		while(start+1 < end){
			System.out.println("start:"+start + " end:" + end);
			int mid = (start+end)/2;
			if(k > a[mid]) start = mid;
			else if(k < a[mid]) end = mid;
			else return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{0,1,2,3,4,5,6,7,8,9};
		int k=11;
		
		BinarySearchStandard test = new BinarySearchStandard();
		
		System.out.println(test.binarySearch(a, k));
		
		
	}
}
