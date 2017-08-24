package mongo.utils;

import java.net.UnknownHostException;
import org.apache.log4j.Logger;
import com.mongodb.MongoClient;

public class MongoConnector {

	
	public MongoConnector(){}
	
	public static MongoClient client = null;
	
	private static Logger logger = Logger.getLogger(MongoConnector.class);

	/** 
	  * Get a mongoDB client connection.
	  * 
	  * This method will return a mongoDB client connection.
	  */
	public MongoClient getClient() throws UnknownHostException {
		if(client == null) {
			client = new MongoClient("10.8.9.55", 27017);
		}
		return client;
	}
}