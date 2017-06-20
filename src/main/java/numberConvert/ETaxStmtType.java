package numberConvert;

import java.util.ArrayList;

public class ETaxStmtType {
	private static java.util.Hashtable<String, String> etaxStmtTypes= new java.util.Hashtable();
	static{
		etaxStmtTypes.put("1",			"1098");					
		etaxStmtTypes.put("10", 			"1099B");					
		etaxStmtTypes.put("100", 			"1099C");				
		etaxStmtTypes.put("1000", 			"1099DIV");				
		etaxStmtTypes.put("10000", 		"1099-INT");			
		etaxStmtTypes.put("100000", 		"1099MISC");					
		etaxStmtTypes.put("1000000", 		"1099Q");					 		
		etaxStmtTypes.put("10000000", 		"1099OID");		
		etaxStmtTypes.put("100000000", 		"1099R");					
		etaxStmtTypes.put("1000000000", 		"1099-SA");						
		etaxStmtTypes.put("10000000000", 		"5498");											
		etaxStmtTypes.put("100000000000", 		"5498-ESA");									
		etaxStmtTypes.put("1000000000000", 		"5498-SA");							
		etaxStmtTypes.put("10000000000000", 		"W2G");									
		etaxStmtTypes.put("100000000000000",		"1098-E");
		etaxStmtTypes.put("1000000000000000",		"1099-A");
		etaxStmtTypes.put("10000000000000000",		"1042-S");
		etaxStmtTypes.put("100000000000000000", 	"1099Q-IRA");
		etaxStmtTypes.put("1000000000000000000",		"5498-IRA");	
		etaxStmtTypes.put("10000000000000000000", 	"1098-HELOC");
		etaxStmtTypes.put("100000000000000000000",	"1099R-IRA");
		etaxStmtTypes.put("1000000000000000000000",	"1099SA-IRA");
		etaxStmtTypes.put("10000000000000000000000", 	"5498-IRA(APR)");
		etaxStmtTypes.put("100000000000000000000000", 	"5498ESA-IRA");
		etaxStmtTypes.put("1000000000000000000000000", 	"5498SA-IRA");
		etaxStmtTypes.put("10000000000000000000000000",	"FMV-Notice");
	}
	
	public static String getETaxStmtTypeDesc(String strBinaryNum){
		return etaxStmtTypes.get(strBinaryNum);
	}

	public static ArrayList<String> getENoticeStmtType(String binaryNum){
		ArrayList<String> stmtTypes = new ArrayList<String>();
		
		int intBinaryNum = Integer.parseInt(binaryNum);

			String strBinaryNum = Integer.toBinaryString(intBinaryNum);
			System.out.println("strBinaryNum is: " + strBinaryNum);
			
			char[] charNums = strBinaryNum.toCharArray();
			for(int index = 0; index < charNums.length ; index++){
				System.out.println("-----------------------------------");
				System.out.println("character is: " + charNums[index]);
				System.out.println("index is: " + index);
				
				Character eachChar = charNums[index];
				String strEachDigit = eachChar.toString();
				
				System.out.println("strEachDigit: "+strEachDigit);
				
				if(strEachDigit.equals("1")){
					for(int i=1; i < charNums.length-index; i ++){
						System.out.println("add zero");
						strEachDigit = strEachDigit.concat("0");
					}
					stmtTypes.add(getETaxStmtTypeDesc(strEachDigit));
				}
				System.out.println("string to prepare enotice type is: " + strEachDigit);
		
			}
		return stmtTypes;
	}
	
	public static void main(String[] args){
		String binaryNum = "23";
		System.out.println(getENoticeStmtType(binaryNum));
	}
}
