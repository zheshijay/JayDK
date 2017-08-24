package leetcode;


public class ReverInteger {
	
	//123

	public int reverse(int x) {
	    int rev = 0;
	    while(x != 0){
	        rev = rev*10 + x%10;
	        x = x/10;
	    }
	 
	    return rev;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverInteger ri = new ReverInteger();
		System.out.println(ri.reverse(1534236469));
		
	}

}
