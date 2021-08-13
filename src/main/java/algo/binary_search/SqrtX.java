package algo.binary_search;

public class SqrtX {
	
	 public int mySqrt(int x) {
	        int l = 0, r = x, ans = -1;
	        while (l <= r) {
	            int mid = l + (r - l) / 2;
	            if ((long) mid * mid <= x) {
	                ans = mid;
	                l = mid + 1;
	            } else {
	                r = mid - 1;
	            }
	        }
	        return ans;
	    }

	
	
	public static void main(String[] args){
		SqrtX test = new SqrtX();
		
		System.out.println(test.mySqrt(8));
	}
}
