package stringTest;

import java.util.ArrayList;
import java.util.List;

public class StringTest {
	
	public String getSQLString(List<String> values) {
		StringBuilder result= new StringBuilder();
		for(String str: values){
			result.append(str + ",");
		}
		
		result.delete(result.length()-1, result.length());
		return result.toString();
	}
	
	public void testEmptyStr() {
		String str1 = "";
		String str2 = "";
		
		System.out.println(str1.equals(""));
	}
	
	public static String getRequestHost(String request, boolean admin){

		String url = request;
		int idx = url.indexOf("/secure");
		if(idx!=-1) url = url.substring(0, idx);

		return url;
	}
	
	public static void likeTest(){

		String str1 = "1234567890";
		String str2 = "1234567890";
		System.out.println(str1.matches(".*7890"));
		
	}
	
	
	
	public static void main(String [] args){
//		StringTest strTest = new StringTest();
//		List<String> accounts = new ArrayList();
//		accounts.add("1");
//		accounts.add("2");
//		accounts.add("3");
//		accounts.add("4");

//		System.out.println(strTest.getSQLString(accounts));
		
//		String url = "https://infotrac-secure-pilot.infoimageinc.com/secure/uploadAiFile.do";
		StringTest test = new StringTest();
		test.likeTest();
//		String appID = "Stmt - DDA First Natn'l");
//		System.out.println(appID.replaceAll("'", "''"));
		
		
	}
}
