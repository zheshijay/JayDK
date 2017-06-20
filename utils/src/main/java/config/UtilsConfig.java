package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Get property values use by current workspace
 * 
 * @author ZShi
 *
 */
public class UtilsConfig {
	
	public static Object getVal(String key){
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
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
		return prop.getProperty(key);
	}
	
	
	
	public static void main(String[] args) {
		UtilsConfig config = new UtilsConfig();
		System.out.println(config.getVal("owner"));
	}
}
