package nexmo;

import com.nexmo.messaging.sdk.NexmoSmsClient;
import com.nexmo.messaging.sdk.SmsSubmissionResult;
import com.nexmo.messaging.sdk.messages.TextMessage;
import config.UtilsConfig;

public class NexmoDEMO {

	public static void main(String[] args) {
		String API_KEY = UtilsConfig.getVal("API_KEY").toString();
		String API_SECRET = UtilsConfig.getVal("API_SECRET").toString();
		String SMS_FROM = UtilsConfig.getVal("SMS_FROM").toString();
		String SMS_TO = UtilsConfig.getVal("SMS_TO").toString();
		String SMS_TEXT = UtilsConfig.getVal("SMS_TEXT").toString();

		// Create a client for submitting to Nexmo
		NexmoSmsClient client = null;
		try {
			client = new NexmoSmsClient(API_KEY, API_SECRET);
		} catch (Exception e) {
			System.err.println("Failed to instanciate a Nexmo Client");
			e.printStackTrace();
			throw new RuntimeException("Failed to instanciate a Nexmo Client");
		}

		// Create a Text SMS Message request object ...
		TextMessage message = new TextMessage(SMS_FROM, SMS_TO, SMS_TEXT);

		// Use the Nexmo client to submit the Text Message ...
		SmsSubmissionResult[] results = null;
		try {
			results = client.submitMessage(message);
		} catch (Exception e) {
			System.err.println("Failed to communicate with the Nexmo Client");
			e.printStackTrace();
			throw new RuntimeException("Failed to communicate with the Nexmo Client");
		}

		// Evaluate the results of the submission attempt ...
		System.out.println("... Message submitted in [ " + results.length + " ] parts");
		for (int i=0;i<results.length;i++) {
			System.out.println("--------- part [ " + (i + 1) + " ] ------------");
			System.out.println("Status [ " + results[i].getStatus() + " ] ...");
			if (results[i].getStatus() == SmsSubmissionResult.STATUS_OK)
				System.out.println("SUCCESS");
			else if (results[i].getTemporaryError())
				System.out.println("TEMPORARY FAILURE - PLEASE RETRY");
			else
				System.out.println("SUBMISSION FAILED!");
			System.out.println("Message-Id [ " + results[i].getMessageId() + " ] ...");
			System.out.println("Error-Text [ " + results[i].getErrorText() + " ] ...");

			if (results[i].getMessagePrice() != null)
				System.out.println("Message-Price [ " + results[i].getMessagePrice() + " ] ...");
			if (results[i].getRemainingBalance() != null)
				System.out.println("Remaining-Balance [ " + results[i].getRemainingBalance() + " ] ...");
		}
	}

}