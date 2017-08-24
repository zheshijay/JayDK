package algo.string_and_array;

public class RepeatedStringPattern {

	
	/*
	 * 
	 * 
AAAAAAAAA
ABABAB
ABCAB
ABAb
it would output:

A
AB
ABCAB
ABAb
	 */
	 public boolean repeatedSubstringPattern(String str) {
	        int substringEndIndex = -1;
	        int i = 0;
	        char startOfString = str.charAt(0);
	        i++;
	        char ch;
	        while(i < str.length()){
	            if((ch=str.charAt(i)) != startOfString){
	                //create a substring until the char at start of string is encountered 
	                i++;
	            }else{
	                if(str.split(str.substring(0,i)).length == 0){
	                    return true;
	                }else{
	                    //false alarm. continue matching.
	                    i++;
	                }
	            }
	        }
	        return false;
	    }


	 public boolean myRepeatStrPattern(String str){
		 
		 if(str.length() == 2 && str.charAt(0) == str.charAt(1)) return true;
		 
		 String pattern = "";
		 char firstChar = str.charAt(0);
		 
		 System.out.println("firstChar is: " + firstChar);
		 
		 
		 
		 int i=1;
		 while(i < str.length()-1){
			 if(str.charAt(i) != firstChar) i++;
			 else{  System.out.println("-- found pattern is: " + str.substring(0, i)); pattern = str.substring(0, i); break;}
		 }
		 
		 System.out.println("pattern is: " + pattern);
		 if(str.split(pattern).length == 0) return true;
		 
		 return false;
	 }
	 


	public static void main(String args[]){
		RepeatedStringPattern test = new RepeatedStringPattern();

		String str = "ababab";
		boolean res = test.myRepeatStrPattern(str);

		System.out.println("res: "+ res);


	}
}
