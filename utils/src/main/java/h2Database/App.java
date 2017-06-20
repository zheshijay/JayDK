package h2Database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class App {

	 private EmbeddedDatabase db;


	    public void setUp() {
	        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
	    	db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("create-db.sql")
	    		.build();
	    }
	
	public static void main( String[] args )
	{
		
		App app = new App();
//		app.setUp();
		
		System.out.println("db setup is done!");
		
		ApplicationContext appContext =
				new ClassPathXmlApplicationContext("config/BeanLocations.xml");

		UserService userService = (UserService)appContext.getBean("userService");

		/** insert **/
		User user1 = new User();
//		user1.setUsrId(2);
		user1.setName("JayShi12323");
		user1.setEmail("zheshijay12323@test.com");
		userService.saveUser(user1);

//		/** select **/
//		Stock stock2 = stockBo.findByStockCode("7668");
//		System.out.println(stock2);
//
//		/** update **/
//		stock2.setStockName("HAIO-1");
//		stockBo.update(stock2);
//
//		/** delete **/
//		stockBo.delete(stock2);

		System.out.println("Done");
	}
}
