package algo.string_and_array;

public class CheckAllPalindrome {

	public  boolean isPalindrome(String s){
		int i=0, j=s.length()-1;
		
		while(i < j){
			if(s.charAt(i++) != s.charAt(j--) ) return false;
		}
		return true;
	}

	public int countNumPalindromes(String s) {
		
		int count = 0;
		for(int i=0; i<s.length();i++){
			for(int j=i+1; j<= s.length(); j++){
				String subStr = s.substring(i, j);
				System.out.println("checking subStr: " + subStr);
				boolean isPali = this.isPalindrome(subStr);
			
				if(isPali) {count++; System.out.println(subStr + " is pali");}
			}
		}
		return count;
	}
	
	
	public static void main(String args[]){
		CheckAllPalindrome test = new CheckAllPalindrome();
		String str = "aba";
		System.out.println(str.substring(0, 1));
		int count = test.countNumPalindromes(str);

		System.out.println("total pali count: "+ count);


	}
}
