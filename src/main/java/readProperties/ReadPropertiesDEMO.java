package readProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesDEMO {
	
	public void readAbsPath() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("/Users/jay/app-config/jdbc.properties");
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("jdbc.mysql.fuelbid.username"));
			System.out.println(prop.getProperty("jdbc.mysql.fuelbid.password"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readFromClassPath() {
		
		System.out.println("readFromClassPath");
		
		Properties prop = new Properties();
		InputStream input = null;

		try {
			String filename = "config.properties";
			input = ReadPropertiesDEMO.class.getResourceAsStream(filename);
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("jdbc.mysql.fuelbid.username"));
			System.out.println(prop.getProperty("jdbc.mysql.fuelbid.username"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ReadPropertiesDEMO test = new ReadPropertiesDEMO();
		test.readAbsPath();
		
		
	}
}
