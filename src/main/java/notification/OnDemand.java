package notification;

import config.UtilsConfig;

public class OnDemand {
	
	public static void main(String[] args) {
		System.out.println("== start  123");
		try {
			String apiURL = UtilsConfig.getVal("notification_api_base_url").toString();
			String orgName = "demo";
			// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"1234567\", \"carrier\": \"tmobile\" }";
			RealTimeNotification sms = new RealTimeNotification();
			sms.setApp("notification");
			sms.setTemplateid("2402");
			sms.setType("sms");
//			sms.setfEmail("12105190241");
			sms.setTo("17148242485");
			sms.setCarrier("na");
//			Map<String, String> vars = new HashMap<String, String>();
//			vars.put("${testOne}", "123");
//			vars.put("${testTwo}", "234");
//			sms.setVars(vars);
			boolean isSent = NotificationManager.sendOnDemand(apiURL, orgName, sms);
			
			System.out.println("isSent: " + isSent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("== start  123");
	}

}
