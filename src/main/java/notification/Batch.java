package notification;
import config.UtilsConfig;
public class Batch {
	
	public static void main(String[] args) {
		try {
			String apiURL = UtilsConfig.getVal("notification_api_base_url").toString();
			String orgName = "hebc";
			// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"1234567\", \"carrier\": \"tmobile\" }";
			String cName = "Test Campaign";
			String app = "estmt";
			String csvId = "88a6c300-a775-11e4-a79b-000c29af2cb6";
			String priority = "normal";
			String isSent = NotificationManager.sendBatch(apiURL, orgName, cName, app, csvId, priority);
			System.out.println("isSent: " + isSent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
