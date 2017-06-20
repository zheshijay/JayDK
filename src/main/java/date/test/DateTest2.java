package date.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {

	public static void main(String[] args){
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");//dd/MM/yyyy
		String dateStr = "2015/01/01";
		Date date = new Date(dateStr);
		
		
		java.sql.Date date1 =  (java.sql.Date) date;
		
		System.out.println(sdfDate.format(date1));
	}
}
