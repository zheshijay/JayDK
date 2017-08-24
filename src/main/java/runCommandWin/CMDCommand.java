package runCommandWin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CMDCommand {
	
	
	public void run(){

		System.out.println("Start...");
		
//		String filePath = "C:\\Program Files\\PDI\\pdi-ce-4.4.0-stable\\data-integration\\Pan.bat";
//		String CMD = " -file C:\\_pentaho_workspace\\targt_age_account_ouput_to_mongo.ktr";
//
//		try {
//			Runtime.getRuntime().exec(filePath + CMD);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		 String filePath = "C:\\pdi-ce-6.0.1.0-386\\data-integration\\Pan.bat";
//		 String CMD = " /file:\"C:\\_pentaho_workspace\\targt_age_account_ouput_to_mongo.ktr\" /level:Basic";
		
		 String filePath = "C:\\_pentaho_workspace\\myBats\\targt_dev_rabo_age_age_ouput_to_mongo.bat";
		 String CMD = "";
	        try {
	             
	            Process p = Runtime.getRuntime().exec(filePath + CMD);
	            System.out.println("Flag1");
	            System.out.println("Flag2");
	            
	            InputStream in = p.getInputStream();
	            
	            
//	            p.waitFor();
	            
	           
	            
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	             
	            int c = -1;
	            while((c = in.read()) != -1)
	            {
	            	  System.out.println("c: "+c);
	                baos.write(c);
	            }
	             
	            String response = new String(baos.toByteArray());
	            System.out.println("Response From Exe : "+response);
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		System.out.println("Done");
	
	}
	
	public static void main(String args[]) {
		CMDCommand command = new CMDCommand();
		command.run();
		
	}
	
}
