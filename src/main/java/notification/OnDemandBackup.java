package notification;

import config.UtilsConfig;

public class OnDemandBackup {
	
	public static void main(String[] args) {
		System.out.println("123");
		try {
			String apiURL = UtilsConfig.getVal("notification_api_base_url").toString();
			String orgName = "rwcu";
			// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"1234567\", \"carrier\": \"tmobile\" }";
			RealTimeNotification sms = new RealTimeNotification();
			sms.setApp("marketing");
			sms.setTemplateid("481");
//			sms.setType("sms");
//			sms.setTo("1234567");
			sms.setType("sms");
			sms.setTo("7148242485");
			sms.setCarrier("tmobile");
//			Map<String, String> vars = new HashMap<String, String>();
//			vars.put("${testOne}", "123");
//			vars.put("${testTwo}", "234");
//			sms.setVars(vars);
			boolean isSent = NotificationManager.sendOnDemand(apiURL, orgName, sms);
			
			System.out.println("isSent: " + isSent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
