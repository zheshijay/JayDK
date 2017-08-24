package leetcode;


public class FindSqrt {

	// 二分查找。注意结果不是整数时应返回整数部分。
	public static double findSquareRoot(double x) {  
        // Note: The Solution object is instantiated only once and is reused by each test case.  
        if (x < 2) {  
            return x;  
        }  
  
        int low = 1;  
        int high = (int) (x / 2);  
        int mid = 0;  
        int lastMid = 0;  
  
        while (low <= high) {  
            mid = (low + high) / 2;  
            if (x / mid > mid) {   
                low = mid + 1;  
                lastMid = mid;   
            } else if (x / mid < mid) {  
                high = mid - 1;  
            } else {  
                return mid;  
            }  
        }  
  
        return lastMid;  
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findSquareRoot(8));
	
	}

}
