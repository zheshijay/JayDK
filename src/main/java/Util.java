

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Util class
* 
* @author  Jay Shi
* @version 1.0
* @since   2017-05-12 
*/
public class Util {
	public static Date getLastRenteDate(int year, int month, int day){
		String date = year + "/" + month + "/" + day;
		java.util.Date utilDate = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			utilDate = formatter.parse(date);
			System.out.println("utilDate:" + utilDate);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return utilDate;
	}
}
