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


	public static int strStr(String srouce, String target) {

		if (target == null || srouce == null)
			return -1;
		if (target.length() > srouce.length())
			return -1;

		int nlength = target.length();

		for (int i = 0; i <= srouce.length() - nlength; i++) {
			if (srouce.substring(i, i + nlength).equalsIgnoreCase(target)) {
				return i;
			}
		}

		return -1;
	}


	public static int strStr2(String srouce, String target) {
		if (target == null || srouce == null)
			return -1;
		if (target.length() > srouce.length())
			return -1;

		int i=0, j=0;
		for( i=0; i< srouce.length(); i++){
 
			//check the k substring from index i, compare with target
			for(j=0; j< target.length(); j++){
				
				System.out.println(" compare " + (srouce.charAt(i+j)) +  " and " + (target.charAt(j)) );
				if(srouce.charAt(i+j) != target.charAt(j) ){
					break;
				}
			}
			if(j == target.length()) return i;	
		}
		return -1;
	}




	public static void main(String args[]){

		StrStr test = new StrStr();

		System.out.println(test.strStr2("abcde", "cde"));

	}
}
