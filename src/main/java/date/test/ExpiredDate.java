package date.test;

import java.util.Date;

public class ExpiredDate {
	public static void main(String[] args){
		
		
		String startDate = "2017.01.19.15.56.57";
		String[] timeBlock = startDate.split("\\.");
		System.out.println("year: " + Integer.parseInt(timeBlock[0]));
		System.out.println("month: " + Integer.parseInt(timeBlock[1]));
		System.out.println("day: " + Integer.parseInt(timeBlock[2]));
		
		
		Date startTime = DateUtil.getDate(Integer.parseInt(timeBlock[0]), Integer.parseInt(timeBlock[1]),Integer.parseInt(timeBlock[2]));
		
		System.out.println("startTime: " + startTime);
		
		
		
		Date expireDate = DateUtil.getExpiredDate(Integer.parseInt(timeBlock[0]), Integer.parseInt(timeBlock[1]),Integer.parseInt(timeBlock[2]), 2);

		System.out.println("expireDate: " + expireDate);

		
	}
}
