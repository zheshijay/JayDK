package swift;

//Required Libraries
import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;
import java.io.File;
import java.util.*;

public class SwiftTest {

	String username = "system:swift";
	String password = "info141";
	String authUrl  = "http://10.8.14.36:8080/auth/v1.0/";
	AccountConfig config = new AccountConfig();
	Account account = null;
	Container container = null;

	public void ini(){
		config.setUsername(username);
		config.setPassword(password);
		config.setAuthUrl(authUrl);
		config.setAuthenticationMethod(AuthenticationMethod.BASIC);
		account = new AccountFactory(config).createAccount();
		container = account.getContainer("batchjob_container");
	}
	
	public void createNewContainer(String containerName){
		config.setUsername(username);
		config.setPassword(password);
		config.setAuthUrl(authUrl);
		config.setAuthenticationMethod(AuthenticationMethod.BASIC);
		account = new AccountFactory(config).createAccount();
		container = account.getContainer(containerName);
		container.create();

	}
	
	
	public void upload(){
		StoredObject object = container.getObject("foo.txt");
		object.uploadObject(new File("C:/Users/Zshi/Desktop/testFiles/temp/foo.txt"));
	}

	public void download(){
		StoredObject obj = container.getObject("67840760-3ce6-11e7-951e-989096a8e317");
		System.out.println("retrieve obj name: " + obj.getName());
		obj.downloadObject(new File("C:/Users/Zshi/Desktop/testFiles/temp/foo2.zip"));
	}

	public void getAllContainers(){
		System.out.println("-------------------- all containers: ");
		Collection<Container> containers = account.list();
		for (Container currentContainer : containers) {
			System.out.println(currentContainer.getName());
		}
	}

	public void getObjectsInContainer(String containerName){
		container = account.getContainer(containerName);
		
		Collection<StoredObject> objects = container.list();
		for (StoredObject currentObject : objects) {
			System.out.println("swift obj name: "+currentObject.getName() + " lastModi: " + currentObject.getLastModified());
		}
	}


	public void delete(String filename){
		StoredObject newObject = container.getObject(filename);
		newObject.delete();
		System.out.println( filename + " was removed!");
	}

	/*
	 * 	Add/Update Object Metadata
	 */
	public void addUpdateMetaData(){
		//		Add/Update Object Metadata
		//		This creates an object foo.txt from the file named foo.txt in the container my-new-container:
		Container container = account.getContainer("batchjob_container");
		StoredObject object = container.getObject("foo.txt");
		object.uploadObject(new File("foo.txt"));
	}

	public void getMetaData(){
		//				Retrieve an Object’s Metadata
		System.out.println("---------------------- Retrieve an Object’s Metadata: ");
		StoredObject object2 = container.getObject("foo.txt");
		Map<String, Object> returnedMetadata = object2.getMetadata();
		for (String name : returnedMetadata.keySet()) {
			System.out.println("META / "+name+": "+returnedMetadata.get(name));
		}
	}
	
	public static UUID getTUUID() {
		return java.util.UUID.fromString(new com.eaio.uuid.UUID().toString());
	}

	public static void main(String[] args){
		SwiftTest test = new SwiftTest();
		test.ini();


//		System.out.println("remove file: ");
//		test.delete("C:/Users/Zshi/Desktop/testFiles/foo.txt");
//		test.createNewContainer("batchjob_container");
//		test.getAllContainers();
		
//		test.upload();
//		test.delete("f9443d30-3d01-11e7-ad79-989096a8e317");
		
//		test.download();
		
		System.out.println("list files: ");
		test.getAllContainers();
		
		
		test.getObjectsInContainer("PT_batchjob_container");
		
		
//		test.createNewContainer("PT_batchjob_container");
	}

}
