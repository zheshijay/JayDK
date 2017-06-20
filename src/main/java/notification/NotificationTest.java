package notification;

import java.util.HashMap;
import java.util.Map;

import config.UtilsConfig;

public class NotificationTest {
	
	public static void main(String[] args) {
		try {
			String apiURL = UtilsConfig.getVal("notification_api_base_url").toString();
			String orgName = "demo";
			// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"1234567\", \"carrier\": \"tmobile\" }";
			RealTimeNotification real = new RealTimeNotification();
			real.setApp("marketing");
			real.setTemplateid("1234");
//			real.setType("sms");
			real.setType("email");
//			real.setReplyTo("1234567");
//			real.setfEmail("1234567");
//			real.setTo("1234567");

//			real.setCarrier("att");
//			real.setType("email");
			real.setTo("zheshijay@gmail.com");
			real.setCarrier("na");
//			real.setCarrier("tmobile");
			
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("udv_txt_smsv_code", "1234");
//			vars.put("${testTwo}", "234");
			real.setVars(vars);
			System.out.println("Send SMS/Email");
//			boolean isSent = NotificationManager.sendOnDemand(apiURL, orgName, sms);
			boolean isSent = NotificationManager.sendOnDemandwithTrack(apiURL, orgName, real);
			System.out.println("isSent: " + isSent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
