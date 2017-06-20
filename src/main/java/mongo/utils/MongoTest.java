package mongo.utils;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoTest {

	private static MongoClient mongo = null;
	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	MongoConnector mongoConnector = new MongoConnector();
	public DBCollection getDBCollection(String collName){
		try {
			if(mongo == null) mongo = mongoConnector.getClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return (mongo.getDB("DV_inforeach")).getCollection(collName);
	}

	public Date getExpireTime(){
		//Set Cut Off Date
		Calendar cutoff = Calendar.getInstance();

		System.out.println("current time: " + cutoff.getTime());

		//		cutoff.add(Calendar.DATE, 0);
		//		cutoff.add(Calendar.HOUR_OF_DAY, 0);
		//		cutoff.add(Calendar.MINUTE, 0);
		cutoff.add(Calendar.SECOND, 10);
		System.out.println("expireTime: " + cutoff.getTime());

		return cutoff.getTime();

	}

	public void insertSmsCode(String npId, String code) {		
		// TODO Auto-generated method stub
		BasicDBObject document = new BasicDBObject();
		String timeStamp = dateFormatter.format(this.getExpireTime());
		document.put("expireAt", timeStamp);
		document.put("npId", npId);
		document.put("code", code);

		//		WriteConcern concern = new WriteConcern();
		DBCollection coll_record = this.getDBCollection("smscode");
		//		coll_record.setWriteConcern(concern.FSYNC_SAFE);
		coll_record.insert(document);

		System.out.println(document);
		System.out.println("success!");
	}

	public void deleteRecord(String filename) {
		DBCollection collection = this.getDBCollection("record");
		BasicDBObject query = new BasicDBObject();
		query.append("filename", filename);
		collection.remove(query);
	}

	private String getSmsCode(String npId) {
		BasicDBObject query = new BasicDBObject();
		query.put("npId", npId);
		String processDescription = "NA";
		String stopTheClockScan = "No";
		DBCollection coll_smscode = this.getDBCollection("smscode");
		try(DBCursor cursor = coll_smscode.find(query)){
			while(cursor.hasNext()) {
				DBObject object = cursor.next();
				return (String) object.get("code");
			}
		}
		return null;
	}



	//-----------------------------------------------------------------------

	public static int getAge(Date dateOfBirth) {
		int age = 0;
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		if(dateOfBirth!= null) {
			now.setTime(new Date());
			born.setTime(dateOfBirth);  
			if(born.after(now)) {
				throw new IllegalArgumentException("Can't be born in the future");
			}
			age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);             
			if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))  {
				age-=1;
			}
		}  
		return age;
	}


	public static String getRandomEmail(){
		String[] emailArray = new String[]{"Ben.Chan@infoimageinc.com", "Alok.Verma@infoimageinc.com", "nahid.rahman@dsinnovators.com", "nazmul.islam@dsinnovators.com", "khoshnoor.afroz@dsinnovators.com", "Zhe.Shi@infoimageinc.com"};  
		String email2 = emailArray[new Random().nextInt(emailArray.length)];
		return email2;
	}


	private void updateAudience() {

		DBCollection coll_test = this.getDBCollection("audience");

		int count = 0;
		try(DBCursor cursor = coll_test.find()){
			while(cursor.hasNext()) {
				BasicDBObject searchQuery = new BasicDBObject();
				BasicDBObject set = new BasicDBObject();

				//get a document
				BasicDBObject object = (BasicDBObject) cursor.next();
				ObjectId id = (org.bson.types.ObjectId) object.get("_id");

				System.out.println("updating id: " + id);

				if(object.get("dateOfBirth") instanceof String){
					object.append("age", null);
				}

				if(object.get("dateOfBirth") instanceof Date){
					Date dob = (Date) object.get("dateOfBirth");
					object.append("age", this.getAge(dob));
				}


				
				object.append("phone", "6507013188");
				object.append("email", this.getRandomEmail());

				

				//Update
				set.append("$set", object);
				searchQuery.append("_id", id);
				coll_test.update(searchQuery, set);

				System.out.println("updating record [" + count++ +  "]   --id: " + id);
			}
		}

	}











	public static void main(String[] args){
		MongoTest mongoTest = new MongoTest();

		mongoTest.updateAudience();
		//		mongoTest.insertSmsCode("24680", "1234");
		//		System.out.println("getSmsCode: " + mongoTest.getSmsCode("24680"));

	}
}
