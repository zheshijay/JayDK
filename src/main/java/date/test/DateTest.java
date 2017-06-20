package date.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

		public static void main(String[] args){
			DateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");//dd/MM/yyyy
//			DateFormat checkDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

//			
//			
//			Calendar now = Calendar.getInstance();   // Gets the current date and time
//			Date today = new Date();
////		    String startDate = "01/01/".concat(String.valueOf(now.get(Calendar.YEAR)));
//			
////			String startDate = "01/01/2015";
//			String startDate = "2015/01/01";
//		    Date stDate = null;
//			try {
//				System.out.println(sdfDate.parse(startDate));
//				stDate = sdfDate.parse(startDate);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String endDate = sdfDate.format(today);
//			System.out.println(stDate);
			
//			String dateStr = "01-Aug-15";
			String dateStr = "08/01/2015";
			Date date = new Date(dateStr);
			System.out.println(sdfDate.format(date));
		}
}
