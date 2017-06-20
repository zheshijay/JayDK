package apiTest;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ApiTest {
	public void updateUsrTest(){
		Client c = Client.create();
		WebResource resource = c.resource("http://localhost:8087/infoservice/api/v1/user/edcu/");

		Gson gson = new Gson();
		ApiTest test = new ApiTest();

		resource.header("Content-Type", "Application/json");

		String testStr = gson.toJson(test);
		System.out.println("Request Str: "+testStr);
		ClientResponse response = resource.post(ClientResponse.class, testStr);
		System.out.println("POST response : "+response);
	}
	
	
	public static void main(String[] args){
		ApiTest test = new ApiTest();
		System.out.println();
		
		
		
	}
}
