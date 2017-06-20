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

public class SwiftDEMO {
	
	String username = "system:swift";
	String password = "test";
	String authUrl  = "http://localhost:8080/auth/v1.0/";
	AccountConfig config = new AccountConfig();
	Account account = null;
	Container container = null;

	public void ini(){
		config.setUsername(username);
		config.setPassword(password);
		config.setAuthUrl(authUrl);
		config.setAuthenticationMethod(AuthenticationMethod.BASIC);
		account = new AccountFactory(config).createAccount();
		container = account.getContainer("swiftdemo-container");
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
		StoredObject zipFileObj = container.getObject("67840760-3ce6-11e7-951e-989096a8e317");
		StoredObject txtObj = container.getObject("foo.txt");
		zipFileObj.downloadObject(new File("C:/Users/Zshi/Desktop/testFiles/temp/67840760-3ce6-11e7-951e-989096a8e317.zip"));
		txtObj.downloadObject(new File("C:/Users/Zshi/Desktop/testFiles/temp/foo.txt"));
	}

	public void getAllContainers(){
		System.out.println("All containers: ");
		Collection<Container> containers = account.list();
		for (Container currentContainer : containers) {
			System.out.println(currentContainer.getName());
		}
	}

	public void getObjectsInContainer(String containerName){
		container = account.getContainer(containerName);
		
		Collection<StoredObject> objects = container.list();
		for (StoredObject currentObject : objects) {
			System.out.println("Name: "+currentObject.getName() + " LastModified: " + currentObject.getLastModified());
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
		//This creates an object foo.txt from the file named foo2.txt in the container swiftdemo-container:
		Container container = account.getContainer("swiftdemo-container");
		StoredObject object = container.getObject("foo.txt");
		object.uploadObject(new File("foo2.txt"));
	}

	public void getMetaData(){
		StoredObject object2 = container.getObject("foo.txt");
		Map<String, Object> returnedMetadata = object2.getMetadata();
		for (String name : returnedMetadata.keySet()) {
			System.out.println("META / "+name+": "+returnedMetadata.get(name));
		}
	}

}
