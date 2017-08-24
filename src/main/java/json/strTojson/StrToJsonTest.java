package json.strTojson;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StrToJsonTest {

	public static void main(String[] args){
		String jsonStr = "{\"age\": 27,\"name\": \"jay\"}";
		
		String jsonStr2 = "{\"age\": 27,\"name\": \"jay\",\"emails\": [{\"email\": \"aaa@g.com\"},{\"email\": \"bbb@g.com\"}]}";

		String jsonStr3 = "{\"message\":\"successful\",\"data\":{\"docs\":[{\"orgId\":\"rabo\",\"acctNum\":\"12308641\",\"stmtDate\":\"10/25/2010\",\"filename\":\"rabodsa_10252010_12308641_00479.afp\",\"OrgName\":\"Rabobank\",\"docId\":\"28772175\",\"type\":\"statement\"}],\"acctNum\":[\"12308641\"]}}";
		
		JSONObject result = new JSONObject();

		JSONObject dataJson;
		try {
			dataJson = new JSONObject(jsonStr3);

			JSONObject data = dataJson.getJSONObject("data"); // get the name from data.
//		String age = data.getString("age"); // get the name from data.
		System.out.println(data);
		
		JSONArray docs = data.getJSONArray("docs"); // get the name from data.
		
		System.out.println("docs is: " + docs);
		
//		JSONArray emails = data.getJSONArray("docs"); // get the name from data.
		
//		System.out.println(age);
//		System.out.println(name);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // get data object

	}

	public void getJsonObjFromString(){
		
	}
}
