package algo.leetcode;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumber {

	public static boolean isNumber(String str) {
		if(str==null) return false;
		
		 String pattern = "^(-)?[0-9]+(\\.)?[0-9]+$";
	     Pattern r = Pattern.compile(pattern);
	     Matcher m = r.matcher(str);
	     if (m.find( )) {
	        return true;
	     } else {
	        return false;
	     }
	}
	
	 public static boolean isNumber2(String string) {
		    return string.matches("^\\d+$");
//		 return string.matches("^(-)?[0-9]+(\\.)?[0-9]+$");
		  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("123"));
	}

}
