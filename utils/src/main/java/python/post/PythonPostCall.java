package python.post;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonPostCall { 

	public void sendCURLCall() throws IOException{
		String URL = "http://10.8.9.71:8008/execute-delivery/";
		String prodId = "123";
		String dt_job_id = "456";
		String env = "prod";		

		HttpClient httpclient = new HttpClient();
		BufferedReader bufferedreader = null;

		PostMethod postmethod = new PostMethod(URL);
		postmethod.addParameter("proc_id",prodId);
		postmethod.addParameter("dt_job_id", dt_job_id);
		postmethod.addParameter("env", env);

		try{
			int rCode = httpclient.executeMethod(postmethod);

			if(rCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err.println("The Post postmethod is not implemented by this URI");
				postmethod.getResponseBodyAsString();
			} else {
				bufferedreader = new BufferedReader(new InputStreamReader(postmethod.getResponseBodyAsStream()));
				String readLine;
				while(((readLine = bufferedreader.readLine()) != null)) {
					if(readLine.contains("Request Submitted Successfully")) {
						System.out.println("Success");
					}
					System.out.println("Response from server: " + readLine);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			postmethod.releaseConnection();
			if(bufferedreader != null) try { 
				bufferedreader.close(); 
			} 
			catch (Exception fe)
			{
				fe.printStackTrace();
			}
		}
	}

	public static void main(String args[]) 
	{
		PythonPostCall pythonPostCall = new PythonPostCall();
		try {
			pythonPostCall.sendCURLCall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
