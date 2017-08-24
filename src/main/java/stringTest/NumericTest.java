package stringTest;

public class NumericTest {
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
	public static void main(String[] args){
		System.out.println(NumericTest.isNumeric("123")); 
	}
}
