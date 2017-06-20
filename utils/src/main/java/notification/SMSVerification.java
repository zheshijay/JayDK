package notification;

import java.util.HashMap;
import java.util.Map;

import config.UtilsConfig;

public class SMSVerification {
	
	public static void main(String[] args) {
		try {
			String apiURL = UtilsConfig.getVal("notification_api_base_url").toString();
			String orgName = "fffc";
			// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"1234567\", \"carrier\": \"tmobile\" }";
			RealTimeNotification sms = new RealTimeNotification();
//			sms.setApp("marketing");
			sms.setApp("estmt");
			sms.setTemplateid("3261");
			sms.setType("sms");
//			sms.setReplyTo("12137618058");
			sms.setfEmail("1234567");
			sms.setTo("1234567");
//			sms.setCarrier("tmobile");
			sms.setCarrier("na");
//			sms.setCarrier("att");
			sms.setType("sms");
//			sms.setTo("zheshijay@gmail.com");
//			sms.setCarrier("tmobile");
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("udv_txt_smsv_code", "8356");
//			vars.put("${testTwo}", "234");
			sms.setVars(vars);
			System.out.println("Send SMS/Email");
			boolean isSent = NotificationManager.sendOnDemand(apiURL, orgName, sms);
			
			System.out.println("isSent: " + isSent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
