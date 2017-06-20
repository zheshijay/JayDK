package json.gson.StrToObj;

import com.google.gson.Gson;

public class StringToObj {


	public static <T> T getObject(final String jsonString, final Class<T> objectClass) {  
		Gson gson = new Gson();  
		return gson.fromJson(jsonString, objectClass);  
	}

	public static void main(String args[]){
		StringToObj strToObj = new StringToObj();
//		String accountJson = "{\"acctNum\": \"3716160\",\"acctType\": \"DD\",\"notifyType\": \"sms\",\"smsNum\": \"12345\",\"emails\": [ \"zheshijay1@gmail.com\",\"zheshijay2@gmail.com\"],\"newDeliveryPref\": \"paperless\",\"oldDeliveryPref\": \"paper\"}"; 
		String accountJson = "%7B%22acctNum%22:%223716160%22,%22acctType%22:%22DD%22,%22notifyType%22:%22sms%22,%22smsNum%22:%2212345%22,%22emails%22:%5B%22zheshijay1@gmail.com%22,%22zheshijay2@gmail.com%22%5D,%22newDeliveryPref%22:%22paperless%22,%22oldDeliveryPref%22:%22paper%22%7D";
		System.out.println(accountJson);
		Account account = strToObj.getObject(accountJson, Account.class);
		System.out.println(account.getAcctNum());

	}
}
