package httpCallFromJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SendHttpRequest {
	private final String USER_AGENT = "Mozilla/5.0";

	// HTTP GET request 
	private void sendGet() throws Exception {
		
		String url = "http://www.google.com/search?q=jay";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
	private void sendPost2(){
		try {

			URL url = new URL("http://localhost:8080/infoservice/api/v1/document/edcu/batchjob?ttl=1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST"); 
			conn.setRequestProperty("Content-Type", "application/json");

			String payload = "[{\"acctNum\": 313202, \"stmtType\": \"statement\", \"docId\" : 100145086}]";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public Integer puiCallback() {


		String callbackUrl = "http://10.8.8.225:9090/JobNotifier?cid=sscu&app=afp&pJobId=118166&jobStatus=200&reviewedBy=client&jobApproved=true";
		int responseCode = 200;

		try {

			URL url = new URL(callbackUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// optional default is GET
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "text/xml");
			connection.setRequestProperty("Content-Type","application/x-www- form-urlencoded"); 
			//add request header
			//		con.setRequestProperty("User-Agent", USER_AGENT);

			responseCode = connection.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		//		return responseCode;
		return 200; 
	}

	private void sendBidRequest(){
		try {

			URL url = new URL("http://localhost:8080/bid_request/doubleclick");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST"); 
			conn.setRequestProperty("Content-Type", "application/octet-stream");

			//file
			Path path = Paths.get("/Users/jay/temp/protoc_test/sample_bidrequest.h");
			
//			Path path = Paths.get("/Users/jay/temp/protoc_test/2017_request_log");
			byte[] byte_array_data = Files.readAllBytes(path);
			
			
//			String payload = "[{\"acctNum\": 313202, \"stmtType\": \"statement\", \"docId\" : 100145086}]";
			
			OutputStream os = conn.getOutputStream();
			os.write(byte_array_data);
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}





	public static void main(String[] args){
		SendHttpRequest test = new SendHttpRequest();
		//		test.puiCallback();
		test.sendBidRequest();


	}


}
