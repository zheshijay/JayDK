package notification;

import java.lang.reflect.Type;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class NotificationManager {
	
	public static boolean sendOnDemand(String apiURL, String orgName, RealTimeNotification notification) throws Exception {
		if (notification == null) {
			throw new Exception("Sms content is missing");
		}
		// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"1234567\", \"carrier\": \"tmobile\" }";
		boolean isSent = false;
		try {
			Gson gson = new Gson();
			String jsonStr = gson.toJson(notification);
			System.out.println("jsonStr====> " + jsonStr);
			
			Client client = new Client();
			WebResource webResource = client.resource(apiURL);
			ClientResponse response = webResource.path(orgName).path("realtime").type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonStr);
			
			int status = response.getStatus();
			
			String responseStr = response.getEntity(String.class);
			System.out.println("response: " + responseStr);
			
			if (status == 200) {
				isSent = true;
			} else {
				System.out.println("Status: " + status);
				System.out.println("3 response: " + responseStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}
	
	public static boolean sendOnDemandwithTrack(String apiURL, String orgName, RealTimeNotification notification) throws Exception {
		if (notification == null) {
			throw new Exception("Sms content is missing");
		}
		// "{\"app\": \"estmt\",\"templateid\": 501,\"type\":\"sms\", \"to\": \"4152032591\", \"carrier\": \"tmobile\" }";
		boolean isSent = false;
		try {
			Gson gson = new Gson();
			String jsonStr = gson.toJson(notification);
			System.out.println("jsonStr====> " + jsonStr);
			
			Client client = new Client();
			WebResource webResource = client.resource(apiURL);
			ClientResponse response = webResource.path(orgName).path("ondemand/track").type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonStr);
			
			int status = response.getStatus();
			
			String responseStr = response.getEntity(String.class);
			System.out.println("response: " + responseStr);
			
			if (status == 200) {
				isSent = true;
			} else {
				System.out.println("Status: " + status);
				System.out.println("3 response: " + responseStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}
	
	public static String sendBatch(String apiURL, String orgName, String cName, String app, String csvId, String priority) {
		String jobId = null;
		try {
			Client client = new Client();
			WebResource webResource = client.resource(apiURL);
			MultivaluedMapImpl queryParams = new MultivaluedMapImpl();
			queryParams.add("cName", cName);
			queryParams.add("app", app);
			queryParams.add("csvId", csvId);
			queryParams.add("priority", priority);
			ClientResponse response = webResource.path(orgName).path("job").queryParams(queryParams).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
			int status = response.getStatus();
			String responseStr = response.getEntity(String.class);
			
			System.out.println("response: " + responseStr);
			
			if (status == 200) {
				Gson gson = new Gson();
				Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
				Map<String, String> resultMap = gson.fromJson(responseStr, mapType);
				System.out.println("getStatus: " + response.getStatus());
				jobId = resultMap.get("job_id");
			} else {
				System.out.println("Status: " + status);
				System.out.println("response: " + responseStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobId;
	}

}
