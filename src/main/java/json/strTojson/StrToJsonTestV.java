package json.strTojson;


import java.io.StringReader;

import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


public class StrToJsonTestV {

	public static void main(String[] args){
		String jsonStr = "{\"age\": 27,\"name\": \"jay\"}";
		
		String jsonStr2 = "{\"age\": 27,\"name\": \"jay\",\"emails\": [{\"email\": \"aaa@g.com\"},{\"email\": \"bbb@g.com\"}]}";

		String jsonStr3 = "{\"message\":\"successful\",\"data\":{\"docs\":[{\"orgId\":\"rabo\",\"acctNum\":\"12308641\",\"stmtDate\":\"10/25/2010\",\"filename\":\"rabodsa_10252010_12308641_00479.afp\",\"OrgName\":\"Rabobank\",\"docId\":\"28772175\",\"type\":\"statement\"}],\"acctNum\":[\"12308641\"]}}";
		
		String test = " [{\"tempVars\": \"{\"id\":[\"\"],\"text\":[],\"sample\":[]}\"}]";
		String test2 = " [{\"tempVars\": \"{\"id\":[\"\"],\"text\":[],\"sample\":[]}\"}]";
		String test3 = " [{\"tempVars\": \"{\"key\":\"value\"}]";
		
//		String test4 = " [{"key1": "  { \"key\" : \"ss\" }  "}] ";
		
		JsonObject result = new JsonObject();
		Gson gson = new Gson();
		JsonObject dataJson;
		try {
			JsonParser parser = new JsonParser();
//			JsonObject jsonObj = (JsonObject)parser.parse(test);
			
//			JsonParser jsonParser = new JsonParser();
//			JsonObject address = (JsonObject) jsonParser.parse(test3)
//					.getAsJsonArray().get(0);
			
			JSONObject obj = new JSONObject(test3);
					
//			    .getAsJsonObject().get("Response")
//			    .getAsJsonObject().getAsJsonArray("View").get(0)
//			    .getAsJsonObject().getAsJsonArray("Result").get(0)
//			    .getAsJsonObject().get("Location")
//			    .getAsJsonObject().getAsJsonObject("Address");
//			String postalCode = address.get("PostalCode").getAsString();

//			JsonReader reader = new JsonReader(new StringReader(test2));
//			reader.setLenient(true);
//			
//			JsonArray userinfo1 = gson.fromJson(reader, JsonArray.class);
			
			System.out.println(obj);
//			JsonObject data = jsonObj.getAsJsonObject("data"); // get the name from data.
//		String age = data.getString("age"); // get the name from data.
//		System.out.println(jsonObj);
		
//		JSONArray docs = data.getJSONArray("docs"); // get the name from data.
//		JsonArray docs = data.getAsJsonArray("docs");// get the name from data.


		
//		JSONArray emails = data.getJSONArray("docs"); // get the name from data.
		
//		System.out.println(age);
//		System.out.println(name);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // get data object

	}

	public void getJsonObjFromString(){
		
	}
}
