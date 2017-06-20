package mongo.utils;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoTest2 {

	private static MongoClient mongo = null;
	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	MongoConnector mongoConnector = new MongoConnector();
	public DBCollection getDBCollection(String collName){
		try {
			if(mongo == null) mongo = mongoConnector.getClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return (mongo.getDB("i3jobtrack")).getCollection(collName);
	}
	
	public void deleteRecord(String cid) {
		DBCollection collection = this.getDBCollection("record");
		BasicDBObject query = new BasicDBObject();
		query.append("cid", cid);
		collection.remove(query);
	}
	
	public void deleteCollection(String collName) {
		// TODO Auto-generated method stub
		DBCollection collection = this.getDBCollection(collName);
		collection.drop();
	}
	
	public void deleteLookupRecord(String cid) {
		BasicDBObject query = new BasicDBObject();
		query.append("cid", cid);
//		query.append("proc_id", pricId);
		
		System.out.println("Removing look up records for cid " + cid);
		DBCollection coll_lookup = this.getDBCollection("lookup");
		coll_lookup.remove(query);
	}



	public void getLookUpRecords() {		

		DBCollection coll_scanlog = this.getDBCollection("lookup");
		
		BasicDBObject query = new BasicDBObject();
		query.append("cid", "aabk");
		
		try(DBCursor cursor = coll_scanlog.find(query)){
			while(cursor.hasNext()) {
				DBObject object = cursor.next();
				System.out.println(object);
			}
		}
	}
	
	public void getCollections() {		

		DBCollection coll_scanlog = this.getDBCollection("lookup");
		
		Set<String> collections = mongo.getDB("i3jobtrack").getCollectionNames();

		for (String collectionName : collections) {
			if(collectionName.substring(0, 4).equals("tpbk")){
				System.out.println("removing " + collectionName);
				this.deleteCollection(collectionName);
			}
	
		}
	}
	
	
	
	public static void main(String[] args){
		MongoTest2 test = new MongoTest2();
		
		//delete record
//		mongoTest.deleteRecord(filename);
		//delete coll
//		mongoTest.deleteCollection(cid+"_"+proc_id);
		//delete lookup record
//		. wabc, aabk, abak, bonk, fibk, tpbk
		
//		mongoTest.deleteLookupRecord("abak");
		
//		test.getCollections();
		
		test.deleteRecord("tpbk");
		System.out.println("Done!");
		
//		mongoTest.getLookUpRecords();


		
//		mongoTest.getBatchJob();
		//		mongoTest.insertSmsCode("24680", "1234");
		//		System.out.println("getSmsCode: " + mongoTest.getSmsCode("24680"));

	}
}
