package algo.string_and_array;

/*
 * 
 * Can be solved use 2 pointers
 * 
 * like str.indexOf
 *
 * step1:
 * --------
 * --
 * 
 * step2:
 * --------
 *   --
 *  
 *  step3:
 * -------- 
 *     --
 */   
public class StrStr {
	public static int strStr(String haystack, String needle) {

		if (needle == null || haystack == null)
			return -1;
		if (needle.length() > haystack.length())
			return -1;

		int nlength = needle.length();

		for (int i = 0; i <= haystack.length() - nlength; i++) {
			if (haystack.substring(i, i + nlength).equalsIgnoreCase(needle)) {
				return i;
			}
		}

		return -1;
	}


	
	public static void main(String args[]){
		
		StrStr test = new StrStr();
		
		System.out.println(test.strStr("vabcs", "bcs"));
		
	}
}
