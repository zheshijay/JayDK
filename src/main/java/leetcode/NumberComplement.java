package leetcode;

public class NumberComplement {
    public static int findComplement(int num) {
    	String binaryString = Integer.toBinaryString(num);

    	  String temp = "";
    	  for(char c: binaryString.toCharArray()){
    	      if(c == '1'){
    	          temp += "0";
    	      }
    	      else{
    	          temp += "1";
    	      }
    	  }
    	  int base = 2;
    	  int complement = Integer.parseInt(temp, base);

    	  return complement;
    }
    
    public static void main(String[] args){
    	
    	System.out.println(NumberComplement.findComplement(5));
    }
    
}
