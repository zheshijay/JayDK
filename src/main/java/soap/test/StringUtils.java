package soap.test;



import java.util.List;
import java.util.UUID;

public class StringUtils {
	
	public String getSQLString(List<String> strList){
		StringBuffer sqlString = new StringBuffer(); 
		for(String str: strList){
			sqlString.append(str + ",");
		}
		sqlString.deleteCharAt(sqlString.length()-1);
		return sqlString.toString();
	}
	
	public static String getSQLStringFromArray(String[] strArray) {
		String strs = "";
		for(int i = 0; i < strArray.length; i++){
			strs = strs.concat("'" + strArray[i] + "'" + ",");
		}
		
		if(strs.length() > 0)
			strs = strs.substring(0, strs.length()-1);
		return strs;
	}
	
	public static <Object> String getSQLStringFromList(List<Object> strList) {
		String strs = "";
		for(Object eachStr: strList){
			strs = strs.concat("'" + eachStr.toString() + "'" + ",");
		}
		
		if(strs.length() > 0)
			strs = strs.substring(0, strs.length()-1);
		return strs;
	}
	
	public static String getRandomUUID() {
		 	UUID uuid = UUID.randomUUID();
	        return uuid.toString();
	}

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

}

