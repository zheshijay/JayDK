package leetcode;


public class Power {

	//O(log n)
	public double power(double x, int n) {
		
		
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
		
		System.out.println();
		System.out.print(" v is: " + v);
		System.out.print(" x is: " + x);
		System.out.print(" n is: " + n);
		
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}
	
	
	//O(n)
	double pow2(double x, int n)  
	{  
	    if(n==0)  
	        return 1.0;  
	    if(n<0)  
	        return 1.0/pow2(x,-n);  
	    return x*pow2(x,n-1);  
	}  
	
	double pow3(double x, int n)  
	{
		if(n==0) return 1;
		if(n < 0) return 1.0/pow3(x, -n);
		
		return x*pow3(x, n-1);
		
		
	}  
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Power mycalss = new Power();
		System.out.println("    Result: " + mycalss.pow2(2, -10));

	}

}
