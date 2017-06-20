package qa;

public class Atoi {
	public int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;

		// trim white spaces
		str = str.trim();

		char flag = '+';

		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;

		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == '-')
			result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;
	}
	
	public static void main(String args[]){
		Atoi test = new Atoi();
//		System.out.println(test.atoi("+aaa"));
		
		char character = 'a';    
		int ascii = (int) character;
		System.out.println(ascii);
	}
}
