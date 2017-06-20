package stringTest;

public class SplitTest {
	public void test1(){

		
		String str1 = "B|E";
		String str2 = "B,E";
		String[] statusArray = str1.split("\\|");
		String[] statusArray2 = str2.split(",");
		
		System.out.println("str1 length: " + statusArray.length);
		
		System.out.println("str1[0]: " + statusArray[0]);
		System.out.println("str1[1]: " + statusArray[1]);
		System.out.println("str2[1]: " + statusArray[1]);
		
		String encryptedAcctNums = "ToRDVjTdz3__XyhMX9ezjw";
		
		String[] encryptedAcctNumsArray = encryptedAcctNums.split(",");
		for(String str: encryptedAcctNumsArray){
				System.out.println("values: " + str);
		}	
		
	
		
	}
	
	
	
	public static void main(String [] args){
		SplitTest test = new SplitTest();
		test.test1();
		
	}
}
