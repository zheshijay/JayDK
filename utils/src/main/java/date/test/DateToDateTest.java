package date.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToDateTest {
	public static void main(String[] args){
		
		try {
			
		String uspsDate = "09/14/2015 02:12:51";
		String psiDate = "20150916";
		DateFormat psiRecordDateFormatter = new SimpleDateFormat("yyyyMMdd");
		DateFormat uspsScanTimeFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date psiScanDate = psiRecordDateFormatter.parse(psiDate);
		String transferedPsiScanTime = uspsScanTimeFormatter.format(psiScanDate);
		
		Date uspsScanDate = uspsScanTimeFormatter.parse(uspsDate);
		
		System.out.println(psiDate.length());
	
			System.out.println(transferedPsiScanTime);
			
			System.out.println(uspsScanDate.compareTo(psiScanDate));
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
