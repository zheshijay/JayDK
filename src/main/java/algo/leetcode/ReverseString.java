package algo.leetcode;


public class ReverseString {
	
	public String reverse(String str){
	    String[] strArray = str.split(" ");
	    String result = "";
	    
	    for(int i=strArray.length-1; i>=0; i--){
	        result+= ((i==0)?strArray[i]: strArray[i]+" " );
	    }
	    
	    return result;
	}
	
	 public String reverseString2(String s) {
	        char[] chars = s.toCharArray();
	        String reverse = "";
	        
	        for(int i=chars.length-1; i>=0; i--){
	            reverse+=chars[i];
	        }
	        
	        return reverse;
	        
	    }

	public void method1(String str){
		String temp = "";
		String finalString = "";
		for(int i =str.length()-1;i>=0;i--){
			temp +=i!=0?str.charAt(i):str.charAt(i)+" ";
			System.out.println("temp is:" + temp);
			if(str.charAt(i) == ' '||i==0){
				for(int j=temp.length()-1;j>=0;j--){
					finalString += temp.charAt(j);
				}
				temp = "";
			}
		}
		System.out.println(finalString);
	}

	public void method2(String str){
		String[] strArray = str.split(" ");
		String finalStr="";
		for(int i = strArray.length-1; i>= 0 ;i--){
			finalStr += i==0?strArray[i]:strArray[i] + " ";
		}
		System.out.println("-"+finalStr+"-");
	}
	
	
	public static void main(String[] args){
		ReverseString rs = new ReverseString();
		String str = "Hello";
		System.out.println(rs.reverseString2(str));
	}
}
