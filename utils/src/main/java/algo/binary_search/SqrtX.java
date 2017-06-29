package algo.binary_search;

public class SqrtX {
	
	public int sqrt(int x) {
		long r = x;
		
		while (r*r > x)
			r = (r + x/r) / 2;
		
		return (int) r;
	}
	
	
	public static void main(String[] args){
		SqrtX test = new SqrtX();
		
		System.out.println(test.sqrt(8));
	}
}
