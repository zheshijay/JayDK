package curl.send;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class SendCurl {
	public void sendCurl() throws UnsupportedEncodingException, IOException{
		URL url = new URL("https://rest.nexmo.com/sms/json?api_key=3e7882cf&api_secret=a213e3f1&from=MyCompany20&to=7148242485&text=hello");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
		    for (String line; (line = reader.readLine()) != null;) {
		        System.out.println(line);
		    }
		}

	}
	
	public static void main(String[] args){
		 System.out.println("-- Start --");
		SendCurl s = new SendCurl();
		try {
			s.sendCurl();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("-- End --");
	}
}
