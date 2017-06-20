package date.test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

public class DateUtil {
	
	public String getISO8601Time(){
        TimeZone tz = TimeZone.getDefault();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        return nowAsISO;
    }
	
	public static String getMMddyyyy(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String checkDate = sdf.format(date);
        return checkDate;
    }
	
	public static String getddMMMyyyy(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		String checkDate = sdf.format(date);
        return checkDate;
    }
	
	public static String getyyyyMMdd(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String checkDate = sdf.format(date);
        return checkDate;
    }
	
	public static Date getDate(int year, int month, int day){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH,day);
		
		Date d = cal.getTime();
        return d;
    }
	
	public static Date getExpiredDate(int year, int month, int day, int ttlInDays){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH,day);
		cal.add(Calendar.DATE, ttlInDays);
		
		Date d = cal.getTime();
        return d;
    }


	public static void main(String[] args){
		DateUtil du = new DateUtil();
		try {
			System.out.println("Date: " + du.getDate(1986, 6, 29));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
