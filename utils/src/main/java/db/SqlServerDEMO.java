package db;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerDEMO {
	
	public void connect(){
		
		try {
			Driver d = (Driver)Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//			 String DB_URL = "jdbc:sqlserver://10.8.8.43:1433;databaseName=dds;user=terrence;password=per1";
			 String DB_URL = "jdbc:sqlserver://10.8.8.43:1433;databaseName=dds;user=terrence;password=perl";
			java.sql.Connection con = DriverManager.getConnection(DB_URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		SqlServerDEMO test = new SqlServerDEMO();
		test.connect();
		
	}

}
